(function($) {
  $.fn.headerTicker = function(settings) {
    var config = {interval: 4000, section: null};
    var _selector = $(this).selector;
    var current_layer = 1;
    var layer_1 = $("#tp_layer_1");
    var layer_2 = $("#tp_layer_2");
    var index = 3;
    var _list = $(_selector);	// get calling list
    var _animating = false;
    var _first_update = true;
    var _skip = false;

    // update config with any settings that have been passed in
    if(settings['interval']) {
      config['interval'] = settings['interval'];
    }

    if(settings['section']) {
      config['section'] = settings['section'];
    }

    // update banners
    if(settings['banners']) {
      config['banners'] = settings['banners'];
    }

    // timer object for performing actions
    var _timer = new Timer();

    // fucntion to swap the top area layers
    var swap_layers = function() {
      if(current_layer == 1) {
        layer_1.hide();
        $('.tp_text', layer_1).hide();
        current_layer = 2;
      } else {
        layer_1.show();
        $('.tp_text', layer_2).hide();
        current_layer = 1;
      }
    }

    var swap_content = function() {
      content = "";
      var item = config['banners'];
      item = item[index];

      // update the content in the layer thats not currently visible
      var layer = null;
      if(current_layer == 1) {
        // layer one is visible, change the content of layer two
        layer = $("#tp_layer_2");
      } else {
        // layer two is visible, change the content of layer one
        layer = $("#tp_layer_1");
      }

      // update the content
      layer.empty();
      layer.html(Base64.decode(item['content']));

      // swap layers
      swap_layers();

      // update the index
      index++;

      /*if((index) == config['banners'].length) {
        _timer.Stop();
        update_content();
        _timer.Start();
      }*/

      // reset the index if we have reached the end
      if((index) + 1 > config['banners'].length) {
        index = 0;
      }
    }

    var show_item = function(idx) {
        content = "";
        //last_visible_banner = index;
        var item = config['banners'];
        item = item[idx];

        // update the content in the layer thats not currently visible
        var layer = null;
        if(current_layer == 1) {
          // layer one is visible, change the content of layer two
          layer = $("#tp_layer_2");
        } else {
          // layer two is visible, change the content of layer one
          layer = $("#tp_layer_1");
        }

        // update the content
        layer.empty();
        layer.html(Base64.decode(item['content']));

        // swap layers
        swap_layers();
    }

    // function to fetch the top area content from the database
    var update_content = function() {
      var _this = this;
      $.ajax({
        type: "GET",
        url: "/ajax/get_headers",
        dataType: "json",
        data: "section=" + config['section'],
        success: function(output) {
          if(output.length != 0) {
            function build_content(idx) {
              var _content = "<div>";
              _content += "<img ";
              _content +=	"src='"+Base64.decode(output[idx]['thumbnail'])+"'";
              _content +=	"alt='"+Base64.decode(output[idx]['description'])+"'";
              _content +=	"width='84'";
              _content +=	"height='55'";
              _content +=	"class='caption-right' />";
              _content +=	"<h2>"+output[idx]['title']+"</h2>";
              _content +=	"<p>"+Base64.decode(output[idx]['short_description'])+"</p>";
              _content +=	"</div>";
              return _content;
            }

            function pausecomp(millis)
            {
              var date = new Date();
              var curDate = null;

              do { curDate = new Date(); }
              while(curDate-date < millis);
            }

            for(var i = 0; i < 5; i++) {
              if((i > 2) && (i < 5)) {
                var _inc = -3;
              } else {
                var _inc = 2;
              }

              if(_first_update == true && i == 2) {
                // if this is the first time the item is being pulled, dont
                // update the last item
                _first_update = false;
              }
              else {
                $("li:nth-child("+(i+1)+")", _list).empty().html(build_content((i+_inc)));
                config['banners'][(i+_inc)] = output[(i+_inc)];
                if(i == 2) {
                  show_item(4);
                }
              }
            }
          }
        }
      });
    }

    // main stuff here
    if (settings) $.extend(config, settings);
      this.each(function() {
        // set up event handlers

        // stop ticker when the user mouses over the ticker
        $('li', _list).bind('mouseover', function(){
          _timer.Stop();
        });

        // start ticker when the user mouses out of the ticker
        $('li', _list).bind('mouseout', function(){
          _timer.Start();
        });

        // stop ticker when the user mouses over the content
        $('#tp_layer_1').live('mouseover', function(){
          _timer.Stop();
        });

        $('#tp_layer_2').live('mouseover', function(){
          _timer.Stop();
        });

        // start ticker when the user mouses out of the content
        $('#tp_layer_1').live('mouseout', function(){
          _timer.Start();
        });

        $('#tp_layer_2').live('mouseout', function(){
          _timer.Start();
        });

        // show the description on banner mouse over
        layer_1.bind('mouseover', function(){
          if(_animating == false) {
            var tp_text = $('.tp_text', layer_1);
            if((current_layer == 1) && (!tp_text.is('visible'))) {
              $('.tp_text', layer_1).slideDown();
            }
          }
        });
        layer_2.bind('mouseover', function(){
          if((current_layer == 2) && (!$('.tp_text', layer_2).is('visible'))) {
            $('.tp_text', layer_2).slideDown();
          }
        });

        $('li', _list).each(function(_index, element) {
          $(element).bind('click', function(){
            window.location = config['banners'][_index]['link'];
          });
          $(element).css({cursor: 'pointer'});
        });

        $('li', _list).each(function(_index, element){
          $(element).bind('mouseover', function(){
            if(_animating == false) {
              var pos = $(this).offset();

              // remove the highlight from the third item before scrolling
              // the list
              $('li', _list).removeClass('highlight');
              $(this).addClass('highlight');

              $('#tp_ticker_cursor').css({
                top: (pos.top - (122+47)) + 'px',
              });
            }

            show_item(_index);
          });
        });

        // setup ticker animation
        _timer.Interval = config['interval'];	// update the interval time
        // create function to be called on timeout
        _timer.Tick = function() {
            // copy the first item and add it to the bottom of the list
            var first_item = $('li:first', _list).clone(true);
            _list.append(first_item);

            // remove the highlight from the third item before scrolling
            // the list
            $('li', _list).removeClass('highlight');

            // move the first item up
            _animating = true;
            $('li:first', _list).animate({marginTop: -63	}, 1000, function() {
              // delete first item
              $('li:first', _list).remove();

              swap_content();

              // highlight the third item
              $('li:nth-child(3)', _list).addClass('highlight');

              // reset the cursor
              $('#tp_ticker_cursor').css({
                top: '122px'
              });

              _animating = false;
            });
        };

        // start the ticker
        _timer.Start();
      });
    return this;
  };
})(jQuery);

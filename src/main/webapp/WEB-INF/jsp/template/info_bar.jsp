
      <div id="info-bar">
        <div id="info-bar-summary">
          
          <span>
            <a
              href="javascript:void(0);"
              title="<spring:message code = "home.title" />"
              id="info-bar-close"
            >
              <img
                src="${base}media/images/icons/close.png"
                alt="X"
                width="17"
                height="17"
                class="float-left"
              />
            </a>
          </span>
          <span>
            <a
              href="javascript:void(0);"
              title="<spring:message code = "home.title" />"
              id="info-bar-more"
            >
              <img
                src="${base}media/images/icons/expand.png"
                alt="+"
                width="17"
                height="17"
                class="float-left"
              />
            </a>
          </span>
          <script type="text/javascript">
            $("#info-bar-close").bind("click", function(e){
              $("#info-bar").slideUp("slow");
            });
            $("#info-bar-more").toggle(
              function() {
                $("#info-bar-more img").attr("src", "${base}media/images/icons/collapse.png");
                $("#info-bar-more img").attr("alt", "-");
                $("#info-bar-main-content").slideDown("slow");
              },
              function() {
                $("#info-bar-more img").attr("src", "${base}media/images/icons/expand.png");
                $("#info-bar-more img").attr("alt", "+");
                $("#info-bar-main-content").slideUp("slow");
              }
            );
          </script>
        </div>
        <div id="info-bar-main-content">
          Upgrade Instructions
          <ul>
            <li>
              <a href="http://www.google.co.uk/chrome" title="Chrome">
                <img src="resources/images/icons/Chrome.png"
                  title="Chrome"
                  width="256"
                  height="256"
                />
              </a>
              <p>
                <a href="http://www.google.co.uk/chrome" title="Chrome">
                 
                </a>
              </p>
            </li>
            <li>
              <a href="http://www.mozilla-europe.org/en/firefox/" title="FireFox">
                <img src="${base}media/images/icons/Firefox.png"
                  title="Firefox"
                  width="256"
                  height="256"
                />
              </a>
              <p>
                <a href="http://www.mozilla-europe.org/en/firefox/" title="Firefox">
                  
                </a>
              </p>
            </li>
            <li>
              <a href="http://www.apple.com/safari/" title="Safari">
                <img src="${base}media/images/icons/Safari.png"
                  title="Safari"
                  width="256"
                  height="256"
                />
              </a>
              <p>
                <a href="http://www.apple.com/safari/" title="Safari">
                  <spring:message code = "home.title" />
                </a>
              </p>
            </li>
          </ul>
        </div>
        <div class="clear-both"></div>
      </div>
   

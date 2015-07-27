$(document).ready(function(){
	
  // rotate blog articles
  $('#blogSlider').bxSlider({
    mode: 'fade',
    auto: true,
    pause: 5000,
    controls: false
  });
  
  // tweets slider
  $('#tweetSlider').bxSlider({
    mode: 'fade',
    auto: true,
    pause: 4000,
    controls: false
  });
  
  /* clear the value of a text input if it has a class of .blanktext */
	if($("input.text") != null) {
		$("input.text").each(function(i){
			// get the current text value
			var c_text = $(this).attr("value");
	
			if($(this).is(".blanktext") == true) {
				// toggle value on focus
				$(this).bind("focus", function(e){
					$(this).attr("value", "");
				});
	
				// reset value on blur
				$(this).bind("blur", function(e){
					if($(this).attr("value") == "") {
						$(this).attr("value", c_text);
					}
				});
			}
		});
	}
	
	/* set all external links to open in a new window */
	$("a").each(function(i){
		if($(this).attr("rel") == "external") {
			$(this).attr("target", "_blank");
		}
	});
});

// class for providing base64 encode/decode functionality
var Base64 = {
	// private property
	_keyStr : "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=",
	// public method for encoding
	encode : function (input) {
		var output = "";
		var chr1, chr2, chr3, enc1, enc2, enc3, enc4;
		var i = 0;

		input = Base64._utf8_encode(input);

		while (i < input.length) {
			chr1 = input.charCodeAt(i++);
			chr2 = input.charCodeAt(i++);
			chr3 = input.charCodeAt(i++);

			enc1 = chr1 >> 2;
			enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);
			enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);
			enc4 = chr3 & 63;

			if (isNaN(chr2)) {
				enc3 = enc4 = 64;
			} else if (isNaN(chr3)) {
				enc4 = 64;
			}

			output = output +
			this._keyStr.charAt(enc1) + this._keyStr.charAt(enc2) +
			this._keyStr.charAt(enc3) + this._keyStr.charAt(enc4);
		}
		return output;
	},
	// public method for decoding
	decode : function (input) {
		var output = "";
		var chr1, chr2, chr3;
		var enc1, enc2, enc3, enc4;
		var i = 0;

		input = input.replace(/[^A-Za-z0-9\+\/\=]/g, "");

		while (i < input.length) {
			enc1 = this._keyStr.indexOf(input.charAt(i++));
			enc2 = this._keyStr.indexOf(input.charAt(i++));
			enc3 = this._keyStr.indexOf(input.charAt(i++));
			enc4 = this._keyStr.indexOf(input.charAt(i++));

			chr1 = (enc1 << 2) | (enc2 >> 4);
			chr2 = ((enc2 & 15) << 4) | (enc3 >> 2);
			chr3 = ((enc3 & 3) << 6) | enc4;

			output = output + String.fromCharCode(chr1);

			if (enc3 != 64) {
				output = output + String.fromCharCode(chr2);
			}
			if (enc4 != 64) {
				output = output + String.fromCharCode(chr3);
			}

		}
		output = Base64._utf8_decode(output);
		return output;
	},
	// private method for UTF-8 encoding
	_utf8_encode : function (string) {
		string = string.replace(/\r\n/g,"\n");
		var utftext = "";

		for (var n = 0; n < string.length; n++) {
			var c = string.charCodeAt(n);

			if (c < 128) {
				utftext += String.fromCharCode(c);
			}
			else if((c > 127) && (c < 2048)) {
				utftext += String.fromCharCode((c >> 6) | 192);
				utftext += String.fromCharCode((c & 63) | 128);
			}
			else {
				utftext += String.fromCharCode((c >> 12) | 224);
				utftext += String.fromCharCode(((c >> 6) & 63) | 128);
				utftext += String.fromCharCode((c & 63) | 128);
			}
		}
		return utftext;
	},
	// private method for UTF-8 decoding
	_utf8_decode : function (utftext) {
		var string = "";
		var i = 0;
		var c = c1 = c2 = 0;

		while ( i < utftext.length ) {
			c = utftext.charCodeAt(i);

			if (c < 128) {
				string += String.fromCharCode(c);
				i++;
			}
			else if((c > 191) && (c < 224)) {
				c2 = utftext.charCodeAt(i+1);
				string += String.fromCharCode(((c & 31) << 6) | (c2 & 63));
				i += 2;
			}
			else {
				c2 = utftext.charCodeAt(i+1);
				c3 = utftext.charCodeAt(i+2);
				string += String.fromCharCode(((c & 15) << 12) | ((c2 & 63) << 6) | (c3 & 63));
				i += 3;
			}
		}
		return string;
	}
}

// Declaring class "Timer"
var Timer = function()
{
	// Property: Frequency of elapse event of the timer in millisecond
	this.Interval = 1000;

	// Property: Whether the timer is enable or not
	this.Enable = new Boolean(false);

	// Event: Timer tick
	this.Tick;

	// Member variable: Hold interval id of the timer
	var timerId = 0;

	// Member variable: Hold instance of this class
	var thisObject;

	// Function: Start the timer
	this.Start = function()
	{
		this.Enable = new Boolean(true);

		thisObject = this;
		if (thisObject.Enable)
		{
			thisObject.timerId = setInterval(
			function()
			{
				thisObject.Tick();
			}, thisObject.Interval);
		}
	};

	// Function: Stops the timer
	this.Stop = function()
	{
		thisObject.Enable = new Boolean(false);
		clearInterval(thisObject.timerId);
	};

};
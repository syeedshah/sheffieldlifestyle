<?php

	// start a session and get the captcha code string
	session_start();

	// get captcha key from url
	$key = $_GET["key"];

	// convert the string to upper case
	$str = strtoupper($_SESSION[$key]);

	// get the captcha size from the url
	$size = $_GET["size"];

	// set the true type font to use
	$font = $_SERVER["DOCUMENT_ROOT"] . "/media/fonts/linkin_park.ttf";

	if($size == "sml")
	{
		// start building captcha image
		$captcha = imagecreatefrompng("captcha_sml_bg.png");

		// define colours
		$yellow = imagecolorallocate($captcha, 13, 0, 76);

		imagettftext($captcha, 11, 0, 5, 17, $yellow, $font, $str);
	}
	else if($size == "lrg")
	{
		// start building captcha image
		$captcha = imagecreatefrompng("captcha_bg.png");

		// define colours
		$offwhite = imagecolorallocate($captcha, 216, 230, 230);

		imagettftext($captcha, 36, 0, 20, 46, $offwhite, $font, $str);
	}

	// output the image
	header("Content-type: image/png");
	imagepng($captcha);

	// release the image
	imagedestroy($captcha);

?>

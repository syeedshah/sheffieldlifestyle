
<!-- top-area-container start -->
<div id="top_area">

	<!-- top-area-right-container start -->
  <div id="tp_layer_1">
			
  </div>
	<div id="tp_layer_2">
  </div>

	<div id="tp_ticker">
		<ul>
			
						<li class="highlight">
							<div>
								<img
									src=""
									alt="<spring:message code = "home.title" />"
									width="84"
									height="55"
									class="caption-right" />
								<h2>${LEVEL}</h2>
								<p>${SECTION}</p>
							</div>
						</li>
					
		</ul>
	</div>

	<div id="tp_ticker_cursor"></div>

  <!-- top-area-right-container end -->

  <div class="clear-both"></div>

</div>
<!-- top-area-container end -->

<script type="text/javascript">

	$(document).ready(function(){
		$('#tp_ticker ul').headerTicker({
			banners: ,
			section: Shopping
		});
	});

</script>

<div class="clear-both"></div>
<!-- header container start -->
<div id="header-container">
	<div id="logo">
		<a href="${pageContext.request.contextPath}" title="Lfestyle Logo">
			<img src="${pageContext.request.contextPath}/resources/images/header/logo.png" alt="Lifestyle Logo" width="271" height="100"/>
		</a>
	</div>
</div>

<div class="clear-both"></div>

<div id="navigation">
	<ul>
		<li class="first"><a href="/" title="Return To The Home Page">
				<span class="icon home"></span> &nbsp;
		</a></li>
		<li class="ACCOMODATION"><a href="accommodation" title="Accom Title" > <span class="icon accommodation"></span>

		</a></li>
		<li class="BUSSINESS_DIRECTORY"><a href="business"
			title="BUSINESS"> <span class="icon business_directory"></span>

		</a></li>
		<li
			class=""
			> <a href="cityguide" title="CITY GUIDE"> <span
				class="icon city_guide"></span>

		</a>
		</li>
		<li class="JOBS"><a href="jobs" title="JOBS"> <span
				class="icon jobs"></span>

		</a></li>
		<li class="COMMUNITY"><a href="community" title="COMMUNITY">
				<span class="icon community"></span>

		</a></li>
		<li class='last'>
			<div id="nav-search">
				<form action="">
					<fieldset>
						<input type="text" class="text blanktext"
							value="Enter Search Terms" name='q' id='global_search' /> <input
							type='hidden' name='search_sections'
							value='accommodation,business,dining,thingstodo,nightlife,shopping,sports,jobs,news,lifestyle,kids' />
						<a href="search" title="Start Search"
							onclick="$('#gbl_search').trigger('submit');"> <img
							src="${pageContext.request.contextPath}/resources/images/header/go_button.jpg" alt="GO" width="31px"
							height="20" />
						</a>
					</fieldset>
				</form>
			</div>
		</li>
	</ul>
	<div class="clear-both"></div>
</div>

<div class="clear-both"></div>
<!-- header container end -->

<script type='text/javascript'>
  $(document).ready(function(){
    $("#global_search").autocomplete({
      source: function(request, response) {
        // get results from server
        $.ajax({
          type: 'POST',
          url: "/ajax/ac_global_search",
          data: {q: $("#global_search").val()},
          dataType: "json",
          success: function(data) {
            response(
              $.map(data.results, function(item){
                return {
                  label: item.name,
                  value: item.name
                }
              })
            )
          }
        });
      },
      minLength: 3,
      select: function(event, ui) {
        $("#global_search").val(ui.item.value);
        $("#gbl_search").trigger('submit');
			}
    });
  });
</script>

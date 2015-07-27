<%@ include file="template/html_header.jsp"%>

	<div id="top-strip">&nbsp;</div>
	
<%-- 	<c:if test = "${SECTION == 'BE_HOMEPAGE'}">
       <!-- info bar  -->
	<%@ include file="template/info_bar.jsp"%>
    </c:if> --%>


	

  <!-- page-container start -->
	<div id="page-container">

  	<%@ include file="template/header.jsp"%>

    <div class="clear-both"></div>

    <%@ include file="template/top_area.jsp"%>

    <!-- content-container start -->
    <div id="content-container" class=" ">

	<%@ include file="template/left_area.jsp"%>
	
	<%@ include file="template/right_area.jsp"%>

     <div class="clear-both"></div>

    </div>
    <!-- content-container end -->

  </div>
  <!-- page-container end -->
	
	<%@ include file="template/footer.jsp"%>


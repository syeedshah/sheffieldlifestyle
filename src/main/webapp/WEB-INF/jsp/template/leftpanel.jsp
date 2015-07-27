<!-- Left Panel -->
<div class="left-panel">

	<spring:url value="/typerules/view" var="typeRulesUrl"/>
	<spring:url value="/applications" var="applicationsUrl"/>
	<spring:url value="/viewUsers" var="usersUrl"/>
	<spring:url value="/generateidpmetadata" var="generateIDPUrl"/>
	<spring:url value="/authenticationMethods" var="authenticationMethodsUrl"/>
	<spring:url value="/viewLog" var="viewLogUrl"/>
	<spring:url value="/viewConfiguration" var="viewConfigurationUrl"/>

	<ul class="primary-nav">
		<li><a href="${typeRulesUrl}">Type Rules</a></li>
		<li><a href="${applicationsUrl}">Applications</a></li>
		<li><a href="${usersUrl}">Users</a></li>
		<li><a href="${authenticationMethodsUrl}">Authentication Methods</a></li>			
		<li><a href="${generateIDPUrl}">Generate Idp metadata</a></li>
       	<li><a href="${viewLogUrl}">View Log</a></li>	
		<li><a href="${viewConfigurationUrl}"><spring:message code="generalConfiguration.title" /></a></li>
	</ul>

</div>
<!-- End Left Panel -->

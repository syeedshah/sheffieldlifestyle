

<div class="column left">
	<!-- title start -->

	<div class="title">
		<h1>
			<a href="${base}${url_path}" title="View All Business">
				Business </a>
		</h1>
		<a href="" title="View All "> Browse All </a>
	</div>

	<!-- title end -->
	<div class='error'></div>
	<c:forEach items="${BUSINESS}" var="business">
		<!-- item start -->
		<div class="item">
			<div class="content">
				<div class="image">
					<a href="" title="Find Out More About"> <img src=""
						alt="Image of " width="80" height="80" />
					</a>
				</div>
			</div>
			<div class="text">
				<h2>
					<a href="" title="Find Out More About ">${business.name}</a>
				</h2>
				<p>
					<a href="" title="Find Out More About "><c:out value="${fn:substring(business.largeDescription, 0, 120)}" /></a>
				</p>
				<div class="clear-both"></div>
				<div class="button">
					<a href="" title="Find Out More About "></a>
				</div>
			</div>
			<div class="clear-both"></div>
		</div>
		<!-- item end -->
	</c:forEach>
</div>
<!-- top list items start -->
<div class="column right">
	<!-- title start -->
	<div class="title">
		<h1>
			<a href="${base}${url_path}" title="View All Kids">
				Kids </a>
		</h1>
		<a href="" title="View All "> Browse All </a>
	</div>

	<!-- title end -->
	<div class='error'></div>
	<c:forEach items="${KIDS}" var="kids">
		<!-- item start -->
		<div class="item">
			<div class="content">
				<div class="image">
					<a href="" title="Find Out More About"> <img src=""
						alt="Image of " width="80" height="80" />
					</a>
				</div>
			</div>
			<div class="text">
				<h2>
					<a href="" title="Find Out More About ">${kids.name}</a>
				</h2>
				<p>
					<a href="" title="Find Out More About "><c:out value="${fn:substring(kids.largeDescription, 0, 120)}" /></a>
				</p>
				<div class="clear-both"></div>
				<div class="button">
					<a href="" title="Find Out More About "></a>
				</div>
			</div>
			<div class="clear-both"></div>
		</div>
		<!-- item end -->
	</c:forEach>
</div>


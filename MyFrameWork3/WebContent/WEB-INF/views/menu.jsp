<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!-- #NAVIGATION -->
<!-- Left panel : Navigation area -->
<!-- Note: This width of the aside area can be adjusted through LESS/SASS variables -->
<aside id="left-panel">

	<!-- NAVIGATION : This navigation is also responsive

			To make this navigation dynamic please make sure to link the node
			(the reference to the nav > ul) after page load. Or the navigation
			will not initialize.
			-->
	<nav>
		<ul>
			<li><a href="#"><i class="fa fa-lg fa-fw fa-glass"></i> <span class="menu-item-parent">酒店服务</span></a>
				<ul>
					<li><a href="javascript:getTemplate('hotel/order',null,'content')">酒店预订</a></li>
				</ul>
			</li>
		</ul>
	</nav>


	<span class="minifyme" data-action="minifyMenu"> <i
		class="fa fa-arrow-circle-left hit"></i>
	</span>

</aside>
<!-- END NAVIGATION -->
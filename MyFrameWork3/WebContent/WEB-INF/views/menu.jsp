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
			<li><a href="#"><i class="fa fa-lg fa-fw fa-table"></i> <span class="menu-item-parent">Tables</span></a>
				<ul>
					<li><a href="ajax/table.html">Normal Tables</a></li>
					<li><a href="ajax/datatables.html">Data Tables <span
							class="badge inbox-badge bg-color-greenLight">v1.10</span></a></li>
					<li><a href="ajax/jqgrid.html">Jquery Grid</a></li>
				</ul>
			</li>
			<li><a href="#"><i class="fa fa-lg fa-fw fa-pencil-square-o"></i>
					<span class="menu-item-parent">Forms</span></a>
				<ul>
					<li><a href="ajax/form-elements.html">Smart Form Elements</a>
					</li>
					<li><a href="ajax/form-templates.html">Smart Form Layouts</a>
					</li>
					<li><a href="ajax/validation.html">Smart Form Validation</a></li>
					<li><a href="ajax/bootstrap-forms.html">Bootstrap Form
							Elements</a></li>
					<li><a href="ajax/bootstrap-validator.html">Bootstrap Form
							Validation</a></li>
					<li><a href="ajax/plugins.html">Form Plugins</a></li>
					<li><a href="ajax/wizard.html">Wizards</a></li>
					<li><a href="ajax/other-editors.html">Bootstrap Editors</a></li>
					<li><a href="ajax/dropzone.html">Dropzone</a></li>
					<li><a href="ajax/image-editor.html">Image Cropping <span
							class="badge pull-right inbox-badge bg-color-yellow">new</span></a></li>
				</ul></li>
		</ul>
	</nav>


	<span class="minifyme" data-action="minifyMenu"> <i
		class="fa fa-arrow-circle-left hit"></i>
	</span>

</aside>
<!-- END NAVIGATION -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="navbar-default sidebar" role="navigation">
	<div class="sidebar-nav navbar-collapse">
		<ul class="nav" id="side-menu">
			<li class="sidebar-search">
				<div class="input-group custom-search-form">
					<input type="text" class="form-control" placeholder="Search...">
					<span class="input-group-btn">
						<button class="btn btn-default" type="button">
							<i class="fa fa-search"></i>
						</button>
					</span>
				</div> <!-- /input-group -->
			</li>
			<li><a href="${pageContext.request.contextPath}/welcome/home"><i
					class="fa fa-dashboard fa-fw"></i>Dashboard</a></li>
			<li><a href="#"><i class="fa fa-bar-chart-o fa-fw"></i>Photo
					Gallery<span class="fa arrow"></span></a>
				<ul class="nav nav-second-level">
					<li><a href="flot.html">Events</a></li>
					<li><a href="morris.html">Projects</a></li>
				</ul> <!-- /.nav-second-level --></li>
			<li><a href="tables.html"><i class="fa fa-table fa-fw"></i>Projects</a>
				<ul class="nav nav-second-level">
					<li><a href="${pageContext.request.contextPath}/welcome/user/project/all_project">All Projects</a></li>
					<li><a href="${pageContext.request.contextPath}/welcome/admin/user/create_project">Create Project</a></li>
				</ul> <!-- /.nav-second-level --></li>
			</li>
			<li><a href="forms.html"><i class="fa fa-edit fa-fw"></i>Events</a>
			</li>
			<li><a href="#"><i class="fa fa-files-o fa-fw"></i> UI
					Elements<span class="fa arrow"></span></a>
				<ul class="nav nav-second-level">
					<li><a href="panels-wells.html">Panels and Wells</a></li>
					<li><a href="buttons.html">Buttons</a></li>
					<li><a href="notifications.html">Notifications</a></li>
					<li><a href="typography.html">Typography</a></li>
					<li><a href="icons.html"> Icons</a></li>
					<li><a href="grid.html">Grid</a></li>
				</ul> <!-- /.nav-second-level --></li>
			<li><a href="#"><i class="fa fa-sitemap fa-fw"></i>
					Multi-Level Dropdown<span class="fa arrow"></span></a>
				<ul class="nav nav-second-level">
					<li><a href="#">Second Level Item</a></li>
					<li><a href="#">Second Level Item</a></li>
					<li><a href="#">Third Level <span class="fa arrow"></span></a>
						<ul class="nav nav-third-level">
							<li><a href="#">Third Level Item</a></li>
							<li><a href="#">Third Level Item</a></li>
							<li><a href="#">Third Level Item</a></li>
							<li><a href="#">Third Level Item</a></li>
						</ul> <!-- /.nav-third-level --></li>
				</ul> <!-- /.nav-second-level --></li>
			<li><a href="#"><i class="fa fa-wrench fa-fw"></i> Admin <span
					class="fa arrow"></span></a>
				<ul class="nav nav-second-level">
					<li><a href="#">Users<span class="fa arrow"></span></a>
						<ul class="nav nav-third-level">
							<li><a
								href="${pageContext.request.contextPath}/welcome/admin/user/allUsers">All
									Users</a></li>
							<li><a
								href="${pageContext.request.contextPath}/welcome/admin/user/createUser">Create
									New Users</a></li>
						</ul> <!-- /.nav-third-level --></li>
				</ul> <!-- /.nav-second-level --></li>

		</ul>
	</div>
	<!-- /.sidebar-collapse -->
</div>

<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<!-- Fixed navbar -->
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="<%=basePath%>/">Spring tečaj</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="<%=basePath%>/">Home</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Genres <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="<%=basePath%>/genres/">Genre list</a></li>
							<li><a href="<%=basePath%>/genres/create">Create new Genre</a></li>
						</ul>
					</li>
					<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Shows <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="<%=basePath%>/shows/">Shows list</a></li>
							<li><a href="<%=basePath%>/shows/create">Create new Show</a></li>
						</ul>
					</li>
					<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Performers <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="<%=basePath%>/performers/">Performers list</a></li>
							<li><a href="<%=basePath%>/performers/create">Create new Performers</a></li>
						</ul>
					</li>
					<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><c:out value="${userFullName}" /><span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="<%=basePath%>/?language=hr">Hrvatski</a></li>
							<li><a href="<%=basePath%>/?language=en">English</a></li>
							<li><a href="<%=basePath%>/logout">Logout</a></li>
						</ul>
					</li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>
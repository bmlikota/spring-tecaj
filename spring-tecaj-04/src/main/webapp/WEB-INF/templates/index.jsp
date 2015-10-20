<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<html>
<head>
<base href="<%=basePath%>">
<title>Spring Workshop starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="description" content="Spring workshop part 04 index page">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="<%=basePath%>/resources/theme.css" >
</head>
<body role="document">
	<%@include file="navbar.jsp" %>
	
	<div class="container theme-showcase" role="main">
		
		<div class="jumbotron">
			<h1>Spring MVC example Homepage</h1>
			<p>Homepage of the demo application shows current status of the database entities.</p>
		</div>
		
		<div class="row">
        	<div class="col-sm-4">
          		<div class="panel panel-primary">
            		<div class="panel-heading">
              			<h3 class="panel-title">Genres</h3>
            		</div>
            		<div class="panel-body">
              			<span style="font-size:2.5em;" class="glyphicon glyphicon-tasks" aria-hidden="true"></span>
              			Ukupan broj Genre entiteta u db: <b>${genresCount}</b>
            		</div>
          		</div>
			</div><!-- /.col-sm-4 -->
        	<div class="col-sm-4">
          		<div class="panel panel-success">
            		<div class="panel-heading">
              			<h3 class="panel-title">Shows</h3>
            		</div>
            		<div class="panel-body">
              			<span style="font-size:2.5em;" class="glyphicon glyphicon-star-empty" aria-hidden="true"></span> 
              			Ukupan broj Show entiteta u db: <b>${showsCount}</b>
            		</div>
          		</div>
			</div><!-- /.col-sm-4 -->
			<div class="col-sm-4">
          		<div class="panel panel-warning">
            		<div class="panel-heading">
             			<h3 class="panel-title">Performers</h3>
            		</div>
            		<div class="panel-body">
              			<span style="font-size:2.5em;" class="glyphicon glyphicon-sunglasses" aria-hidden="true"></span> 
              			Ukupan broj Performer entiteta u db: <b>${performersCount}</b>
            		</div>
          		</div>
	        </div><!-- /.col-sm-4 -->
    	</div>
    	
	</div><!-- /.container -->


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	
</body>
</html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
	<%@include file="../navbar.jsp" %>
	
	<div class="container theme-showcase" >
		<a href="<%=basePath%>/genres/"> << Return to Genre list</a>
		
		<div class="page-header">
 			<h1>Create New Genre</h1>
      	</div>
      	<form:form action="${pageContext.request.contextPath}/genres/save" commandName="genreForm" cssClass="form-inline" method="POST">
      	<div class="row">
      		<div class="col-md-6">
      			<div class="form-group">
    				<label for="name">Genre name:</label>
    				<input type="text" class="form-control" id="name" name="name" value="${genreForm.name}" placeholder="Name of the Genre">
  				</div>
  				<button type="submit" class="btn btn-primary">Save new Genre</button>
  				<input type="hidden" id="genreId" name="genreId" value="${genreForm.genreId}">
      		</div>
      	</div>
      	<div class="row">
      		<form:errors path="name" cssClass="error"/>
      	</div>
		</form:form>
	</div><!-- /.container -->

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	
</body>
</html>
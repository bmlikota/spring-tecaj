<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<html>
<head>
<base href="<%=basePath%>">
<title>Create new show</title>
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
		<a href="<%=basePath%>/shows/"> << Return to Show list</a>
		
		<%@include file="../status-message.jsp" %>
		
		<div class="page-header">
 			<h1>Create New Show</h1>
      	</div>
      	
      	<div class="row">
      		<div class="col-md-6">
		      	<form:form action="${pageContext.request.contextPath}/shows/save" commandName="showForm" method="POST">
		  			<div class="form-group">
		    			<label for="name">Show name:</label>
		    			<input type="text" class="form-control" id="name" name="name" placeholder="Show name">
		  			</div>
		  			<div class="form-group">
		    			<label for="genreId">Genre:</label>
		    			<select class="form-control" id="genreId" name="genreId">
		  					<c:forEach items="${genres}" var="genre"><option value="${genre.id}">${genre.name}</option></c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label for="genreId">Seating plan:</label>
		    			<select class="form-control" id="seatingPlanId" name="seatingPlanId">
		  					<c:forEach items="${seatingPlans}" var="plan"><option value="${plan.id}">${plan.name}</option></c:forEach>
						</select>
					</div>
		  			<button type="submit" class="btn btn-primary">Save</button>
		      	</form:form>
      		</div>
      	</div><!-- /.row -->
   	</div><!-- /.container -->

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	
</body>
</html>
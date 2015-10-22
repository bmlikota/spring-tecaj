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
		
		<%@include file="../status-message.jsp" %>
		
		<div class="page-header">
 			<h1>Genre (${genreForm.genreId})</h1>
      	</div>

      	<form:form action="${pageContext.request.contextPath}/genres/save" commandName="genreForm" cssClass="form-inline" method="POST">
      	<spring:bind path="name">
      	<div class="row">
      		<div class="col-md-6">
  					<div class="form-group">
    					<label for="name">Genre name:</label>
    					<input type="text" class="form-control" id="name" name="name" value="${genreForm.name}" placeholder="Name of the Genre">
  					</div>
  					<button type="submit" class="btn btn-primary">Change name</button>
  					<input type="hidden" id="genreId" name="genreId" value="${genreForm.genreId}">
      		</div>
      	</div>
      	<div class="row">
      		<div class="col-md-6">
      			<form:errors path="name" cssClass="bg-danger" element="p"/>
      		</div>
      	</div>
      	</spring:bind>
		</form:form>
		<div class="row">
			<div class="col-md-12">
      			<h3>Available shows:</h3>
      			<table class="table">
          			<thead>
          				<th>Id</th>
          				<th>Show name</th>
          				<th>Seating plan</th>
          				<th></th>
		          	</thead>
					<tbody>
					<c:forEach items="${shows}" var="show">
						<tr>
							<td>${show.id}</td>
							<td><b><a href="<%=basePath%>/shows/${show.id}">${show.name}</a></b></td>
							<td>${show.seatingPlan.name}</td>
							<td><a href="<%=basePath%>/shows/remove-genre/${show.id}/${genre.id}" title="Remove Show"><span class="glyphicon glyphicon-remove" style="color:red" aria-hidden="true"></a></span> </td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
      		</div>
      	</div>

	</div><!-- /.container -->

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	
</body>
</html>
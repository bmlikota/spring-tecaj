<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<html>
<head>
<base href="<%=basePath%>">
<title>Show list page</title>
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
		
		<%@include file="../status-message.jsp" %>
		
		<div class="page-header">
 			<h1>Shows</h1>
      	</div>
      	<div class="row">
      		<div class="col-md-6">
      			<form class="form-inline" action="<%=basePath%>/shows/" method="POST">
  					<div class="form-group">
    					<label for="searchName">Show name</label>
    					<input type="text" class="form-control" id="searchName" name="searchName" value="" placeholder="searchName">
  					</div>
  					<button type="submit" class="btn btn-default">Search</button>
				</form>
      		</div>
      		<div class="col-md-6">
      			<form class="form-inline" action="<%=basePath%>/shows/create" method="GET">
  					<button type="submit" class="btn btn-primary">Add new Show</button>
				</form>
      		</div>
      	</div>
      	<div class="row">
        <div class="col-md-12">
          <table class="table">
          	<thead>
          		<th>Id</th>
          		<th>Show name</th>
          		<th>Genre</th>
          		<th>Seating</th>
          		<th></th>
          	</thead>
			<tbody>
			<c:forEach items="${result}" var="show">
				<tr>
					<td>${show.id}</td>
					<td><b><a href="<%=basePath%>/shows/${show.id}">${show.name}</a></b></td>
					<td>${show.genre.name}</td>
					<td>${show.seatingPlan.name}</td>
					<td><a href="<%=basePath%>/shows/delete/${show.id}" title="Delete record"><span class="glyphicon glyphicon-remove" style="color:red" aria-hidden="true"></a></span> </td>
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
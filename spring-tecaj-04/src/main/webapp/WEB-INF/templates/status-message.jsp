<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="row">
	<div class="col-md-6">
<c:forEach var="message" items="${messages}">
        <p class="${message.key}"><spring:message code="${message.value}" /></p><br />
</c:forEach>
	</div>
</div>
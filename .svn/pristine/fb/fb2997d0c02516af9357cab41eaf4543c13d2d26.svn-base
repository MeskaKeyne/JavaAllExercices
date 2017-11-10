<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="inc/header.jsp"></jsp:include>

<h2>Liste des pays</h2>

<p>
	<c:forEach var="p" items="${ requestScope.pays }" varStatus="status">
		<c:out value=" ${ p.name } (${ p.abbreviation }) " /> 
		<c:if test="${ not status.last }">, </c:if>
	</c:forEach>
</p>

<hr/>

<h2>Ajout d'un nouveau pays</h2>

<form action="${pageContext.request.contextPath}/do/insert/pays" method="post">
	<div><label>abreviation:</label> <input type="text" name="abreviation" /></div>
	<div><label>nom:</label> <input type="text" name="nom" /></div>
	<input type="submit" value="ajouter" />
</form>

<c:if test="${ not empty requestScope.erreur }">
	<p style="color: red;"> <c:out value="${ requestScope.erreur }" /> </p>
</c:if>

<jsp:include page="inc/footer.jsp"></jsp:include>
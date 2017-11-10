<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="inc/header.jsp"></jsp:include>

<h2>Liste des tags</h2>

<c:forEach var="t" items="${ requestScope.tags }" varStatus="status">
	<div>
		<span class="labelTag"><c:out value="${ t.value }" /></span> 
		<form action="${pageContext.request.contextPath}/do/delete/tag" method="post" style='display:inline;'>
			<input type="hidden" name="id" value="${ t.id }" />
			<input type="submit" value="delete" />		
		</form>
	</div>
</c:forEach>


<hr/>

<h2>Ajout d'un nouveau tag</h2>

<form action="${pageContext.request.contextPath}/do/insert/tag" method="post">
	<p>valeur: <input type="text" name="valeur" /></p>
	<input type="submit" value="ajouter" />
</form>

<c:if test="${ not empty requestScope.erreur }">
	<p style="color: red;"> <c:out value="${ requestScope.erreur }" /> </p>
</c:if>

<jsp:include page="inc/footer.jsp"></jsp:include>
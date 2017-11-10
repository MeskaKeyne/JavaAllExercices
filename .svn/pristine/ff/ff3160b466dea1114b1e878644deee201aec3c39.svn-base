<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="inc/header.jsp"></jsp:include>

	<fieldset class="content">
	<legend class="subtitle">Liste des auteurs</legend>
		<c:forEach var="a" items="${ requestScope.auteurs }" varStatus="status">
			<div class="overflow">
				<span class="liste-auteur"><c:out value="${ a.prenom } ${ a.nom }" /></span> 
				<c:if test="${a.bookCount == 0}">
					<form action="${pageContext.request.contextPath}/spring/auteurs/delete" method="post" style='display:inline;'>
						<input type="hidden" name="id" value="${ a.id }" />
						<input type="submit" value="delete" />		
					</form>
				</c:if>
			</div>
		</c:forEach>
	</fieldset>

	<fieldset class="content">
	<legend class="subtitle">Ajout d'un nouvel auteur</legend>

	<form action="${pageContext.request.contextPath}/spring/auteurs/add" method="post">
		<div class="overflow"><label>prenom:</label> <input type="text" name="prenom" /></div>
		<div class="overflow"><label>nom:</label> <input type="text" name="nom" /></div>
		<input type="submit" value="ajouter" />
	</form>
	
	<c:if test="${ not empty requestScope.erreur }">
		<p style="color: red;"> <c:out value="${ requestScope.erreur }" /> </p>
	</c:if>
	</fieldset>

<jsp:include page="inc/link.jsp"></jsp:include>
<jsp:include page="inc/footer.jsp"></jsp:include>
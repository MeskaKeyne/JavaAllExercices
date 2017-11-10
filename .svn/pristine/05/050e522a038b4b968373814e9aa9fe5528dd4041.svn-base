<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="inc/header.jsp"></jsp:include>

	<fieldset class="content">
	<legend class="subtitle">Liste des livres</legend>
		<c:forEach var="l" items="${ requestScope.livres }">
			<div class="overflow">
				<span class="liste-livre">
				<c:out value=" ${ l.titre } chez ${ l.collection.nom }" />
				</span>
				<c:if test="${l.available}">
					<a href="${pageContext.request.contextPath}/spring/livres/delete?code=${l.code}">delete</a>
				</c:if>
			</div> 
		</c:forEach>
	</fieldset>
	
	<fieldset class="content">
	<legend class="subtitle">Ajout d'un nouveau livre</legend>
	
	<form action="${pageContext.request.contextPath}/spring/livres/add" method="post">
		<div class="overflow"><label>titre:</label> <input type="text" name="titre" /></div>
		<div class="overflow"><label>n° édition:</label> <input type="text" name="edition" /></div>
		<div class="overflow"><label>date de parution:</label> <input type="text" name="parution" placeholder="dd-mm-aaaa" /></div>
		<div class="overflow"><label>nombre de pages:</label> <input type="text" name="pages" /></div>
		
		<div class="overflow"><label>collection:</label>
		<select name="collection">
			<c:forEach var="c" items="${ requestScope.collections }" varStatus="status">
				<c:choose>
					<c:when test="${ status.first }">
						<option value="${ c.id }" selected="selected"><c:out value="${ c.nom }"/></option>
					</c:when>
					<c:otherwise>
						<option value="${ c.id }"><c:out value="${ c.nom }"/></option>
					</c:otherwise>
				</c:choose>
				
			</c:forEach>
		</select>
		</div>
		
		<div class="overflow"><label>auteurs:</label>
		<select multiple name="auteurs" size="2">
			<option value="-1" selected="selected">aucun</option>
			<c:forEach var="a" items="${ requestScope.auteurs }">
				<option value="${ a.id }"><c:out value="${ a.prenom } ${ a.nom }"/></option>
			</c:forEach>
		</select>
		</div>
		
		<input type="submit" value="ajouter" />
	</form>
	
	<c:if test="${ not empty requestScope.erreur }">
		<p style="color: red;"> <c:out value="${ requestScope.erreur }" /> </p>
	</c:if>
	</fieldset>

<jsp:include page="inc/link.jsp"></jsp:include>
<jsp:include page="inc/footer.jsp"></jsp:include>
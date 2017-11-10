<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="inc/header.jsp"></jsp:include>

<h2>Liste des contacts</h2>

<c:forEach var="c" items="${ requestScope.contacts }">
	<p>
		<c:out value=" ${ c.firstname } ${ c.name }" />
		<c:if test="${ not empty c.country }">(<c:out value="${ c.country.abbreviation }" />)</c:if>
		<c:if test="${ not empty c.tags }">
			:
			<c:forEach var="t" items="${ c.tags }" varStatus="status">
				<c:out value=" ${ t.value }" />
				<c:if test="${ not status.last }"><c:out value=", " /></c:if>
			</c:forEach>		
		</c:if>
		- 
		<a href="${pageContext.request.contextPath}/do/delete/contact?id=${c.id}">delete</a>
	</p> 
</c:forEach>


<hr/>

<h2>Ajout d'un nouveau contact</h2>

<form action="${pageContext.request.contextPath}/do/insert/contact" method="post">
	<div class="overflow"><label>prenom:</label> <input type="text" name="prenom" /></div>
	<div class="overflow"><label>nom:</label> <input type="text" name="nom" /></div>
	<div class="overflow"><label>email:</label> <input type="text" name="email" /></div>
	
	<div class="overflow"><label>pays:</label>
	<select name="pays">
		<option value="-">aucun</option>
		<c:forEach var="p" items="${ requestScope.pays }">
			<option value="${ p.abbreviation }"><c:out value="${ p.name }"/></option>
		</c:forEach>
	</select>
	</div>
	
	<div class="overflow"><label>tags:</label>
	<select multiple name="tags" size="3">
		<option value="NONE">aucun</option>
		<c:forEach var="t" items="${ requestScope.tags }">
			<option value="${ t.value }"><c:out value="${ t.value }"/></option>
		</c:forEach>
	</select>
	</div>
	
	<input type="submit" value="ajouter" />
</form>

<c:if test="${ not empty requestScope.erreur }">
	<p style="color: red;"> <c:out value="${ requestScope.erreur }" /> </p>
</c:if>

<jsp:include page="inc/footer.jsp"></jsp:include>
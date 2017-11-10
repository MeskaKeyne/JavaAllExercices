<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<jsp:include page="inc/header.jsp"></jsp:include>

<h2>Recherche de contacts</h2>

<c:set var="selectedCountries" value="${requestScope['selectedCountries']}" />
<c:set var="selectedTags" value="${requestScope['selectedTags']}" />

<form action="${pageContext.request.contextPath}/do/search/go" method="post">
	
	<div class="overflow"><label>pays:</label>
	<select multiple name="pays">
		<c:choose>
			<c:when test="${fn:contains(selectedCountries, 'tous')}">
				<option value="tous" selected="selected">tous</option>
			</c:when>
			<c:otherwise>
				<option value="tous">tous</option>
			</c:otherwise>
		</c:choose>
		
		<c:forEach var="p" items="${ requestScope.pays }">
			<c:choose>
				<c:when test="${fn:contains(selectedCountries, p.abbreviation)}">
					<option value="${ p.abbreviation }" selected="selected">
					<c:out value="${ p.name }"/>
					</option>
				</c:when>
				<c:otherwise>
					<option value="${ p.abbreviation }">
					<c:out value="${ p.name }"/>
					</option>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</select>
	</div>
	
	<div class="overflow"><label>tags:</label>
	<select multiple name="tags" size="3">
		<c:choose>
			<c:when test="${fn:contains(selectedTags, 'tous')}">
				<option value="tous" selected="selected">tous</option>
			</c:when>
			<c:otherwise>
				<option value="tous">tous</option>
			</c:otherwise>
		</c:choose>
		
		<c:forEach var="t" items="${ requestScope.tags }">
			<c:choose>
				<c:when test="${fn:contains(selectedTags, t.value)}">
					<option value="${ t.value }" selected="selected">
					<c:out value="${ t.value }"/>
					</option>				
				</c:when>
				<c:otherwise>
					<option value="${ t.value }">
					<c:out value="${ t.value }"/>
					</option>	
				</c:otherwise>
			</c:choose>

		</c:forEach>
	</select>
	</div>
	
	<div class="overflow"><label>prénom ou nom:</label> <input type="text" name="fullname" value="${ requestScope['fullname'] }"/></div>
	
	<input type="submit" value="chercher" />
</form>

<c:if test="${ not empty requestScope.erreur }">
	<p style="color: red;"> <c:out value="${ requestScope.erreur }" /> </p>
</c:if>

<c:set var="contacts" value="${requestScope['contacts']}"></c:set>
<c:if test="${fn:length(contacts) > 0}">

	<hr/>
	
	<h2>Résultat de la recherche</h2>
	
	<c:forEach var="c" items="${contacts}">
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
		</p> 
	</c:forEach>
	
</c:if>

<jsp:include page="inc/footer.jsp"></jsp:include>
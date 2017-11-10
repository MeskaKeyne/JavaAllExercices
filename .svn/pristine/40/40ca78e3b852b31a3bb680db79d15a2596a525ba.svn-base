<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h3>Résoudre des calculs</h3>

<!-- Calcul c = (Calcul) request.getAttribute("nouveauCalcul") -->
<c:set var="c" value="${requestScope['nouveauCalcul']}" />
<c:set var="anciens" value="${requestScope['anciensCalculs']}"/>

<c:if test="${fn:length(anciens) > 1}">
	<h4>Anciens calculs</h4>
	<ul>
	<c:forEach var="a" items="${anciens}">
		<li>
		<c:out value="${a.operandeGauche} ${a.operation.signe} ${a.operandeDroite} = ${a.resultat}"/>
		</li>
	</c:forEach>
	</ul>
</c:if>

<c:choose>
	<c:when test="${c.resolu}">
		<p>Bravo !</p>
	</c:when>
	<c:otherwise>
		<p>Perdu, la solution était <c:out value="${c.resultat}" /></p>
	</c:otherwise>
</c:choose>

<a href="${pageContext.request.contextPath}/spring/new">rejouer</a>

</body>
</html>

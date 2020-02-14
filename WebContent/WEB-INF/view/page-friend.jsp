<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">	
	<title>Area personale amicizie</title>
	
	<!-- reference our style sheet -->
	<!-- <link type="text/css" 
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css "/> -->
	<link type="text/css" 
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style2.css "/>
		<br>
	
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>Area Amicizie</h2>
		</div>
	</div>
	<div id="container">
	<div id="lista-stato-attesa">
	
	<c:if test="${not empty listPersAttes}">
	
	</c:if>
	<c:if test="${empty listPersAttes}">
	Non hai amicizie in stato di attesa
	</c:if>
	</div>
	
	
	
	<div id="content-list-person" style="margin-left:600px">
	<h2 style="font-family:cursive;margin-block-end:0.1em">Diventa amico di persone</h2>
	<h2 style="font-family:cursive;margin-block-start:0.1em">per organizzare eventi</h2>
	<div id="list-person" style="overflow:scroll;height:200px;width:320px">
				<table>
				<tbody>
				<tr>
					<th>Nome</th>
					<th>Cognome</th>
				</tr>
				<c:forEach var="tempallPers" items="${allPerson}">
				<form:form action="saveAmico" method="GET">
					<tr><td>${tempallPers.nome}</td>
					<td>${tempallPers.cognome}</td>
					<td><input type="text" name="theId1" value="${persona1.idPersona}" style="width:10px;" "/></td>
					<td><input type="text" name="theId2" value="${tempallPers.idPersona}" style="width:10px;""/></td>
					<td><input type="submit" value="Invia Richiesta" /><td><tr>
					</form:form>			
				</c:forEach>	
				</tbody>
			</table>
		
		</div>
		</div>
	
	
	
	
	</div>


</body>

</html>
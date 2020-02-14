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
	<div id="list-person" style="width:350px;float:left">
	<i><h2 style="font-size:22px;line-height:5px">Lista di persone che devono accettare </h2></i>
	<i><h2 style="font-size:22px;height:10px">la tua richiesta di amicizia </h2></i>
	<table>
		<tbody>
		<tr>
			<th style="float:left">Nome</th>
			<th>Cognome</th>
		</tr>
		<c:forEach var="tempallPersAtt" items="${listPersAttes}">
		<tr>
		<td>${tempallPersAtt.nome}</td>
		<td>${tempallPersAtt.cognome}</td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
	</div>
	</c:if>
	<c:if test="${empty listPersAttes}">
	Non hai amicizie in stato di attesa
	</c:if>
	</div>
	
	
	
	<div id="content-list-person" style="margin-left:500px">
	<h2 style="font-family:cursive">Diventa amico di persone</h2>
	<h2 style="font-family:cursive;line-height:0px">per organizzare eventi</h2>
	<div id="list-person" style="overflow:scroll;height:200px;width:320px">
				<table>
				<tbody>
				<tr>
					<th style="float:left">Nome</th>
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
	
	
	
	<c:url var="addNewDistribution" value="/person/linkListFriendPrimary">
		    	<c:param name="theId" value="${persona1.idPersona}" /> 
	</c:url>			
			<p>
				<a href="${addNewDistribution}">Torna indietro</a>
			</p>
			
	</div>


</body>

</html>
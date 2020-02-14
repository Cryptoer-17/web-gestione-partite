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
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Area Amicizie</h2>
		</div>
	</div>
	<div id="container">
	
	 
	<c:if test="${not empty listPersAttes}">
	<br>
	<i><h2 style="font-size:22px;font-family:fantasy">Hai ancora ${lastNotify} amicizie che devono essere accettate da queste persone</h2></i>
	<i><h2 style="font-size:22px;font-family:fantasy">Ecco la lista delle persone </h2></i>
	
	<div id="lista-stato-attesa" style="width:400px;float:left">
	
	<div id="list-person" style="margin-top:20px;overflow:scroll;width:300px;height:200px" >
	<table>
		<tbody>
		<tr>
			<th style="float:left;font-family:initial;font-size:35px;width:110px">Nome</th>
			<th style="font-family:initial;font-size:30px">Cognome</th>
		</tr>
		<c:forEach var="tempallPersAtt" items="${listPersAttes}" >
		<tr >
		<td style="font-family:initial;font-size:21px">${tempallPersAtt.nome}</td>
		<td style="font-family:initial;font-size:21px">${tempallPersAtt.cognome}</td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
	</div>
	</c:if>
	<c:if test="${empty listPersAttes}">
	<div id="lista-stato-attesa" style="width:400px;float:left">
	<br>
	<i><h2 style="font-size:22px;font-family:fantasy">Tutte le richieste d'amicizia che hai inviato, sono andate a buon fine.</h2></i>
	</div>
	</c:if>
	
	
	
	
	<div id="content-list-person" style="margin-left:500px;margin-top:30px">
	<h2 style="font-family:monospace;height:50px">Diventa amico di persone</h2>
	<h2 style="font-family:monospace;line-height:0px">per organizzare eventi</h2>
	<div id="list-person" style="overflow:scroll;height:200px;width:400px;margin-top:20px">
				<table>
				<tbody>
				<tr>
					<th style="float:left;font-family:initial;font-size:30px;width:110px">Nome</th>
					<th style="font-family:initial;font-size:30px">Cognome</th>
				</tr>
				<c:forEach var="tempallPers" items="${allPerson}">
				<form:form action="saveAmico" method="GET">
					<tr><td style="font-family:initial;font-size:21px">${tempallPers.nome}</td>
					<td style="font-family:initial;font-size:21px">${tempallPers.cognome}</td>
					<td><input type="text" name="theId1" value="${persona1.idPersona}" style="width:10px;" "/></td>
					<td><input type="text" name="theId2" value="${tempallPers.idPersona}" style="width:10px;""/></td>
					<td><input type="submit" value="Invia Richiesta" /><td><tr>
					</form:form>			
				</c:forEach>	
				</tbody>
			</table>
		
		</div>
		</div>
	
	<div id="richieste da accettare">
	<c:if test="${not empty richiesteDaAccett}">
	<i><h2 style="font-size:22px;font-family:fantasy">Devi accettare la richiesta d'amicizia da parte di queste persone</h2></i>
	<div id="list-person-da-accett" style="margin-top:20px;overflow:scroll;width:300px;height:200px" >
	<table>
		<tbody>
		<tr>
			<th style="float:left;font-family:initial;font-size:35px;width:110px">Nome</th>
			<th style="font-family:initial;font-size:30px">Cognome</th>
		</tr>
		<c:forEach var="tempallPersDaAccett" items="${richiesteDaAccett}" >
		<tr >
		<td style="font-family:initial;font-size:21px">${tempallPersDaAccett.idPersona1.nome}</td>
		<td style="font-family:initial;font-size:21px">${tempallPersDaAccett.idPersona1.cognome}</td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
	</div>
	</c:if>
	<c:if test="${empty richiesteDaAccett}">
	<i><h2 style="font-size:22px;font-family:fantasy">Non hai richieste d'amicizia da altre persone.</h2></i>
	</c:if>
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
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
	
	 <div id="lista-stato-attesa" style="width:400px">
	<c:if test="${not empty listPersAttes}">
	<br>
	
	<c:if test="${countAllPersonAccept == '1'}">
	<i><h2 style="font-size:22px;font-family:fantasy">Hai ancora ${countAllPersonAccept} amicizia che deve essere accettata da questa persona.</h2></i>
	<i><h2 style="font-size:22px;font-family:fantasy">Ecco la persona: </h2></i>
	</c:if>
	<c:if test="${countAllPersonAccept != '1'}">
	<i><h2 style="font-size:22px;font-family:fantasy">Hai ancora ${countAllPersonAccept} amicizie che devono essere accettate da queste persone.</h2></i>
	<i><h2 style="font-size:22px;font-family:fantasy">Ecco la lista delle persone: </h2></i>
	</c:if>

	
	
	
	<div id="list-person" style="margin-top:20px;overflow:scroll;width:410px;height:245px;float:left" >
	<table>
		<tbody>
		<tr>
			<th style="float:left;font-family:initial;font-size:35px;width:110px">Nome</th>
			<th style="font-family:initial;font-size:30px">Cognome</th>
		</tr>
		<c:forEach var="tempallPersAtt" items="${listPersAttes}" >
		<form:form action="notSendRequest" method="GET">
		<tr >
		<td style="font-family:initial;font-size:21px">${tempallPersAtt.nome}</td>
		<td style="font-family:initial;font-size:21px">${tempallPersAtt.cognome}</td>
		<td><input type="text" name="theId1" value="${persona1.idPersona}" style="width:10px;" "/></td>
		<td><input type="text" name="theId2" value="${tempallPersAtt.idPersona}" style="width:10px;" "/></td>
		<td><input type="submit" value="Non inviare richiesta" /></td>
		</tr>
		</form:form>
		</c:forEach>

		</tbody>
	</table>
	
	</div>
	</c:if>
	</div>
	
	
	
	<c:if test="${empty listPersAttes}">
	<div id="lista-stato-attesa" style="width:410px;height:245px;margin-top:20px;float:left" >
	<br><br><br><br><br><br><br>
	<i><h2 style="font-size:22px;font-family:fantasy">Non hai nessuna tua richiesta che deve essere accettate da un'altra persona.</h2></i>
	</div>
	</c:if>
	
	
	
	
	
	<div id="content-list-person" style="margin-left:450px;width:470px;">
	<h2 style="font-family:monospace;height:50px">Diventa amico di persone</h2>
	<h2 style="font-family:monospace;line-height:0px">per organizzare eventi</h2>
	<div id="list-person" style="overflow:scroll;height:200px;width:400px">
				<table>
				<tbody>
				<tr>
					<th style="float:left;font-family:initial;font-size:30px;width:110px">Nome</th>
					<th style="font-family:initial;font-size:30px">Cognome</th>
				</tr>
				<c:forEach var="tempallPers" items="${allPerson}">
				<form:form action="saveAmico" method="GET">
					<tr><td style="font-family:sans-serif;font-size:21px">${tempallPers.nome}</td>
					<td style="font-family:sans-serif;font-size:21px">${tempallPers.cognome}</td>
					<td><input type="text" name="theId1" value="${persona1.idPersona}" style="width:10px;" "/></td>
					<td><input type="text" name="theId2" value="${tempallPers.idPersona}" style="width:10px;""/></td>
					<td><input type="submit" value="Invia Richiesta" /><td><tr>
					</form:form>			
				</c:forEach>	
				</tbody>
			</table>
		
		</div>
		</div>
	
	<div id="richieste da accettare" style="width:400px;float:left;height:200px;">
	<c:if test="${not empty richiesteDaAccett}">
	<i><h2 style="font-size:22px;font-family:fantasy">Devi accettare la richiesta d'amicizia da parte di queste persone</h2></i>
	<div id="list-person-da-accett" style="margin-top:20px;overflow:scroll;width:400px;height:200px" >
	<table>
		<tbody>
		<tr>
			<th style="float:left;font-family:initial;font-size:35px;width:110px">Nome</th>
			<th style="font-family:initial;font-size:30px">Cognome</th>
		</tr>
		<c:forEach var="tempallPersDaAccett" items="${richiesteDaAccett}" >
		<form:form action="acceptAmico" method="GET">
		<tr>
		<td style="font-family:sans-serif;font-size:21px">${tempallPersDaAccett.idPersona1.nome}</td>
		<td style="font-family:sans-serif;font-size:21px">${tempallPersDaAccett.idPersona1.cognome}</td>
		<td><input type="text" name="theId1" value="${persona1.idPersona}" style="width:10px;" "/></td>
		<td><input type="text" name="theId2" value="${tempallPersDaAccett.idPersona1.idPersona}" style="width:10px;""/></td>
		<td><input type="submit" value="Accetta" /><td>
		</form:form>
		<form:form action="blockAmico" method="GET">
		<td><input type="text" name="theId1" value="${persona1.idPersona}" style="width:10px;" "/></td>
		<td><input type="text" name="theId2" value="${tempallPersDaAccett.idPersona1.idPersona}" style="width:10px;""/></td>
		<td><input type="submit" value="Blocca" /><td>
		</tr>
		</form:form>
		</c:forEach>
		</tbody>
	</table>
	</div>
	</c:if>
	<c:if test="${empty richiesteDaAccett}">
	<div id="list-person-da-accett" style="width:400px;height:200px;float:left" >
	<br><br><br>
	<i><h2 style="font-size:22px;font-family:fantasy">Non hai richieste d'amicizia da accettare.</h2></i>
	</c:if>
	</div>
	<div id="right-block" style="width:400px;margin-left:400px">
	<c:if test="${empty listAllPersonBlock}">
	
	</c:if>
	
	
	<c:if test="${not empty listAllPersonBlock}">
	<div id="list-person-block" style="overflow:scroll;height:200px;width:400px;margin-left:50px;">
	<h2 style="font-family:monospace;height:50px">Lista di persone bloccate</h2>
	
		<table>
				<tbody>
				<tr>
					<th style="float:left;font-family:initial;font-size:30px;width:110px">Nome</th>
					<th style="font-family:initial;font-size:30px">Cognome</th>
				</tr>
				<c:forEach var="tempallPersDaAccett" items="${listAllPersonBlock}">
				<form:form action="sbloccaAmico" method="GET">
					<tr><td style="font-family:sans-serif;font-size:21px">${tempallPersDaAccett.idPersona2.nome}</td>
					<td style="font-family:sans-serif;font-size:21px">${tempallPersDaAccett.idPersona2.cognome}</td>
					<td><input type="text" name="theId1" value="${persona1.idPersona}" style="width:10px;" "/></td>
					<td><input type="text" name="theId2" value="${tempallPersDaAccett.idPersona2.idPersona}" style="width:10px;""/></td>
					<td><input type="submit" value="Sblocca" /><td><tr>
					</form:form>			
				</c:forEach>	
				</tbody>
			</table>
	</c:if>
	</div>
	</div>
	<br>
	<c:url var="addNewDistribution" value="/person/linkListFriendPrimary">
		    	<c:param name="theId" value="${persona1.idPersona}" /> 
	</c:url>			
			<p>
				<a href="${addNewDistribution}">Torna indietro</a>
			</p>
			
	</div>	


</body>

</html>
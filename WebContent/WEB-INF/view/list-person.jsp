<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE>

<html>

<head>

	<title>Page Form</title>

</head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<body>

 		<div id="wrapper">
 			<div id="header">
 				<h2>Informazioni - Evento</h2>
 			</div>
 		</div>
		
		<div id="container">
		
			<div id="content">
			
			
			<h2>Evento</h2>
			<!-- loop over and print our customers -->
				
				<c:if test="${empty eventos}">
				Non è stato inserito correttamente il tipo di evento o non è in programma.
				</c:if>
				<c:if test="${not empty eventos}">
					<c:forEach var="tempEvent" items="${eventos}">
					 ${tempEvent.tipo} ${tempEvent.orario} ${tempEvent.luogo} ${tempEvent.struttura} 
					</c:forEach>
				</c:if>
				
					
					
			<c:if test="${empty persons}">
			<br><br>	
			Non ci sono partecipanti a questo evento
			</c:if>
			
			
			
			<c:if test="${not empty persons}">
			<h3>Partecipanti all'evento</h3>
			<form:form action="partecipatePerson"  method="GET" style="float:left;height:30px;">				
			<!-- Button to partecipate at the event and non partecipate -->
				<input type="submit" value="Partecipa all'evento" class="add-button" name="partecipate"/>	
						
			<c:forEach var="tempPers" items="${person}">	
			<br><input type="text" value="${tempPers.idPersona}" name="theIdPers" style="height:1px"/>
			</c:forEach>	
			<c:forEach var="tempEvent" items="${eventos}">	
			<br><input type="text" value="${tempEvent.idEvento}" name="theIdEvent" style="height:1px"/><br>
			</c:forEach>  	
	
			</form:form >	
			<form:form action="nonPartecipatePerson" method="GET" style="height:30px">
				<input type="submit" value="Non Partecipare piu'" class="add-button" name="nonpartecipate" />
		
				<c:forEach var="tempPers" items="${person}">	
					<br><input type="text" value="${tempPers.idPersona}" name="theIdPers" style="height:1px"/>
				</c:forEach>	
				<c:forEach var="tempEvent" items="${eventos}">	
					<br><input type="text" value="${tempEvent.idEvento}" name="theIdEvent" style="height:1px"/><br>
				</c:forEach>  	
			</form:form>	
			<!-- add our html table here -->
			<div id="table-list">
				<table>
					<tr>
						<th>Nome &nbsp &nbsp &nbsp &nbsp &nbsp </th>
						<th>Cognome</th>
					</tr>
					
					<!-- loop over and print our customers -->
					<c:forEach var="tempPerson" items="${persons}">
						<tr>
							<td> ${tempPerson.nome}</td>
							<td> ${tempPerson.cognome}</td>
						</tr>	
					</c:forEach>
				
				</table>
			</div>
			</div>
			
			<br><br>
			<p>
			<a href="${pageContext.request.contextPath}/person/ShowPrimaryPage">Torna indietro</a>
			</p>		
			
		<!-- <c:forEach var="tempPers" items="${person}">	
				<input type="text" value="${tempPers.idPersona}" name="theIdPers"/>
				<a href="${pageContext.request.contextPath}/person/ShowPrimaryPage<!-- /${tempPers.idPersona} --><!-- ">Torna indietro</a> -->
		<!-- </c:forEach>	
			<c:forEach var="tempEvent" items="${eventos}">	
				<input type="text" value="${tempEvent.idEvento}" name="theIdEvent"/>
			</c:forEach> -->	 	
			<c:if test="${empty eventos}">
			Nessun evento corrispondente
			</c:if>
			</c:if>
			
			
			
		</div>


</body>

</html>
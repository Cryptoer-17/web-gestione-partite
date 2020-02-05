<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
				Non � stato inserito correttamente il tipo di evento o non � in programma.
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
					
			<!-- Button to partecipate at the event and non partecipate -->
			
			
				 <input type="submit" onclick="window.location='/person/partecipatePerson';" value="Partecipa all'evento" class="add-button" />
				<input type="submit" value="Non Partecipare piu'" class="add-button" />	
					
			<!-- add our html table here -->
			
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
			
			</c:if>
			
			<br><br>
			<p>
			<a href="${pageContext.request.contextPath}/person/ShowPrimaryPage">Torna indietro</a>
			</p>
			
			
			<c:forEach var="tempPers" items="${person}">	
					<input type="text" value="${tempPers.idPersona}" name="theIdPers"/>
			</c:forEach>	
			<c:if test="${not empty evento}">
			<br><br>	
			Non c'� evento ${evento.idEvento}
			</c:if>
			</div>
		</div>


</body>

</html>
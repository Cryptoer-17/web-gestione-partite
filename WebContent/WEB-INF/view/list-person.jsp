<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE>

<html>

<head>

	<title>Page Form</title>

</head>

<body>

 		<div id="wrapper">
 			<div id="header">
 				<h2>CRM - Person Relationship Manager</h2>
 			</div>
 		</div>
		
		<div id="container">
		
			<div id="content">
			
			
			<h2>Evento</h2>
			<!-- loop over and print our customers -->
				<c:forEach var="tempEvent" items="${(empty eventos)? eventino : eventos}">
					<h5> ${tempEvent.tipo} ${tempEvent.orario} ${tempEvent.luogo} ${tempEvent.struttura} </h5>
				</c:forEach>
			
			
			<h3>Partecipanti all'evento</h3>
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
			
			</div>
		</div>


</body>

</html>
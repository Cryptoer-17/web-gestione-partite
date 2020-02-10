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
					 ${eventos.tipo} ${eventos.orario} ${eventos.luogo} ${eventos.struttura} 
				</c:if>
				
					
					
			<c:if test="${empty persons}">
			<br><br>	
			Non ci sono partecipanti a questo evento
			</c:if>
			
			
			
			<c:if test="${not empty persons}">
			<h3>Partecipanti all'evento</h3>
			<form:form action="partecipatePerson"  method="GET" style="float:left;height:30px;">				
				<input type="submit" value="Partecipa all'evento" class="add-button" name="partecipate"/>	
							
			<br><input type="text" value="${person.idPersona}" name="theIdPers" style="height:1px"/>	
			<br><input type="text" value="${eventos.idEvento}" name="theIdEvent" style="height:1px"/><br>	
	
			</form:form >	
			<form:form action="nonPartecipatePerson" method="GET" style="height:30px">
				<input type="submit" value="Non Partecipare piu'" class="add-button" name="nonpartecipate" />
			
					<br><input type="text" value="${person.idPersona}" name="theIdPers" style="height:1px"/>	
					<br><input type="text" value="${eventos.idEvento}" name="theIdEvent" style="height:1px"/><br>
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
	
			<c:if test="${empty eventos}">
			Nessun evento corrispondente
			</c:if>
			</c:if>
			
			
			<c:url var="addNewDistribution" value="/person/listEventSearch">
		    	<c:param name="theId" value="${person.idPersona}" /> 
		    	<c:param name="theSearchName" value="${eventos.tipo}" /> 
		    </c:url>
			<p>
				<a href="${addNewDistribution}">Torna indietro</a>
			</p>
	
			
			
		</div>


</body>

</html>
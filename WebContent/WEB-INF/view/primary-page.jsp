<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE>

<html>

<head>

	<title>Primary page</title>

</head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<body>

<div id="wrapper">
		<div id="header">
			<h2>Prossimi eventi</h2>
		</div>
	</div>
	
	
	<div id="container">
		<div id="content">
		
		
	
		<form:form action="listPerson" modelAttribute="person" method="POST">
		 <br>
		 <!--  add a search box -->     
                Cerca informazioni sull'evento a cui desideri partecipare, inserendo il "Tipo": <input type="text" name="theSearchName" />
		 <input type="submit" value="Cerca" class="add-button" />
		<table>
				<tr>
					<th >Tipo &nbsp &nbsp &nbsp &nbsp &nbsp </th>
					<th>Orario &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp</th>
					<th>Luogo &nbsp &nbsp  </th>
					<th>Struttura</th>				
				</tr>				
				<!-- loop over and print our customers -->
				<c:forEach var="tempEvent" items="${eventi}">
				
					<tr>
						<td > ${tempEvent.tipo}</td>
						<td> ${tempEvent.orario}</td>
						<td> ${tempEvent.luogo}</td>
						<td> ${tempEvent.struttura}</td>
					</tr>		
				</c:forEach>		
		</table>
		
		
			<c:forEach var="tempPers" items="${person}">
					
					<input type="text" value="${tempPers.idPersona}" name="theId"/>
				</c:forEach>	
		
		
		
	
	</form:form>
		
		
		
		
	
		
		
		</div>
		
	</div>



</body>

</html>
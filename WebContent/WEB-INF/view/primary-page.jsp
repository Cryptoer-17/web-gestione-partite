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
		
		
	
		<form:form modelAttribute="evento">
		 <br>
		 <!--  add a search box -->     
                Cerca informazioni sull'evento a cui desideri partecipare, inserendo il "Tipo": <input type="text" name="theSearchName" onclick="form.action='listPerson';"  />
		 <input type="submit" value="Cerca" onclick="form.action='listPerson';" class="add-button" method="POST"/>
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
		
		<br>
		<c:if test="${person.admin==1}">
			<input type="submit" value="Crea un evento"  onclick="form.action='createEvent';" class="add-button" name="partecipate" method="POST"/>			
		<br>
		<c:if test="${not empty listcreatevent}">
		
					<table>
				<tbody>
				<tr>
					<td>
						<label>Tipo:(*)</label>
						<form:input path="tipo"/>&nbsp&nbsp&nbsp&nbsp&nbsp
										
						<label>Orario:(*)</label>
						<form:input path="orario" />
					</td>
				</tr>
				<tr>
					<td>						
						<label>Luogo :(*)</label>
						<form:input path="luogo" />&nbsp
								
						<label>Struttura:(*)</label>
						<form:input path="struttura" />
					</td>				
				</tr>							
				</tbody>
			</table>
			
			<input type="submit" value="Salva il nuovo evento" onclick="form.action='saveEvent';"  class="save"/>
			
			
			
			
			
		</c:if>
		</c:if>
		<br><br>
			<p>
				<a href="${pageContext.request.contextPath}/person/showFormForLogin">Torna indietro</a>
			</p>	
			<input type="text" value="${person.idPersona}" name="theId"/>
		
	
	
	</form:form>
		
		
		
		
	
		
		
		</div>
		
	</div>



</body>

</html>
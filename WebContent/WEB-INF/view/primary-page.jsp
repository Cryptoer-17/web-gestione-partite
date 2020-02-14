<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE>

<html>

<head>

	<title>Primary page</title>

</head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<body>
<br>
<div id="wrapper">
		<div id="header">
			<h2>Prossimi eventi</h2>
		</div>
	</div>
	
	
	<div id="container">
		<div id="content">
		<div id="notification" >
	<button type="button" class="btn btn-primary" style="width:50px;height:30px;font-size:small;padding:0px 0px 0px 0px;margin-left:750px">
	<img style="height:20px" src='<c:url value="/resources/notification.png" ></c:url>' /><span class="badge badge-light">4</span>
	</button>
		
	
		<form:form method="GET" modelAttribute="evento">
		 <br>
		 <!--  add a search box -->     
                Cerca informazioni sull'evento a cui desideri partecipare, inserendo il "Tipo": <input type="text" name="theSearchName"  />
		 <input type="submit" value="Cerca" class="add-button" onclick="form.action='listEventSearch';" />
		 <div id="left" style="width:400px;float:left" >
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
			<input type="submit" value="Crea un evento"  onclick="form.action='createEvent';" class="add-button"  method="GET"/>	
			<input type="submit" value="Rimuovi un evento"  onclick="form.action='removeEvent';" class="add-button" method="GET"/>			
		<br>
		<c:if test="${not empty listcreatevent}">
		
					<table>
				<tbody>
				<tr>
					<td>
						<label>Tipo:(*)</label>
						<form:input path="tipo"/>
					</td>
					<td>					
						<label>Orario:(*)</label>
						<form:input path="orario" />
					</td>
				</tr>
				<tr>
					<td>						
						<label>Luogo :(*)</label>
						<form:input path="luogo" />
					</td>
					<td>			
						<label>Struttura:(*)</label>
						<form:input path="struttura" />
					</td>				
				</tr>							
				</tbody>
			</table>
			
			<input type="submit" value="Salva il nuovo evento" onclick="form.action='saveEvent';"  class="save"/>
	
		</c:if>
		
		
		<c:if test="${not empty eventone}">
		<br>
		<table>
			<tbody>				
				Inserisci l'indice dell'evento che vuoi eliminare : <input type="text" name="removeEvent" onclick="form.action='removeDaoEvent';"  />				
												
			</tbody>
		</table>
		<br>
		<input type="submit" value="ELIMINA L'EVENTO" onclick="form.action='removeDaoEvent';"  class="save"/>
		</c:if>
		</c:if>
		<br><br>
				
		    <c:url var="addNewDistribution" value="/person/showFormForLogin">
		    	<c:param name="theId" value="${person.idPersona}" />  
		    </c:url>
			<p>
				<a href="${addNewDistribution}">Torna indietro</a>
			</p>
	
	
	<input type="text" value="${person.idPersona}" name="theId"/>	
	</div>	
	</form:form>
	
	<div id="right" style="overflow:hidden">
		
		<div>
		<form:form action="pageFriend" method="GET">
		<input type="text" name="theId1" value="${person.idPersona}" style="width:10px;" "/>
		<input type="submit" value="Vai alla tua area amicizia" />
		</form:form>
		</div>
	
	
	</div>
		
		
	
		
		
		</div>
		
	</div>



</body>

</html>
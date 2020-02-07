<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE>

<html>

<head>

	<title>list-event-search</title>
	
	
	
	</head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<body>

<div id="wrapper">
		<div id="header">
			<h2>Eventi ricercati :</h2>
		</div>
	</div>
	
	
	<div id="container">
		<div id="content">
		
		
				<c:if test="${empty eventos}">
				Non è stato inserito correttamente il tipo di evento o non è in programma.
				</c:if>
				<c:if test="${not empty eventos}">
					<c:forEach var="tempEvent" items="${eventos}">
					<form:form action="listPerson" method="GET" style="height:30px;">
						 ${tempEvent.tipo} &nbsp ${tempEvent.orario} &nbsp ${tempEvent.luogo} &nbsp ${tempEvent.struttura}
						 <input type="submit" value="maggiori info"  class="add-button"/><br>
						 <input type="text" value="${tempEvent.idEvento}" name="theIdEvent" style="height:1px;"/>
						 <input type="text" value="${person.idPersona}" name="theId" style="height:1px;"/>
					</form:form>
					</c:forEach>
				</c:if>
				
			
		
		
		
		
	
		
		
		</div>
		
	</div>



</body>

</html>

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
			
			
			<!-- add our html table here -->
			
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempPerson" items="${persons}">
				
					<tr>
						<td> ${tempPerson.nome}</td>
						<td> ${tempPerson.cognome}</td>
						<td> ${tempPerson.email}</td>
					</tr>
				
				
				</c:forEach>
				
			</table>
			
			</div>
		</div>


</body>

</html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE>

<html>

<head>

</head>
<body>

<div id="wrapper">
		<div id="header">
			<h2>Conferma account</h2>
		</div>
	</div>

	
	<div id="container">
	Inserisci il codice che ti è stato inviato nell'email.<br><br>
	
	<form:form action="confirmCode" modelAttribute="person" method="POST">
		Codice:<input type="text"  name="theCodeUser"><br><br>
		
			<p> Se stai riscontrando un errore, controlla il codice inserito</p>	
	
		
		
		<input type="submit" name="Submit" value="Submit" cssClass="button"/>
		<table>
				<tbody>
					<tr>
						<td><label>First name:</label><td>
						<td><form:input path="nome"/></td>
					</tr>
					<tr>
						<td><label>Last name:</label><td>
						<td><form:input path="cognome"/></td>
					</tr>
					<tr>
						<td><label>Email:</label><td>
						<td><form:input path="email"/></td>
					</tr>
					<tr>
						<td><label>Username:</label><td>
						<td><form:input path="username"/></td>
					</tr>
						<tr>
						<td><label>Password:</label><td>
						<td><form:input path="password"/></td>
					</tr>
					
					
				</tbody>
			</table>
		
		
		
	
	</form:form>
	
	
	
	
	
	
	
	</div>






</body>

</html>
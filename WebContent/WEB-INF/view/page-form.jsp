<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<head>
	<title>Register Person</title>
			
</head>

<body>

	
	<div id="wrapper">
		<div id="header">
			<h2>Web app - Eventi programmati</h2>
		</div>
	</div>
	
	
	<div id="container">
		<input type="button" value="Login Person" onclick="window.location.href='showFormForLogin'; return false;"
				class="login-button" style="margin-left:400px"/><!--da utilizzare più avanti -->
		 
		<h3>Register Person</h3>&nbsp &nbsp 
		
		<form:form action="attendPerson" modelAttribute="person" method="POST">
		
		
			
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
					
					
					<tr>
						<td><label></label><td>
						<td><input type="submit" value="Save" class="save"/></td>
					</tr>
					
					
				</tbody>
			</table>
		
		</form:form>
		
		<div style="clear; both;"></div>

		
		
	</div>
	
	
</body>


</html>
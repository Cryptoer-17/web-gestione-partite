<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<head>
	<title>Register Person</title>
			<style>
				.error {color:red}
			</style>
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
		
		<i>Riempi il form.<br> Asterisco (*) significa che è richiesto</i>
		<form:form action="attendPerson" modelAttribute="person" method="POST">
		
		
			
			<table>
				<tbody>
					<tr>
						<label>First name:(*)</label>
						<form:input path="nome"/>
						<form:errors path="nome" cssClass="error" />
					</tr>
					<tr>
						<td><label>Last name:</label><td>
						<form:input path="cognome" />
						<form:errors path="cognome" cssClass="error" />
					</tr>
					<tr>
						<td><label>Email:</label><td>
						<form:input path="email" />
						<form:errors path="email" cssClass="error" />
					</tr>
					<tr>
						<td><label>Username:</label><td>
						<form:input path="username" />
						<form:errors path="username" cssClass="error" />
					</tr>
					<tr>
						<td><label>Password:</label><td>
						<form:input path="password" />
						<form:errors path="password" cssClass="error" />
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
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
		 
		<h3>Registrazione persona</h3>&nbsp &nbsp 
		
		<i>Riempi il form.<br> Asterisco (*) significa che è richiesto il campo</i>
		<br><br>
		<form:form action="attendPerson" modelAttribute="person" method="POST">
		
		
			
			<table style="border-spacing:7px;">
				<tbody>
					<tr>
						<td><label style="border: 1px solid black;padding:5px;">First name:(*)</label></td>
						<td><form:input path="nome" style="border: 1px solid black;padding:5px;"/></td>
						<form:errors path="nome" cssClass="error" />
					</tr>
					<tr>
						<td><label style="border: 1px solid black;padding:5px;">Last name:(*)</label></td>
						<td><form:input path="cognome" style="border: 1px solid black;padding:5px;"/></td>
						<form:errors path="cognome" cssClass="error" />
					</tr>
					<tr>
						<td><label style="border: 1px solid black;padding:5px;">Email:(*)</label></td>
						<td><form:input path="email" style="border: 1px solid black;padding:5px;"/></td>
						<form:errors path="email" cssClass="error" />
					</tr>
					<tr>
						<td><label style="border: 1px solid black;padding:5px;">Username:(*)</label></td>
						<td><form:input path="username" style="border: 1px solid black;padding:5px;"/></td>
						<form:errors path="username" cssClass="error" />
					</tr>
					<tr>
						<td><label style="border: 1px solid black;padding:5px;">Password:(*)</label></td>
						<td><form:input path="password" style="border: 1px solid black;padding:5px;"/></td>
						<form:errors path="password" cssClass="error" />
					</tr>
					
					
					<tr>
						<td><input type="submit" value="Save" class="save"/></td>
					</tr>
					
					
				</tbody>
			</table>
		
			
		
		</form:form>
		
		<br>
		<c:if test="${not empty lista}">
		L'username è gia presente oppure l'email è già stata usata in precedenza.
		</c:if>
		
		<div style="clear; both;"></div>

		
		
	</div>
	
	
</body>


</html>
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
	
	<form:form action="confirmCode" modelAttribute="code" method="POST">
		Codice:<input type="text"  name="theCodeUser"><br><br>
		<input type="submit" name="Submit" value="Submit" cssClass="button"/>
	</form:form>
	
	
	<p> Se stai riscontrando un errore, controlla il codice inserito</p>	
	
	
	
	</div>






</body>

</html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE>

<html>

<head>
	
	<title>Area personale</title>
			
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>Accedi all'area personale</h2>
		</div>
	</div>

	<div id="container">
	
	
	<form:form action="confirmPerson" modelAttribute="person" method="POST">
		Username:<input type="text" name="theUserPers" /><br><br>
		Password:<input type="text"  name="theUserPass"/></td><br><br>
		<input type="submit" value="Confirm" class="confirm"/>
	</form:form>
	
	</div>


</body>

</html>
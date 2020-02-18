<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">	
	<title>Area personale</title>
	
	<!-- reference our style sheet -->
	<!-- <link type="text/css" 
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css "/> -->
	<link type="text/css" 
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style2.css "/>
		<br>
			
	
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>Accedi all'area personale</h2>
		</div>
	</div>
	<br>
	<div id="container">
	
	
	<form:form action="confirmPerson" modelAttribute="person" method="POST">
		Username:<input type="text" name="theUserPers" style="border:1px solid black">
		<br><br>
		Password:<input type="text"  name="theUserPass" style="border:1px solid black"><br><br>
		<input type="submit" name="Submit" value="Submit" cssClass="button" />
	</form:form>

	<p> Inserire correttamente i dati.</p>
	<p> Se non siete inviati alla pagina, controllare che username o password siano corretti.</p>	


	
	
	
	
	
	</div>


</body>

</html>
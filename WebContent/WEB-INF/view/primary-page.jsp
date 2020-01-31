<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE>

<html>

<head>

	<title>Primary page</title>

</head>

<body>

<div id="wrapper">
		<div id="header">
			<h2>Eventi e partecipanti</h2>
		</div>
	</div>
	
	
	<div id="container">
		<div id="content">
		
		
		 <br><br>
		 <!--  add a search box -->
            <form:form action="search" method="GET">
                Cerca evento: <input type="text" name="theSearchName" />
		 <input type="submit" value="Search" class="add-button" />
            </form:form>
		
		
		
		</div>
	</div>



</body>

</html>
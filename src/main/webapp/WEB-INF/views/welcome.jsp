<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<jsp:include page="/components/bootstrap-css-js.jsp" />
</head>
<body>

	<h3>Welcome ${userEmail}</h3>
	
	<a href="todos">Manage Todos</a>
</body>
</html>
<%@page import="com.shivam.helper.FactoryProvider"%>
<html>

<head>
	<jsp:include page="/components/bootstrap-css-js.jsp" />
</head>
<body>
<h2>Hello World!</h2>

<%
	out.println(FactoryProvider.getSessionFactory());

%>
</body>
</html>

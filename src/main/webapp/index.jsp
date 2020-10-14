<%@page import="com.shivam.helper.FactoryProvider"%>
<html>

<head>
	<jsp:include page="/components/bootstrap-css-js.jsp" />
</head>
<body >

	<div class="mt-5 text-center">
		
		<h3 style="color:orange;">Welcome to Todo-List!</h3><br>			
		<!-- <p>Here you can manage and track all your Todos</p> -->
		<img class="bg-image" alt="TodoList Image" src="images/TodoList.jpg"><br><br>
		
		<b>Get started by signing in or registering!</b><br>
		<button class="btn btn-primary mt-4 mx-3" onclick="window.location.href='login'">Login</button>
		<button class="btn btn-primary mt-4" onclick="window.location.href='register'">Register</button>
	</div>

</body>
</html>

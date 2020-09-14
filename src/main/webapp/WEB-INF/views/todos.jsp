<%@page import="java.util.ArrayList"%>
<%@page import="com.shivam.entities.Todo"%>
<%@page import="java.util.List"%>
<%@page import="com.shivam.dao.TodoDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Todos</title>
<jsp:include page="/components/bootstrap-css-js.jsp" />
</head>
<body>

	<%
		/* String email=(String)session.getAttribute("userEmail");
		TodoDao todoDao = new TodoDao();
		List<Todo> todoList = (List<Todo>)todoDao.getTodoByEmail(email); */
	%>

	<div class="container">
	
		<div class="row">
		
			<div class="col-md-2"></div>
			
			<div class="col-md-8">
			
			<div class="mt-3">
				 <a type="button" class="btn btn-success" href="add-todo">Add Todo</a>
			</div>
			
				<div class="card mt-3">
				
					<div class="card-header text-center text-primary">
						<h4>My Todo List </h4>
					</div>
					
					<div class="card-body">
						
						
							<table class="table table-striped text-center">
						
							<tr>
								<th>Description</th>
								<th>Date</th>
								<th colspan="2">Action</th>
							</tr>
						
								<c:forEach var="todo" items="${todos}">
								
									<tr>
										<td>${todo.description }</td>
										<td>${todo.targetDate }</td>
										<td> <a type="button" class="btn btn-primary" href="update-todo?id=${todo.id}">Update</a> </td>
										<td> <a type="button" class="btn btn-warning" onclick="return deleteTodo()" href="delete-todo?id=${todo.id}">Delete</a> </td>		
									</tr>
								
								</c:forEach>
							
						</table>
												
					</div>
				
				</div>
			
			</div>
			
			<div class="col-md-2"></div>
		
		</div>
	
	</div>
	
<script type="text/javascript" src="js/script.js"></script>	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Todo</title>
<jsp:include page="/components/bootstrap-css-js.jsp" />
</head>
<body>

	<div class="container">

		<div class="row">

			<div class="col-md-2"></div>

			<div class="col-md-8">

				<div class="mt-3"></div>

				<div class="card mt-3">

					<div class="card-header text-center text-primary">
						<h4>Add Todo</h4>
					</div>

					<div class="card-body">

						<form:form method="post" modelAttribute="todo">

							<form:hidden path="id" />
							
							<fieldset class="form-group">
								<form:label path="description">Description</form:label>
								<form:input path="description" type="text" class="form-control" required="required" />
								<form:errors path="description" />
							</fieldset>

							<fieldset class="form-group">
								<form:label path="targetDate">Target Date</form:label>
								<form:input path="targetDate" type="text" class="form-control" required="required" />
								<form:errors path="targetDate" />
							</fieldset>

							<button class="btn btn-primary">Save Todo</button>
							
						</form:form>

					</div>

				</div>

			</div>

			<div class="col-md-2"></div>

		</div>

	</div>


</body>
</html>
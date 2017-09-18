<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Employee</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet"/>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>

	<form:form method="POST" modelAttribute="employee" action="../editsave">
		<div class="container">
			<table class="table table-striped">
				<tr>

					<td><form:hidden path="empId" /></td>
				</tr>
				<tr>
					<td>Name :</td>
					<td><form:input path="empName" /></td>
				</tr>
				<tr>
					<td>Designation:</td>
					<td><form:input path="empDesign" /></td>
				</tr>
				<tr>
					<td>Salary :</td>
					<td><form:input path="empSal" /></td>
				</tr>
				<tr>
					<td>Street :</td>
					<td><form:input path="empAddress.street" /></td>
				</tr>
				<tr>
					<td>Area :</td>
					<td><form:input path="empAddress.area" /></td>
				</tr>
				<tr>
					<td>City :</td>
					<td><form:input path="empAddress.city" /></td>
				</tr>
				<tr>
					<td>Pin code :</td>
					<td><form:input path="empAddress.pincode" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Update"
						class="btn btn-primary btn-sm" /></td>
				</tr>
			</table>
		</div>
	</form:form>

</body>
</html>
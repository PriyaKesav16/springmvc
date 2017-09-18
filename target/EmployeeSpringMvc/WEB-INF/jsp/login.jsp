<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body onload='document.loginForm.j_username.focus();'>
	<div class="container">
		<h3>Login Page</h3>

		<%
			String errorString = (String) request.getAttribute("error");
			if (errorString != null && errorString.trim().equals("true")) {
				out.println("Incorrect login name or password. Please try again");
			}
		%>

		<form name='loginForm' action="<c:url value='login' />" method='POST'>

			<!-- <table>
			<tr>
				<td>UserName:</td>
				<td><input type='text' name='username' class="form-control"/></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password' class="form-control" /></td>
			</tr>
			<tr>
				<td><input name="submit" type="submit" value="submit" /></td>
				<td><input name="reset" type="reset" /></td>
			</tr>
		</table>
 -->
			<div class="row">
				<div class="col-md-2">
					<label>UserName</label>
				</div>
				<div class="col-md-4">
					<input type='text' name='username' class="form-control" />
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-2">
					<label>Password</label>
				</div>
				<div class="col-md-4">
					<input type='password' name='password' class="form-control" />
				</div>
			</div>

			<div class="row">
				<div class="col-sm-2"></div>
				<div class="col-sm-2">
					<input name="submit" type="submit" value="submit" class="btn btn-info btn-sm" /> 
					
					<input name="reset" type="reset" class="btn btn-default btn-sm"/>
				</div>

			</div>
		</form>

	</div>

</body>
</html>
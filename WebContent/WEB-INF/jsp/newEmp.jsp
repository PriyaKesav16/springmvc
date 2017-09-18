<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="springForm"%>   
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
     
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Employee</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<style>
.error {
	color: #ff0000;
	font-style: normal;
	font-weight: bold;
}
</style>
</head>
<body>
<div class="container">
<br/><br/>
<span style="float: right;">
    <a href="?lang=en">English</a>
    |
    <a href="?lang=sp">Spanish</a>
</span>
<b><spring:message code="emp.label.title"></spring:message></b>

	<springForm:form method="POST" modelAttribute="employee"
		action="save.do">
		<table class="table table-striped">
			<tr>
				<td><spring:message code="emp.label.empName"></spring:message></td>
				<td><springForm:input path="empName"/></td>
				<td><springForm:errors path="empName" cssClass="error" /></td>
			</tr>
			<tr>
				<td><spring:message code="emp.label.empDesign"></spring:message></td>
				<td><springForm:input path="empDesign"/></td>
				<td><springForm:errors path="empDesign" cssClass="error" /></td>
			</tr>
			<tr>
				<td><spring:message code="emp.label.empSal"></spring:message></td>
				<td><springForm:input path="empSal" /></td>
				<td><springForm:errors path="empSal" cssClass="error" /></td>
			</tr>
			<tr><td><b><spring:message code="emp.label.Adreess"></spring:message></b></td></tr>
			<tr>
				<td><spring:message code="emp.label.street"></spring:message></td>
				<td><springForm:input path="empAddress.street" /></td>
				<td><springForm:errors path="empAddress.street" cssClass="error" /></td>
			</tr>
			<tr>
				<td><spring:message code="emp.label.area"></spring:message></td>
				<td><springForm:input path="empAddress.area" /></td>
				<td><springForm:errors path="empAddress.area" cssClass="error" /></td>
			</tr>
			<tr>
				<td><spring:message code="emp.label.city"></spring:message></td>
				<td><springForm:input path="empAddress.city" /></td>
				<td><springForm:errors path="empAddress.city" cssClass="error" /></td>
			</tr>
			<tr>
				<td><spring:message code="emp.label.pincode"></spring:message></td>
				<td><springForm:input path="empAddress.pincode" /></td>
				<td><springForm:errors path="empAddress.pincode" cssClass="error" /></td>
			</tr>
			 
			
			<tr>
				<td colspan="3"><input type="submit" value="Save Employee" class="btn btn-primary btn-sm"></td>
			</tr>
		</table>

	</springForm:form>

	<a href="loggedin">Go back</a>
	</div>
	</body>
</html>
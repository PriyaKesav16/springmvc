<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="springForm"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Employee</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<!-- <script type="text/javascript">
$.fn.pageMe = function(opts){
    var $this = this,
        defaults = {
            perPage: 3,
            showPrevNext: false,
            hidePageNumbers: false
        },
        settings = $.extend(defaults, opts);
    
    var listElement = $this;
    var perPage = settings.perPage; 
    var children = listElement.children();
    var pager = $('.pager');
    
    if (typeof settings.childSelector!="undefined") {
        children = listElement.find(settings.childSelector);
    }
    
    if (typeof settings.pagerSelector!="undefined") {
        pager = $(settings.pagerSelector);
    }
    
    var numItems = children.size();
    var numPages = Math.ceil(numItems/perPage);

    pager.data("curr",0);
    
    if (settings.showPrevNext){
        $('<li><a href="#" class="prev_link">«</a></li>').appendTo(pager);
    }
    
    var curr = 0;
    while(numPages > curr && (settings.hidePageNumbers==false)){
        $('<li><a href="#" class="page_link">'+(curr+1)+'</a></li>').appendTo(pager);
        curr++;
    }
    
    if (settings.showPrevNext){
        $('<li><a href="#" class="next_link">»</a></li>').appendTo(pager);
    }
    
    pager.find('.page_link:first').addClass('active');
    pager.find('.prev_link').hide();
    if (numPages<=1) {
        pager.find('.next_link').hide();
    }
      pager.children().eq(1).addClass("active");
    
    children.hide();
    children.slice(0, perPage).show();
    
    pager.find('li .page_link').click(function(){
        var clickedPage = $(this).html().valueOf()-1;
        goTo(clickedPage,perPage);
        return false;
    });
    pager.find('li .prev_link').click(function(){
        previous();
        return false;
    });
    pager.find('li .next_link').click(function(){
        next();
        return false;
    });
    
    function previous(){
        var goToPage = parseInt(pager.data("curr")) - 1;
        goTo(goToPage);
    }
     
    function next(){
        goToPage = parseInt(pager.data("curr")) + 1;
        goTo(goToPage);
    }
    
    function goTo(page){
        var startAt = page * perPage,
            endOn = startAt + perPage;
        
        children.css('display','none').slice(startAt, endOn).show();
        
        if (page>=1) {
            pager.find('.prev_link').show();
        }
        else {
            pager.find('.prev_link').hide();
        }
        
        if (page<(numPages-1)) {
            pager.find('.next_link').show();
        }
        else {
            pager.find('.next_link').hide();
        }
        
        pager.data("curr",page);
      	pager.children().removeClass("active");
        pager.children().eq(page+1).addClass("active");
    
    }
};

$(document).ready(function(){
    
  $('#myTable').pageMe({pagerSelector:'#myPager',showPrevNext:true,hidePageNumbers:false,perPage:4});
    
});
</script>
 -->
</head>
<body>
	<div class="container">

		<h2>List of Employees</h2>
		<h4>
			<a href="addemp">Add More Employee</a>
		</h4>
		<springForm:form modelAttribute="employees">
			<c:if test="${!empty employees}">
				<table class="table table-striped" align="left" border="1">
					<thead>
						<tr>
							<th>Employee ID</th>
							<th>Employee Name</th>
							<th>Designation</th>
							<th>Salary</th>
							<th>Street</th>
							<th>Area</th>
							<th>City</th>
							<th>Pin code</th>
							<th>Action</th>

						</tr>
					</thead>
					<tbody id="myTable">
						<c:forEach items="${employees}" var="employee">
							<tr>
								<td><c:out value="${employee.empId}" /></td>
								<td><c:out value="${employee.empName}" /></td>
								<td><c:out value="${employee.empDesign}" /></td>
								<td><c:out value="${employee.empSal}" /></td>
								<td><c:out value="${employee.empAddress.street}" /></td>
								<td><c:out value="${employee.empAddress.area}" /></td>
								<td><c:out value="${employee.empAddress.city}" /></td>
								<td><c:out value="${employee.empAddress.pincode}" /></td>
								<td align="center"><a href="edit/${employee.empId}"> <span
										class="glyphicon glyphicon-edit">Edit</span></a> | <a
									href="delete/${employee.empId}"><span
										class="glyphicon glyphicon-trash">Delete</span></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
			
			<display:table name="employees" requestURI="/employees" pagesize="5" class="table table-striped">
			 <display:column property="empName" title="Employee Name" sortable="true"/>
			  <display:column property="empDesign" title="Designation" sortable="true"/>
			   <display:column property="empSal" title="Salary" sortable="true"/>
			    <display:column property="empAddress.street" title="Street" sortable="true"/>
			     <display:column property="empAddress.area" title="Area" sortable="true"/>
			      <display:column property="empAddress.city" title="City" sortable="true"/>
			       <display:column property="empAddress.pincode" title="Pincode" sortable="true"/>
			      
			       <display:column title="Action" value="Edit" href="editEmp.jsp"  media="html" paramId="${empId}" paramProperty="empId">
			       <a href="edit/${employee.empId}"> <span
										class="glyphicon glyphicon-edit">Edit</span></a> | <a
									href="delete/${employee.empId}"><span
										class="glyphicon glyphicon-trash">Delete</span></a>
			       </display:column>
			 
			</display:table>


		</springForm:form>
		<spring:url value="/report/?type=pdf" var="pdfURL" />
		<spring:url value="/report/?type=xls" var="xlsURL" />
		<a href="${pdfURL}"><span class="glyphicon glyphicon-export"></span>Download
			Pdf</a> | <a href="${xlsURL}"><span
			class="glyphicon glyphicon-export"></span>Download Excel</a> | <a
			href="csvreport"><span class="glyphicon glyphicon-export"></span>Download
			CSV</a>
	</div>
</body>
</html>
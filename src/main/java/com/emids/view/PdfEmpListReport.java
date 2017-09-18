package com.emids.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.emids.model.Employee;
import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

public class PdfEmpListReport extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setHeader("Content-Disposition", "attachment;  filename=\"" + "employee_List.pdf" + "\";");
		
		@SuppressWarnings("unchecked")
		List<Employee> empList =  (List<Employee>) model.get("employeeList");
		
		Table table = new Table(7); 
		table.addCell("Employee Name");
		table.addCell("Designation");
		table.addCell("Salary");
		table.addCell("Street");
		table.addCell("Area");
		table.addCell("City");
		table.addCell("Pincode");
		
		for(Employee employee: empList){
			table.addCell(String.valueOf(employee.getEmpName()));
			table.addCell(String.valueOf(employee.getEmpDesign()));
			table.addCell(String.valueOf(employee.getEmpSal()));
			table.addCell(String.valueOf(employee.getEmpAddress().getStreet()));
			table.addCell(String.valueOf(employee.getEmpAddress().getArea()));
			table.addCell(String.valueOf(employee.getEmpAddress().getCity()));
			table.addCell(String.valueOf(employee.getEmpAddress().getPincode()));
			
		}
		
		document.add(table);
		
	}

}

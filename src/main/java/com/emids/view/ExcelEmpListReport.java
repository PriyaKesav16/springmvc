package com.emids.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.emids.model.Employee;

public class ExcelEmpListReport extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setHeader("Content-Disposition", "attachment;  filename=\"" + "employee_List.xls" + "\";");
		
		@SuppressWarnings("unchecked")
		List<Employee> empList =  (List<Employee>) model.get("employeeList");
		
		Sheet sheet = workbook.createSheet("Employee List");
		Row header = sheet.createRow(0);
		header.createCell(0).setCellValue("Employee Name");
		header.createCell(1).setCellValue("Designation");
		header.createCell(2).setCellValue("Salary");
		header.createCell(3).setCellValue("Street");
		header.createCell(4).setCellValue("Area");
		header.createCell(5).setCellValue("City");
		header.createCell(6).setCellValue("Pincode");
		
		int rowNum = 1;
		
		for(Employee employee:empList ){
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(employee.getEmpName());
			row.createCell(1).setCellValue(employee.getEmpDesign());
			row.createCell(2).setCellValue(employee.getEmpSal());
			row.createCell(3).setCellValue(employee.getEmpAddress().getStreet());
			row.createCell(4).setCellValue(employee.getEmpAddress().getArea());
			row.createCell(5).setCellValue(employee.getEmpAddress().getCity());
			row.createCell(6).setCellValue(employee.getEmpAddress().getPincode());
			
		}
		
	}

	
}

package com.emids.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.emids.model.Employee;

public class CsvEmpListReport extends AbstractView {

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/csv;charset=utf-8");
		response.setHeader("Content-Disposition", "attachment;  filename=\"" + "employee_List.csv" + "\";");
		
		@SuppressWarnings("unchecked")
		List<Employee> empList =  (List<Employee>) model.get("csvempList");
		
		ICsvBeanWriter csvwriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
		
		 String[] header = { "Name", "Designation", "Salary", "Adress"};
		 String[] fieldMapping = new String[] { "empName", "empDesign", "empSal", "empAddress"};

		 csvwriter.writeHeader(header);
		
		for(Employee emp:empList){
			/*csvwriter.write(emp.getEmpName(),fieldMapping[0]);
			csvwriter.write(emp.getEmpDesign(), fieldMapping[1]);
			csvwriter.write(emp.getEmpSal(), fieldMapping[2]);
			csvwriter.write(emp.getEmpAddress().getStreet(), fieldMapping[3]);
			csvwriter.write(emp.getEmpAddress().getArea(), fieldMapping[3]);
			csvwriter.write(emp.getEmpAddress().getCity(), fieldMapping[3]);
			csvwriter.write(emp.getEmpAddress().getPincode(), fieldMapping[3]);*/
			csvwriter.write(emp, fieldMapping);
		}
		
		csvwriter.close();
	}

}

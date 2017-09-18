package com.emids.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.emids.model.Employee;
import com.emids.service.EmployeeService;
import com.emids.view.CsvEmpListReport;
import com.emids.view.ExcelEmpListReport;
import com.emids.view.PdfEmpListReport;

@Controller
public class EmployeeController {

	@Autowired
	@Qualifier("employeeService")
	private EmployeeService employeeService;

	/* Redirecting to save employee */
	@RequestMapping(value = "/addemp", method = RequestMethod.GET)
	public ModelAndView addemployee(Model model) {

		String msg = "hello spring";
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return new ModelAndView("newEmp", "msg", msg);
	}

	/* Saving a new employee */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute("employee")  @Valid Employee employee, BindingResult result) {

		  if(result.hasErrors()) {
	    	    return new ModelAndView("newEmp");
	        }
		
		  if (employee.getEmpId() == 0) {
			employeeService.addEmployee(employee);
		} else {
			employeeService.updateEmployee(employee);
		}
		return new ModelAndView("redirect:/employees");
	}

	/* Retrieving all employee */
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public ModelAndView listEmployees() {

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employees", employeeService.listEmployeess());
		return new ModelAndView("viewAllEmp", model);
	}

	/* Getting employee Id to edit */
	@RequestMapping(value = "/edit/{id}")
	public ModelAndView editEmployee(@PathVariable int id, Model model) {
		Employee emp = employeeService.getEmployee(id);

		model.addAttribute("employee", emp);
		
		// System.out.println(employeeService.getEmployee(employee.getEmpId()));
		return new ModelAndView("editEmp", "emp", emp);
	}

	/* Updating the employee */
	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public ModelAndView editsave(@ModelAttribute("emp") Employee emp) {
		employeeService.updateEmployee(emp);
		return new ModelAndView("redirect:/employees");
	}

	/* Deleting Employee */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(@PathVariable int id) {

		employeeService.deleteEmployee(id);
		return new ModelAndView("redirect:/employees");
	}

	
	 @RequestMapping("/helloworld")
	 public ModelAndView hello(ModelMap model,Principal principal) {

	  String loggedInUserName=principal.getName();
	  
	  return new ModelAndView("loggedin", "userName", loggedInUserName);
	 }

	 @RequestMapping(value="/login", method = RequestMethod.GET)
	 public String login(ModelMap model) {

	  return "login";

	 }

	 @RequestMapping(value="/loginError", method = RequestMethod.GET)
	 public String loginError(ModelMap model) {
	  model.addAttribute("error", "true");
	  return "login";

	 }
	 
	 @RequestMapping(value="/loggedin", method = RequestMethod.GET)
	 public ModelAndView goback(){
		 return new ModelAndView("loggedin");
	 }
	 
	 @RequestMapping(value="/report", method = RequestMethod.GET)
	 public ModelAndView employeepdfReport(HttpServletRequest req, HttpServletResponse res){
		 
		 String typeReport = req.getParameter("type");
		 List<Employee> emp = new ArrayList<Employee>();
		 emp.addAll(employeeService.listEmployeess());
		
		 if(typeReport != null && typeReport.equals("pdf")){
			 return new ModelAndView(new PdfEmpListReport(),"employeeList", emp);
		 }else if(typeReport != null && typeReport.equals("xls")){
			 return new ModelAndView(new ExcelEmpListReport(),"employeeList", emp);
		 }
		
		 return new ModelAndView("loggedin");
	 }
	 
	 @RequestMapping(value="/csvreport", method= RequestMethod.GET)
	 public ModelAndView empCsvReport(HttpServletRequest request ,HttpServletResponse response){

		/* String[] header = { "Name", "Designation", "Salary", "Street",
	                "Area", "City", "Pincode" };*/
		 
		 List<Employee> emp = employeeService.listEmployeess();
		/* ModelAndView model = new ModelAndView("viewCsv");
		 model.addObject("csvempList",emp);
		 model.addObject("csvHeader",header);*/
		 
		 
		 return new ModelAndView(new CsvEmpListReport(), "csvempList", emp);
	 }
	
	 
	 @RequestMapping("/getallemp")
	 public @ResponseBody List<Employee> getAllemp(){
	
		 List<Employee> emp = employeeService.listEmployeess();
		 return emp;
		 
	 }
}

package com.adjecti.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.adjecti.spring.dto.EmployeeRegistrationDTO;
import com.adjecti.spring.service.EmployeeRegistrationService;

@RestController
@RequestMapping("/admin")
public class EmployeeRegisterController {
	@Autowired
	private EmployeeRegistrationService employeeService;
	
	public static int empId;
	
	public static int getEmpId() {
		return empId;
	}

	public static void setEmpId(int empId) {
		EmployeeRegisterController.empId = empId;
	}
	
	@RequestMapping(value = "/")
	public ModelAndView AdminLogin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin_home_deshboard");
		return mv;
	}

	@RequestMapping("/home")
	public ModelAndView firstHomePage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin_home_deshboard");
		return mv;
	}

	@RequestMapping("/logout")
	public ModelAndView logoutPage(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		mv.setViewName("loginPage");
		return mv;
	}

	@RequestMapping("/employeeRegistration")
	public ModelAndView EmployeeRegistrationView() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employee_registration");
		return mv;
	}

	@RequestMapping("/employee_registration")
	public ModelAndView getPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employee_registration");
		return mv;
	}

	@RequestMapping(value = "/employee_form", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("emp") EmployeeRegistrationDTO emp) {
		int id = employeeService.addDetailsService(emp);
		System.out.println("id    "+id);
		setEmpId(id);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:viewemp");
		return mv;

	}

	@RequestMapping("/viewemp")
	public ModelAndView viewemp() {
		ModelAndView modelAndView = new ModelAndView();
		List<EmployeeRegistrationDTO> employeeRegistrationDTOList = employeeService.getEmployeeRegistration();
		modelAndView.addObject("list", employeeRegistrationDTOList);
		modelAndView.setViewName("show");
		return modelAndView;

	}

	@RequestMapping("/viewalldetails/{id}")
	public ModelAndView viewAllDetails(@PathVariable("id") int employeeId) {
		ModelAndView modelAndView = new ModelAndView();
		EmployeeRegistrationDTO employeeRegistrationDTO = employeeService.getEmployeeRegistrationById(employeeId);
		System.out.println("*******" + employeeRegistrationDTO);
		modelAndView.addObject("employeeFullDetails", employeeRegistrationDTO);
		modelAndView.setViewName("view_all_details");
		return modelAndView;

	}

	@RequestMapping(value = "/delete_employee/{employeeId}", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(@PathVariable("employeeId") int employeeId) {
		System.out.println("----------delete employee----------" + employeeId);
		ModelAndView modelAndView = new ModelAndView();
		employeeService.deleteEmployeeRegistration(employeeId);
		modelAndView.setViewName("redirect:/admin/viewemp");
		return modelAndView;

	}

	@RequestMapping("/update")
	public ModelAndView UpdateForm(@RequestParam("employeeId") int employeeId) {
		ModelAndView modelAndView = new ModelAndView("EmployeeUpdate");
		EmployeeRegistrationDTO employee = employeeService.getEmployeeRegistrationById(employeeId);
		modelAndView.addObject("EmployeeUpdate", employee);
		modelAndView.setViewName("update_form");

		return modelAndView;

	}

	@RequestMapping(value = "/updateform", method = RequestMethod.POST)
	public ModelAndView updateSave(@RequestParam("employeeId") int employeeId,
			@ModelAttribute EmployeeRegistrationDTO employee) {
		System.out.println("------updated....-----" + employee.getEmployeeId());
		ModelAndView modelAndView = new ModelAndView();

		employeeService.updateEmployeeRegistration(employee);

		modelAndView.setViewName("redirect:viewemp");

		return modelAndView;

	}

	

	/*
	 * @RequestMapping(value="/file_upload",method=RequestMethod.POST) public String
	 * FileUpload(HttpServletRequest req) throws IOException { DiskFileItemFactory
	 * factory = new DiskFileItemFactory(); factory.setRepository(new File("E://"));
	 * ServletFileUpload upload = new ServletFileUpload(factory);
	 * upload.setFileSizeMax(20*1024*1024);
	 * 
	 * boolean status = ServletFileUpload.isMultipartContent(req); if(status) {
	 * String currentprojectlocation = req.getServletContext().getRealPath("/");
	 * File folder =new File(currentprojectlocation,"profileImages");
	 * if(!folder.exists()) folder.mkdir();
	 * 
	 * File file = File.createTempFile("profile", ".jpg", folder);
	 * System.out.println(file.getAbsolutePath());
	 * 
	 * try { List<FileItem> formItems = upload.parseRequest(req); Iterator<FileItem>
	 * it =formItems.iterator(); while(it.hasNext()) {
	 * 
	 * FileItem fileItem = it.next(); if(!fileItem.isFormField()) { // file upload
	 * 
	 * System.out.println(fileItem.getName());
	 * System.out.println(fileItem.getContentType());
	 * System.out.println(fileItem.get()); System.out.println(fileItem.getSize());
	 * System.out.println(fileItem.getFieldName());
	 * 
	 * FileOutputStream fo = new FileOutputStream(file); fo.write(fileItem.get());
	 * fo.close(); System.out.println(file.getAbsolutePath());
	 * 
	 * 
	 * } } } catch (FileUploadException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * 
	 * } return "demo"; }
	 */

	/*
	 * @RequestMapping(value = "/file_upload_page", method = RequestMethod.GET)
	 * public String FileUploadPage() { return "fileupload"; }
	 */
}

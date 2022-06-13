package com.adjecti.spring.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.adjecti.spring.dto.PersonalDetailsDTO;
import com.adjecti.spring.service.EmployeeRegistrationService;
import com.adjecti.spring.service.PersonalDetailService;

@Controller
@RequestMapping("/user")
public class EmployeeController {
	private static final String UPLOAD_DIRECTORY = "/uploadedphotos";

	@Autowired
	PersonalDetailService personalService;

	@Autowired
	EmployeeRegistrationService employeeService;

	/*
	 * @Autowired private EducationDetailsService educationdetailsService;
	 */

	@RequestMapping(value = "/")
	public ModelAndView AdminLogin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employeehomepage");
		return mv;
	}

	@RequestMapping("/home")
	public ModelAndView firstHomePage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employeehomepage");
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

	@RequestMapping("/personal_navbar")
	public ModelAndView showPersonalDetails() {
		ModelAndView modelAndView = new ModelAndView();
	//	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	///	System.out.println(authentication.getName());
	//	 employeeService.getEmployeeRegistration(authentication.getName());
		
		//  System.out.println("Employee ..... details" + employee);
		 // modelAndView.addObject("personalInfo", employee);
		 

		modelAndView.setViewName("personalDetails");
		return modelAndView;

	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView SaveAndUpload(@Validated @ModelAttribute("personalData") PersonalDetailsDTO pDetails,
			HttpSession session, Errors errors) throws IOException {
		ServletContext context = session.getServletContext();

		if (errors.hasErrors()) {
			System.out.println("--------------------errors========================>deepu<-----------------" + errors);
			return new ModelAndView("error", "filefailure", "File Not Uploaded");
		} else {

			String path = context.getRealPath(UPLOAD_DIRECTORY);
			String aadharfilename = pDetails.getAadharFile().getOriginalFilename();
			String panfilename = pDetails.getPanFile().getOriginalFilename();

			System.out.println(path + " " + "file name <><><><>" + aadharfilename);
			System.out.println(path + " " + "file name <><><><>" + panfilename);

			byte[] bytes = pDetails.getAadharFile().getBytes();
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File(path + File.separator + aadharfilename)));
			stream.write(bytes);
			stream.flush();
			stream.close();
			byte[] bytes1 = pDetails.getPanFile().getBytes();
			BufferedOutputStream stream1 = new BufferedOutputStream(
					new FileOutputStream(new File(path + File.separator + panfilename)));
			stream1.write(bytes1);
			stream1.flush();
			stream1.close();

			pDetails.setAadharFileName(aadharfilename);
			pDetails.setPanFileName(panfilename);
			personalService.savePersonalDetail(pDetails);
			return new ModelAndView("demo", "filesuccess", "File successfully saved!");
		}
	}

	@RequestMapping(value = "/uploadfile", method = RequestMethod.POST)
	public String uploadFile(@RequestParam("FilePath") CommonsMultipartFile file, HttpSession s, Model model) {
		System.out.println("file uploading .....");

		byte[] data = file.getBytes();
		String path = s.getServletContext().getRealPath("/") + "WEB-INF" + File.separator + "resources" + File.separator
				+ "images" + File.separator + file.getOriginalFilename();
		System.out.println("path");
		try {
			FileOutputStream fos = new FileOutputStream(path);
			fos.write(data);
			fos.close();
			System.out.println("file Uploaded");
			model.addAttribute("msg", "uploaded successfully");
			model.addAttribute("filename", file.getOriginalFilename());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

			System.out.println("uploading error");
			model.addAttribute("msg", "uploaded error");

		}

		return "demo";
	}

	// Education details controller are here

	/*
	 * @RequestMapping("/show_education_details") public ModelAndView
	 * showEducationTable() {
	 * 
	 * ModelAndView modelAndView = new ModelAndView(); Authentication authentication
	 * = SecurityContextHolder.getContext().getAuthentication(); Employee employee =
	 * employeeService.getEmployeeByCodeService(authentication.getName());
	 * System.out.println("Employee ..... details" + employee);
	 * modelAndView.addObject("educationDetails", employee);
	 * 
	 * List<EducationDetails> eList =
	 * educationdetailsService.getEducationDetailsService();
	 * System.out.println("dddddddddd,.,.,.,.<?<?<?<" + eList);
	 * 
	 * for (EducationDetails educationDetails : eList) {
	 * System.out.println("------->------->------->" +
	 * educationDetails.getEmployee().getEmployeeId()); if
	 * (educationDetails.getEmployee().getEmployeeId() == employee.getEmployeeId())
	 * { System.out.println("-------educationDetails------->" + educationDetails);
	 * modelAndView.addObject("empEducationDetails", educationDetails); } }
	 * modelAndView.setViewName("showeducationdetails"); return modelAndView;
	 * 
	 * }
	 */

	/*
	 * @RequestMapping(value = "/saveEducation", method = RequestMethod.POST) public
	 * ModelAndView saveEducationDetails(@Valid @ModelAttribute("educationData")
	 * EducationDetails eDetails,
	 * 
	 * @RequestParam("employeeId") int empId, HttpSession session, Errors errors,
	 * Principal principal) throws IOException {
	 * 
	 * ModelAndView modelAndView = new ModelAndView(); ServletContext context =
	 * session.getServletContext(); if (errors.hasErrors()) {
	 * System.out.println("-----errors========>deepu<-----" + errors); return new
	 * ModelAndView("error", "filefailure", "File Not Uploaded"); } else {
	 * 
	 * String path = context.getRealPath(UPLOAD_DIRECTORY); String
	 * certificateFileName = eDetails.getCertificateFile().getOriginalFilename();
	 * System.out.println(path + " " + "file name <><><><>" + certificateFileName);
	 * 
	 * byte[] bytes = eDetails.getCertificateFile().getBytes(); BufferedOutputStream
	 * stream = new BufferedOutputStream( new FileOutputStream(new File(path +
	 * File.separator + certificateFileName))); stream.write(bytes); stream.flush();
	 * stream.close(); eDetails.setCertificateName(certificateFileName); Employee
	 * employee = employeeService.getEmployeeByIdService(empId);
	 * System.out.println("------------->" + employee + "<---------------");
	 * System.out.println("<><>Employee code <><" + employee.getEmployeeCode());
	 * eDetails.setEmployee(employee);
	 * educationdetailsService.addEducationDetailsService(eDetails);
	 * 
	 * List<EducationDetails> educationlist =
	 * educationdetailsService.getEducationDetailsService();
	 * 
	 * modelAndView.addObject("educationlist", educationlist);
	 * modelAndView.setViewName("redirect:/user/show_education_details"); return
	 * modelAndView; }
	 * 
	 * }
	 */

}

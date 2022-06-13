package com.adjecti.spring.service;

import java.util.List;

import com.adjecti.spring.dto.EmployeeRegistrationDTO;
import com.adjecti.spring.entity.EmployeeRegistration;

public interface EmployeeRegistrationService {
	public int addDetailsService(EmployeeRegistrationDTO employee);
	public List<EmployeeRegistrationDTO> getEmployeeRegistration();
	public EmployeeRegistrationDTO getEmployeeRegistrationById(int employeeId);
	public void deleteEmployeeRegistration(int employeeId);
	public void updateEmployeeRegistration(EmployeeRegistrationDTO employee);
//	public EmployeeRegistration getbyemployeeId(Integer employeeId);
}
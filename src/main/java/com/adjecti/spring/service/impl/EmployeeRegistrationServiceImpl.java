package com.adjecti.spring.service.impl;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.adjecti.spring.dto.EmployeeRegistrationDTO;
import com.adjecti.spring.entity.EmployeeRegistration;
import com.adjecti.spring.repository.EmployeeRegistrationRepository;
import com.adjecti.spring.service.EmployeeRegistrationService;

@Service
@Component
public class EmployeeRegistrationServiceImpl implements EmployeeRegistrationService {

	@Autowired
	private EmployeeRegistrationRepository repository;
	
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public int addDetailsService(EmployeeRegistrationDTO employeeDTO) {
		EmployeeRegistration employeeRegistration = modelMapper.map(employeeDTO, EmployeeRegistration.class);
		EmployeeRegistration registration = repository.saveAndFlush(employeeRegistration);
		int employeeId = registration.getEmployeeId();
		//System.out.println("getcode" +employeeId);
		return employeeId;
	}

	@Override
	public List<EmployeeRegistrationDTO> getEmployeeRegistration() {
		List<EmployeeRegistration> employeeRegistrations = repository.findAll();
		Type listType = new TypeToken<List<EmployeeRegistrationDTO>>() {}.getType();
		List<EmployeeRegistrationDTO> registrationDTOList = modelMapper.map(employeeRegistrations, listType);
		return registrationDTOList;
	}

	@Override
	public EmployeeRegistrationDTO getEmployeeRegistrationById(int employeeId) {
		Optional<EmployeeRegistration>  employeeRegistration=repository.findById(employeeId);
		System.out.println("*****////////////**"+ employeeRegistration);	
		EmployeeRegistrationDTO registrationDTO = modelMapper.map(employeeRegistration,EmployeeRegistrationDTO.class );
		System.out.println("*****/////////-------------------///**"+ registrationDTO);	
		return registrationDTO;
	}

	@Override
	public void deleteEmployeeRegistration(int employeeId) {
		repository.deleteById(employeeId);
	}

	@Override
	public void updateEmployeeRegistration(EmployeeRegistrationDTO employee){
		EmployeeRegistration employeeRegistration = modelMapper.map(employee, EmployeeRegistration.class);
		repository.saveAndFlush(employeeRegistration);
	}

	/*
	 * @Override public EmployeeRegistration getbyemployeeId(Integer employeeId) {
	 * System.out.println("getcode" +employeeId); EmployeeRegistration code =
	 * repository.getById(employeeId); return code; }
	 */

}

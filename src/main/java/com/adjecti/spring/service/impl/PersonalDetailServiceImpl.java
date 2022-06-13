package com.adjecti.spring.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adjecti.spring.dto.EmployeeRegistrationDTO;
import com.adjecti.spring.dto.PersonalDetailsDTO;
import com.adjecti.spring.entity.EmployeeRegistration;
import com.adjecti.spring.entity.PersonalDetails;
import com.adjecti.spring.repository.EmployeeRegistrationRepository;
import com.adjecti.spring.repository.PersonalRepository;
import com.adjecti.spring.service.PersonalDetailService;

@Service
public class PersonalDetailServiceImpl implements PersonalDetailService{

	@Autowired
	PersonalRepository repository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	EmployeeRegistrationRepository employeeRepository;
	
	@Override
	public void savePersonalDetail(PersonalDetailsDTO detailDTO) {
		PersonalDetails employeeRegistration = modelMapper.map(detailDTO, PersonalDetails.class);
		repository.saveAndFlush(employeeRegistration);
	}

	/*
	 * @Override public void saveEmployeeDetail(EmployeeRegistrationDTO
	 * registrationDTO) { EmployeeRegistration employeeRegistration =
	 * modelMapper.map(registrationDTO, EmployeeRegistration.class);
	 * employeeRepository.saveAndFlush(employeeRegistration); }
	 */
}
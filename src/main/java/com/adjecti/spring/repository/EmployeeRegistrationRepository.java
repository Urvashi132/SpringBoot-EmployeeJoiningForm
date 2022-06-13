package com.adjecti.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adjecti.spring.entity.EmployeeRegistration;

@Repository
public interface EmployeeRegistrationRepository extends JpaRepository<EmployeeRegistration, Integer> {

	//EmployeeRegistration getbyemployeeCode(String employeeCode);
}

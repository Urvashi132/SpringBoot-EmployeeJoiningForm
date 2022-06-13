package com.adjecti.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EmployeeRegistration {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int employeeId;
	@Column(unique = true)
	private String employeeCode;
	@Column
	private String name;
	@Column
	private String fatherName;
	@Column
	private String bloodGroup;
	@Column
	private String phoneNumber;
	@Column
	private String emailId;
	@Column
	private String country;
	@Column
	private String designation;
	@Column
	private String department;
	@Column
	private String gender;
	@Column
	private String dateOfBirth;

	/*
	 * @OneToOne
	 * 
	 * @JoinColumn(name = "personal_id") private PersonalDetails personaldetails;
	 */
	public EmployeeRegistration() {
		super();
	}

	public EmployeeRegistration(int employeeId, String employeeCode, String name, String fatherName, String bloodGroup,
			String phoneNumber, String emailId, String country, String designation, String department, String gender,
			String dateOfBirth/* , com.adjecti.spring.entity.PersonalDetails personaldetails */) {
		super();
		this.employeeId = employeeId;
		this.employeeCode = employeeCode;
		this.name = name;
		this.fatherName = fatherName;
		this.bloodGroup = bloodGroup;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.country = country;
		this.designation = designation;
		this.department = department;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		/*
		 * this.personaldetails = personaldetails; }
		 * 
		 * public PersonalDetails getPersonaldetails() { return personaldetails; }
		 * 
		 * public void setPersonaldetails(PersonalDetails personaldetails) {
		 * this.personaldetails = personaldetails;
		 */
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/*
	 * @OneToOne
	 * 
	 * @JoinColumn(name = "personal_id") private PersonalDetails personaldetails;
	 */

}

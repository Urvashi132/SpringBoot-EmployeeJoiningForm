package com.adjecti.spring.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.adjecti.spring.entity.EmployeeRegistration;

public class PersonalDetailsDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String joiningDate;
	private String employeeCode;
	private String employeeName;
	private String fatherName;
	private String motherName;
	private String email;
	private String dateBirth;
	private String gender;
	private String maritalStatus;
	private String bloodGroup;
	private String disability;
	private String hobbies;
	private String country;
	private String religion;
	private String number;
	private String designation;
	private String department;
	private String emgNumber;
	private String aadhaarNo;
	private String aadharFileName;
	private String panFileName;
	private String panNo;

	private CommonsMultipartFile aadharFile;
	private CommonsMultipartFile panFile;

	private EmployeeRegistration employee;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(String dateBirth) {
		this.dateBirth = dateBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getDisability() {
		return disability;
	}

	public void setDisability(String disability) {
		this.disability = disability;
	}

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
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

	public String getEmgNumber() {
		return emgNumber;
	}

	public void setEmgNumber(String emgNumber) {
		this.emgNumber = emgNumber;
	}

	public String getAadhaarNo() {
		return aadhaarNo;
	}

	public void setAadhaarNo(String aadhaarNo) {
		this.aadhaarNo = aadhaarNo;
	}

	public String getAadharFileName() {
		return aadharFileName;
	}

	public void setAadharFileName(String aadharFileName) {
		this.aadharFileName = aadharFileName;
	}

	public String getPanFileName() {
		return panFileName;
	}

	public void setPanFileName(String panFileName) {
		this.panFileName = panFileName;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public CommonsMultipartFile getAadharFile() {
		return aadharFile;
	}

	public void setAadharFile(CommonsMultipartFile aadharFile) {
		this.aadharFile = aadharFile;
	}

	public CommonsMultipartFile getPanFile() {
		return panFile;
	}

	public void setPanFile(CommonsMultipartFile panFile) {
		this.panFile = panFile;
	}

	public EmployeeRegistration getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeRegistration employee) {
		this.employee = employee;
	}

	public PersonalDetailsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PersonalDetailsDTO(int id, String joiningDate, String employeeCode, String employeeName, String fatherName,
			String motherName, String email, String dateBirth, String gender, String maritalStatus, String bloodGroup,
			String disability, String hobbies, String country, String religion, String number, String designation,
			String department, String emgNumber, String aadhaarNo, String aadharFileName, String panFileName,
			String panNo, CommonsMultipartFile aadharFile, CommonsMultipartFile panFile,
			EmployeeRegistration employee) {
		super();
		this.id = id;
		this.joiningDate = joiningDate;
		this.employeeCode = employeeCode;
		this.employeeName = employeeName;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.email = email;
		this.dateBirth = dateBirth;
		this.gender = gender;
		this.maritalStatus = maritalStatus;
		this.bloodGroup = bloodGroup;
		this.disability = disability;
		this.hobbies = hobbies;
		this.country = country;
		this.religion = religion;
		this.number = number;
		this.designation = designation;
		this.department = department;
		this.emgNumber = emgNumber;
		this.aadhaarNo = aadhaarNo;
		this.aadharFileName = aadharFileName;
		this.panFileName = panFileName;
		this.panNo = panNo;
		this.aadharFile = aadharFile;
		this.panFile = panFile;
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "PersonalDetails [id=" + id + ", joiningDate=" + joiningDate + ", employeeCode=" + employeeCode
				+ ", employeeName=" + employeeName + ", fatherName=" + fatherName + ", motherName=" + motherName
				+ ", email=" + email + ", dateBirth=" + dateBirth + ", gender=" + gender + ", maritalStatus="
				+ maritalStatus + ", bloodGroup=" + bloodGroup + ", disability=" + disability + ", hobbies=" + hobbies
				+ ", country=" + country + ", religion=" + religion + ", number=" + number + ", designation="
				+ designation + ", department=" + department + ", emgNumber=" + emgNumber + ", aadhaarNo=" + aadhaarNo
				+ ", aadharFileName=" + aadharFileName + ", panFileName=" + panFileName + ", panNo=" + panNo
				+ ", aadharFile=" + aadharFile + ", panFile=" + panFile + ", employee=" + employee + "]";
	}

}

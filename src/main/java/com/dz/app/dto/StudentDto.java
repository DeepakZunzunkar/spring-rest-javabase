package com.dz.app.dto;

import java.util.Date;
import java.util.List;

public class StudentDto {

	private Long id;
	private String name;
	
//	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date dob;
	
	private List<String> courses;
	private String gender;
	private String stype;
	
	private AddressDto address;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public List<String> getCourses() {
		return courses;
	}
	public void setCourses(List<String> courses) {
		this.courses = courses;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getStype() {
		return stype;
	}
	public void setStype(String stype) {
		this.stype = stype;
	}
	
	public AddressDto getAddress() {
		return address;
	}
	public void setAddress(AddressDto address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "StudentDto [id=" + id + ", name=" + name + ", dob=" + dob + ", courses=" + courses + ", gender="
				+ gender + ", stype=" + stype + ", address=" + address + "]";
	}
	
	
	
}

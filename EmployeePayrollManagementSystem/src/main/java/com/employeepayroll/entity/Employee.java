package com.employeepayroll.entity;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
@Entity
//@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class,property="employeeId")
public class Employee {
	@Id
	@Column(name = "emp_id")
	int employeeId;
	@Column(name = "fname")
	String firstName;
	@Column(name = "lname")
	String lastName;
	@Column(name = "mobileno")
	Long mobileNo;
	@Column(name = "emailid")
	String emailId;
	@Column(name = "address")
	String address;
	@Column(name="doj")
	LocalDate dateOfJoining;
	@Column(name="ctc")
	double cTC;
	@Column(name="leave_available")
	int leaveAvailable;
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="proj_id")
	Project project;
    
	@OneToMany()
	@JoinColumn(name="emp_id")
	List<SantionedLeaves> santionedLeaves;
	
	public Employee() {
	}

	public Employee(int employeeId, String firstName, String lastName, Long mobileNo, String emailId, String address,
			LocalDate dateOfJoining, double cTC, int leaveAvailable, Project project,
			List<SantionedLeaves> santionedLeaves) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
		this.address = address;
		this.dateOfJoining = dateOfJoining;
		this.cTC = cTC;
		this.leaveAvailable = leaveAvailable;
		this.project = project;
		this.santionedLeaves = santionedLeaves;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public double getcTC() {
		return cTC;
	}
	public void setcTC(double cTC) {
		this.cTC = cTC;
	}
	public int getLeaveAvailable() {
		return leaveAvailable;
	}
	public void setLeaveAvailable(int leaveAvailable) {
		this.leaveAvailable = leaveAvailable;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public List<SantionedLeaves> getSantionedLeaves() {
		return santionedLeaves;
	}

	public void setSantionedLeaves(List<SantionedLeaves> santionedLeaves) {
		this.santionedLeaves = santionedLeaves;
	}
}

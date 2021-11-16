package com.employeepayroll.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="santioned_leaves")
public class SantionedLeaves {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "sid")
	int sId;
	//@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL,mappedBy="employee")
	//List<Employee>employee;
	@Column(name="emp_id")
	int employeeId;
	@Column(name = "leave_date")
	LocalDate leaveDate;
     
	public SantionedLeaves() {
	}


	public SantionedLeaves(int sId, List<Employee> employee, LocalDate leaveDate,int employeeId) {
		super();
		this.sId = sId;
		this.employeeId = employeeId;
		this.leaveDate = leaveDate;
	}


	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public LocalDate getLeaveDate() {
		return leaveDate;
	}

	public void setLeaveDate(LocalDate leaveDate) {
		this.leaveDate = leaveDate;
	}


	public int getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

}

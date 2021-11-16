package com.employeepayroll.entity;

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

@Entity
public class Project {
	@Id
	@Column(name = "proj_id")
	int projectId;
	@Column(name = "pname")
	String projectName;
	@Column(name = "description")
	String description;
	@Column(name = "proj_size")
	int projectsize;
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL,mappedBy="project")
	List<Employee>employee;
    @Column(name="client_name")
    String clientName;
	public Project() {
	}
	public Project(int projectId, String projectName, String description, int projectsize, List<Employee> employee,
			String clientName) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.description = description;
		this.projectsize = projectsize;
		this.employee = employee;
		this.clientName = clientName;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getProjectsize() {
		return projectsize;
	}

	public void setProjectsize(int projectsize) {
		this.projectsize = projectsize;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

}

package com.employeepayroll.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.employeepayroll.entity.EmployeeWorkingDays;
import com.employeepayroll.entity.Project;
import com.employeepayroll.repository.ProjectRepository;

@Service
public class ProjectService {
	@Autowired
ProjectRepository projectRepository;
	@Transactional(readOnly = true)
	public Project getProject(int projectId) {
		Optional<Project> optProj = projectRepository.findById(projectId);
		if (optProj.isPresent())
			return optProj.get();
		throw new RuntimeException("Project does not EXIST");
	}

	@Transactional(readOnly = true)
	public List<Project> getProjects() {
		List<Project> plist = projectRepository.findAll();
		if (plist.size() > 0)
			return plist;
		throw new RuntimeException("No data found");
	}

	@Transactional
	public boolean addOrModifyProject(Project project) {
	  Project emp = projectRepository.save(project);
		return emp != null;
	}

	@Transactional
	public void removeProject(int projectId) {
		projectRepository.deleteById(projectId);
	}
}

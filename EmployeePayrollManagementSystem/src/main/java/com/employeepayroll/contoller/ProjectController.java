package com.employeepayroll.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeepayroll.Service.ProjectService;
import com.employeepayroll.entity.Project;
@RequestMapping("/project")
@RestController
public class ProjectController {
@Autowired
ProjectService projectService;

@GetMapping(value = "/{projectId}", produces = "application/json")
public ResponseEntity<Project> getProjectDetails(@PathVariable int projectId){
	Project pro = projectService.getProject(projectId);
	return new ResponseEntity<Project>(pro,HttpStatus.OK);
}
@GetMapping(produces = "application/json")
public ResponseEntity<List<Project>> getProjectDetails() {
	return new ResponseEntity<List<Project>>(projectService.getProjects(), HttpStatus.OK);
}
@PostMapping(consumes = "application/json")
public HttpStatus addProjectDetails(@RequestBody Project project) {
	if (projectService.addOrModifyProject(project))
		return HttpStatus.OK;
	return HttpStatus.NOT_MODIFIED;
}

@PutMapping(consumes = "application/json")
public HttpStatus modifyProjectDetails(@RequestBody Project project) {
	if (projectService.addOrModifyProject(project))
		return HttpStatus.OK;
	return HttpStatus.NOT_MODIFIED;
}

@DeleteMapping(value = "/{projectId}")
public HttpStatus removeProjectDetails(@PathVariable int projectId) {
	projectService.removeProject(projectId);
	return HttpStatus.OK;
}

@ExceptionHandler(RuntimeException.class)
public HttpStatus exceptionHandlerMethod()
{
	return HttpStatus.NO_CONTENT;
}

}

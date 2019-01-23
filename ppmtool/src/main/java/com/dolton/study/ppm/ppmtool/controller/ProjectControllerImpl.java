package com.dolton.study.ppm.ppmtool.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dolton.study.ppm.ppmtool.entity.Project;
import com.dolton.study.ppm.ppmtool.service.ProjectService;

@RestController
@RequestMapping("/api")
public class ProjectControllerImpl implements ProjectController
{
	@Autowired
	private ProjectService projectService;
	
	@PostMapping("/projects")
	public Project addProject(@RequestBody Project theProject, BindingResult binding) 
	{
		theProject.setId(0L);
		theProject.setProjectIdentifier(theProject.getProjectIdentifier().toUpperCase());
		return projectService.saveProject(theProject);
	}
	
	@GetMapping("/projects/{projectIdentifier}")
	public Project getProject(@PathVariable String projectIdentifier) 
	{
		return projectService.findProjectByIdentifier(projectIdentifier.toUpperCase());
	}
	
	@GetMapping("/projects")
	public List<Project> getAddProjects()
	{
		return projectService.findAllProjects();
	}
	
	@PutMapping("/projects")
	public Project updateProject(@RequestBody Project theProject)
	{
		return projectService.saveProject(theProject);
	}
	
	@DeleteMapping("/projects/{projectIdentifier}")
	public Map<String, Object> deleteByIdentifier(@PathVariable String projectIdentifier)
	{
		return projectService.deleteByIdentifier(projectIdentifier.toUpperCase());
	}
}

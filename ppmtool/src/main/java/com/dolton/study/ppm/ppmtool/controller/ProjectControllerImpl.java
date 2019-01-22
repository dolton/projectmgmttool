package com.dolton.study.ppm.ppmtool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
	public Project addProject(@RequestBody Project theProject) 
	{
		theProject.setId(0L);
		return projectService.saveProject(theProject);
	}
}

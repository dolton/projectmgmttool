package com.dolton.study.ppm.ppmtool.service;

import java.util.List;
import java.util.Map;

import com.dolton.study.ppm.ppmtool.entity.Project;

public interface ProjectService
{
	public Project saveProject(Project p);
	
	public Project findProjectByIdentifier(String identifier);

	public Map<String, Object> deleteByIdentifier(String projectIdentifier);

	public List<Project> findAllProjects();

}

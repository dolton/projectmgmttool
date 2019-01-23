package com.dolton.study.ppm.ppmtool.dao;

import java.util.List;

import com.dolton.study.ppm.ppmtool.entity.Project;

public interface ProjectDAO
{
	public Project saveProject(Project p);
	
	public Project findProjectByIdentifier(String identifier);
	
	public void deleteByIdentifier(String projectIdentifier);

	public List<Project> findAllProjects();
}

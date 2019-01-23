package com.dolton.study.ppm.ppmtool.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dolton.study.ppm.ppmtool.dao.ProjectDAO;
import com.dolton.study.ppm.ppmtool.entity.Project;

@Service
public class ProjectServiceImpl implements ProjectService
{
	@Autowired
	@Qualifier("projectDaoImpl")
	private ProjectDAO projectDao;

	@Override
	@Transactional
	public Project saveProject(Project p)
	{
		try 
		{
			return projectDao.saveProject(p);
		}
		catch(Exception ex) 
		{
			throw new RuntimeException("Error while adding a project. Please check the data");
		}
	}

	@Override
	@Transactional
	public Project findProjectByIdentifier(String identifier)
	{
		return projectDao.findProjectByIdentifier(identifier);
	}

	@Override
	@Transactional
	public Map<String, Object> deleteByIdentifier(String projectIdentifier)
	{
		projectDao.deleteByIdentifier(projectIdentifier);
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("projectIdentifier", projectIdentifier);
		returnMap.put("message", "Project was deleted successfully");
		returnMap.put("timestamp", new Date().getTime());
		
		return returnMap;
		
	}

	@Override
	public List<Project> findAllProjects()
	{
		return projectDao.findAllProjects();
	}
}

package com.dolton.study.ppm.ppmtool.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dolton.study.ppm.ppmtool.entity.Project;

@Repository
public class ProjectDaoImpl implements ProjectDAO
{
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public Project saveProject(Project p)
	{
		return entityManager.merge(p);
	}

	@Override
	public Project findProjectByIdentifier(String identifier)
	{
		return entityManager.createNamedQuery("Project.findByIdentifier", Project.class)
							.setParameter("identifier", identifier)
							.getSingleResult();
	}
	
	@Override
	public void deleteByIdentifier(String identifier) 
	{
		Project p = findProjectByIdentifier(identifier);
		entityManager.remove(p);
	}

	@Override
	public List<Project> findAllProjects()
	{
		return entityManager.createNamedQuery("Project.findAllProjects", Project.class).getResultList();
	}
}

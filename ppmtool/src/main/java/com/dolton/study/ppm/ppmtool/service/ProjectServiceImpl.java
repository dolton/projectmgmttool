package com.dolton.study.ppm.ppmtool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dolton.study.ppm.ppmtool.dao.ProjectDAO;
import com.dolton.study.ppm.ppmtool.entity.Project;

@Service
public class ProjectServiceImpl implements ProjectService
{
	@Autowired
	private ProjectDAO projectDao;

	@Override
	@Transactional
	public Project saveProject(Project p)
	{
		return projectDao.save(p);
	}
}

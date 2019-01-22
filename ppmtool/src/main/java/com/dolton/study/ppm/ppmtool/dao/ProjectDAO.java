package com.dolton.study.ppm.ppmtool.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dolton.study.ppm.ppmtool.entity.Project;

@Repository
public interface ProjectDAO extends JpaRepository<Project, Long>
{
	
}

package com.dolton.study.ppm.ppmtool.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="project")
public class Project
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	public Long id;

	@Column(name="project_name")
	private String projectName;

	@Column(name="project_identifier")
	private String projectIdentifier;

	@Column(name="project_desc")
	private String description;

	@Column(name="start_date")
	private Date startDate;

	@Column(name="end_date")
	private Date endDate;

	@Column(name="created_date")
	private Date createdDate;

	@Column(name="modified_date")
	private Date modifiedDate;

	public Project() {

	}

	@PrePersist
	protected void onCreate()
	{
		this.createdDate = new Date();
	}

	@PreUpdate
	protected void onUpdate()
	{
		this.modifiedDate = new Date();
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getProjectName()
	{
		return projectName;
	}

	public void setProjectName(String projectName)
	{
		this.projectName = projectName;
	}

	public String getProjectIdentifier()
	{
		return projectIdentifier;
	}

	public void setProjectIdentifier(String projectIdentifier)
	{
		this.projectIdentifier = projectIdentifier;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public Date getStartDate()
	{
		return startDate;
	}

	public void setStartDate(Date startDate)
	{
		this.startDate = startDate;
	}

	public Date getEndDate()
	{
		return endDate;
	}

	public void setEndDate(Date endDate)
	{
		this.endDate = endDate;
	}
}

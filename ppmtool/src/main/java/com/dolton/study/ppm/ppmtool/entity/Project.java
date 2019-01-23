package com.dolton.study.ppm.ppmtool.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="project")
@NamedQueries({
		@NamedQuery(name="Project.findByIdentifier", query="select p from Project p where p.projectIdentifier = :identifier"),
		@NamedQuery(name="Project.findAllProjects", query="select p from Project p")
})
public class Project
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	public Long id;

	@NotBlank(message = "Project name is mandatory")
	@Column(name="project_name")
	private String projectName;

	@NotBlank(message = "Project identifier is mandatory")
	@Size(min=4, max=5, message="Please use 4 to 5 characters")
	@Column(name="project_identifier", updatable=false, unique=true)
	private String projectIdentifier;

	@NotBlank(message = "Project description is mandatory")
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

	public Date getCreatedDate()
	{
		return createdDate;
	}

	public void setCreatedDate(Date createdDate)
	{
		this.createdDate = createdDate;
	}

	public Date getModifiedDate()
	{
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate)
	{
		this.modifiedDate = modifiedDate;
	}
}

package com.app.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "emp_performance")
@NoArgsConstructor
@Getter
@Setter
public class ProjectEmployeeDetails {
	@EmbeddedId // composite PK
	private ProjectEmployeeId projectEmpId = new ProjectEmployeeId();// eg of strong association : composition
	private double empPerformanceIndex;
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("projectId") //shared PK approach
	@JoinColumn(name = "project_id")
	private Project myProject;
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("employeeId") //shared PK approach
	@JoinColumn(name = "emp_id")
	private Employee myEmployee;

	public ProjectEmployeeDetails(ProjectEmployeeId projectEmpId) {
		super();
		this.projectEmpId = projectEmpId;
	}

}

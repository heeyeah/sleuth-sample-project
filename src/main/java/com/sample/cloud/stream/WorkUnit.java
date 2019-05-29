package com.sample.cloud.stream;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkUnit {

	private String workUnit;
	private LocalDate dueDate;
	private String details;
	
	public WorkUnit() {
	}
	
	public WorkUnit(String workUnit, LocalDate dueDate, String details) {
		this.workUnit = workUnit;
		this.dueDate = dueDate;
		this.details = details;
	}
	
	public WorkUnit addDetail(String detail) {
		this.details = this.details +"\n  " + detail;
		return this;
	}

	public String getWorkUnit() {
		return workUnit;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public String getDetails() {
		return details;
	}

	@Override
	public String toString() {
		return "WorkUnit [workUnit=" + workUnit + ", dueDate=" + dueDate + ", details=" + details + "]";
	}
}

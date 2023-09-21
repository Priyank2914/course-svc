package com.training.courseservice.model;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Course {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long courseId;
	private String courseName;
	private String department;
	private String courseFacultyName;
	private int credits;
	
	
	public Course(String courseName, String department, String courseFacultyName, int credits) {
		super();
		this.courseName = courseName;
		this.department = department;
		this.courseFacultyName = courseFacultyName;
		this.credits = credits;
	}
	
	
	
	
	

}

package com.training.courseservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class Student {
	
	
	private long studId;
	private String studName;
	private int age;
	
	
	private String grade;

	public Student(String studName, int age, String grade) {
		super();
		this.studName = studName;
		this.age = age;
		this.grade = grade;
	}
	
	

}

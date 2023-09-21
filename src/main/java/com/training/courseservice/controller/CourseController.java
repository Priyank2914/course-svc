package com.training.courseservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.courseservice.intercom.StudentClient;
import com.training.courseservice.model.Course;
import com.training.courseservice.model.Student;
import com.training.courseservice.repository.CourseRepository;

@RestController
@RequestMapping("/courseapi")
public class CourseController {
	
	@Autowired
	CourseRepository repository;
	
	@Autowired
	StudentClient studClient;
	
	@GetMapping("/course")
	public ResponseEntity<List<Course>> getCourse(){
		List<Course> courseList=repository.findAll();
		return new ResponseEntity<>(courseList,HttpStatus.OK);
		
		
	}
	
	@GetMapping("/service/stud/{studId}")
	public Student getStud(@PathVariable int studId) {
		return studClient.getStudent(studId);
	}
	
	@PostMapping("/post")
	public ResponseEntity post(@RequestBody Course course) {
		return new ResponseEntity(repository.save(course),HttpStatus.CREATED);
		//repository.save(course);
	}
	
	@GetMapping("/course/{id}")
	public Course getCourseByid(@PathVariable("id") long id) {
		Optional<Course> course=repository.findById(id);
		if(course.isPresent()) {
			return course.get();
		}
		else {
			return null;
		}
	}
	
	@PutMapping("/course/{id}")
	public void updateCourse(@PathVariable("id" ) long id, @RequestBody Course course) {
		Optional<Course> oldData =repository.findById(id);
		if(oldData.isPresent()) {
			Course crs=oldData.get();
			crs.setCourseFacultyName(course.getCourseFacultyName());
			//crs.setCourseId(course.getCourseId());
			crs.setCourseName(course.getCourseName());
			crs.setCredits(course.getCredits());
			crs.setDepartment(course.getDepartment());
			repository.save(crs);
		}
	}
	
	@DeleteMapping("/course/{id}")
	public void deleteCourse(@PathVariable("id") long id) {
		Optional<Course> course=repository.findById(id);
		if(course.isPresent()) {
			repository.delete(course.get());
		}
		else {
			return;
		}
	}
	


}

package com.springrest.springrest.services;

import java.util.List;

import com.springrest.springrest.controller.entities.Course;

public interface CourseService {

	public List<Course> getCourse();
	
	public Course getCourse (long courseId);
	
	public Course addCourse (Course course);
	
	public Course UpdateCourse (Course course);
	
	public Course deleteCourse (long parseLong);
}

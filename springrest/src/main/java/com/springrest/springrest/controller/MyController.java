package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.controller.entities.Course;
import com.springrest.springrest.services.CourseService;

@RestController
public class MyController {
	@Autowired
	private CourseService courseService;

	@GetMapping("/home")
	public String home() {
		return "Welcome to course application";
	}
	@GetMapping("/course")
	public List<Course> getCourse(){
		return this.courseService.getCourse();
		
	}
	@GetMapping("/course/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		return  this.courseService.getCourse(Long.parseLong(courseId));
	}
	@PostMapping("/course")
	public Course addCourse(@RequestBody Course course) {
		return this.courseService.addCourse(course);
	}
	
	@PutMapping("/course")
	public Course UpdateCourse(@RequestBody Course course) {
		return this.courseService.UpdateCourse(course);
	}
	@DeleteMapping("/course/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId) {
	    try {
	        this.courseService.deleteCourse(Long.parseLong(courseId));
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NumberFormatException e) {
	        return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // Handle invalid courseId format
	    } catch (RuntimeException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Handle if course is not found
	    } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // General error handling
	    }
	}

	
	
}

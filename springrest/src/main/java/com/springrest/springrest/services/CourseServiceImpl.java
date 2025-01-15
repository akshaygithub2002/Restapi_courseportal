package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.controller.entities.Course;
import com.springrest.springrest.dao.Coursedao;
@Service
public class CourseServiceImpl implements  CourseService {
	
	
	@Autowired
	private Coursedao coursedao;
	//List<Course>list;
	
	public CourseServiceImpl() {
		
//		list=new ArrayList<>();
//		list.add(new Course(123,"java core course","this course contain basic"));
//		list.add(new Course(456,"python  course","this course contain basic"));
//		list.add(new Course(789,"Djanhgo core course","this course contain basic"));
//		list.add(new Course(111,"angular course","this course contain basic"));

	}
	@Override
	public List<Course> getCourse() {
		// TODO Auto-generated method stub
		return coursedao.findAll();
	}
	@Override
	public Course getCourse(long courseId) {
		// TODO Auto-generated method stub
//		Course c=null;
//		for(Course course:list) {
//			if (course.getId()==courseId) {
//				c=course;
//				break;
//			}
//		}
		return coursedao.getOne(courseId);
	}
	@Override
	public Course addCourse(Course course) {
		// TODO Auto-generated method stub
		
//		list.add(course);
		coursedao.save(course);
		return course;
	}
	@Override
	public Course UpdateCourse(Course course) {
		// TODO Auto-generated method stub
//		list.forEach(e ->{
//			if(e.getId()==course.getId()) {
//				e.setTitle(course.getTitle());
//				e.setDescription(course.getDescription());
//			}
//		});
		coursedao.save(course);
		return course;
	}
//	@Override
//	public void deleteCourse(long parseLong) {
	    // Find the course to be deleted
//	    Optional<Course> courseToDelete = this.list.stream()
//	                                               .filter(e -> e.getId() == parseLong)
//	                                               .findFirst();
//	    
//	    // If the course is present, delete it from the list and return the deleted course
//	    if (courseToDelete.isPresent()) {
//	        this.list = this.list.stream()
//	                             .filter(e -> e.getId() != parseLong)
//	                             .collect(Collectors.toList());
//	        return courseToDelete.get();  // Return the deleted course
//	    } else {
		
//		Course entity =coursedao.getOne(parseLong);
//	        coursedao.delete(entity) ;// Or you could throw an exception if the course is not found
////	    }
//	}
	public Course deleteCourse(long courseId) {
	    Optional<Course> entityOptional = coursedao.findById(courseId); // Using findById to check existence
	    if (entityOptional.isPresent()) {
	        coursedao.delete(entityOptional.get());
	    } else {
	        throw new RuntimeException("Course not found with id: " + courseId);
	    }
		return null;
	}

	}




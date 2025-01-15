package com.springrest.springrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.springrest.controller.entities.Course;

public interface Coursedao extends JpaRepository<Course,Long> {

}

package com.team.bookTicket.dao;

import java.util.List;

import com.team.bookTicket.pojo.Course;
import org.apache.ibatis.annotations.Param;

public interface CourseDao {
	Course findById(Integer id);
	List<Course> all(@Param("offset") Integer offset, @Param("count") Integer count);
	List<Course> allAvailable();
	List<Course> allAvailable2();
	int add(Course course);
	int delete(Integer id);
	int update(Course course);
}

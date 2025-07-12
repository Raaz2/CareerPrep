package com.cms.service;

import com.cms.model.Course;
import com.cms.model.Student;

import java.util.List;

public interface StudentService {
    Student saveStudent(Student student);

    List<Student> findAllStudents();

    void removeStudentById(Integer studentId);

    Course saveCourse(Course course);

    List<Course> findAllCourses();

    void removeCourseById(Integer courseId);

    void assignStudentToCourse(Integer studentId, Integer courseId);

    List<Student> findStudentsByCourse(String courseName);
}

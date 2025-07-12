package com.cms.service;

import com.cms.model.Course;
import com.cms.model.Student;
import com.cms.repository.CourseRepository;
import com.cms.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepo;
    private final CourseRepository courseRepo;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepo, CourseRepository courseRepo) {
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public List<Student> findAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public void removeStudentById(Integer studentId) {
        studentRepo.deleteById(studentId);
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepo.save(course);
    }

    @Override
    public List<Course> findAllCourses() {
        return courseRepo.findAll();
    }

    @Override
    public void removeCourseById(Integer courseId) {
        courseRepo.deleteById(courseId);
    }

    @Override
    public void assignStudentToCourse(Integer studentId, Integer courseId) {
        Optional<Student> studentOpt = studentRepo.findById(studentId);
        Optional<Course> courseOpt = courseRepo.findById(courseId);

        if (studentOpt.isPresent() && courseOpt.isPresent()) {
            Student student = studentOpt.get();
            Course course = courseOpt.get();

            student.getCourses().add(course);
            course.getStudents().add(student);

            studentRepo.save(student);
            courseRepo.save(course);
        } else {
            throw new RuntimeException("Student or Course not found");
        }
    }

    @Override
    public List<Student> findStudentsByCourse(String courseName) {
        return studentRepo.findStudentsByCourseName(courseName);
    }
}


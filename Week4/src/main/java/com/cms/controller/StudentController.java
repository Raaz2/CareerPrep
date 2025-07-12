package com.cms.controller;

import com.cms.model.Course;
import com.cms.model.Student;
import com.cms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    private final StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    // === Student Endpoints ===

    @PostMapping("/students")
    public Student registerStudent(@RequestBody Student student) {
        return service.saveStudent(student);
    }

    @GetMapping("/students")
    public List<Student> fetchAllStudents() {
        return service.findAllStudents();
    }

    @DeleteMapping("/students/{studentId}")
    public void removeStudent(@PathVariable Integer studentId) {
        service.removeStudentById(studentId);
    }

    // === Course Endpoints ===

    @PostMapping("/courses")
    public Course createCourse(@RequestBody Course course) {
        return service.saveCourse(course);
    }

    @GetMapping("/courses")
    public List<Course> fetchAllCourses() {
        return service.findAllCourses();
    }

    @DeleteMapping("/courses/{courseId}")
    public void removeCourse(@PathVariable Integer courseId) {
        service.removeCourseById(courseId);
    }

    // === Enrollment Endpoint ===

    @PutMapping("/students/{studentId}/courses/{courseId}")
    public void assignCourseToStudent(@PathVariable Integer studentId, @PathVariable Integer courseId) {
        service.assignStudentToCourse(studentId, courseId);
    }

    // === JPQL Search ===

    @GetMapping("/students/enrolled-in/{courseName}")
    public List<Student> findStudentsEnrolledIn(@PathVariable String courseName) {
        return service.findStudentsByCourse(courseName);
    }
}

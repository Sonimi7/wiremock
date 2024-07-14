package ru.otus.stub.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.stub.model.CourseModel;
import ru.otus.stub.service.ICourseService;

import java.util.List;

@RestController
@RequestMapping(value = "courses")
public class CourseController {

  private final ICourseService courseService;

  public CourseController(ICourseService courseService) {
    this.courseService = courseService;
  }

  @GetMapping(value = "all")
  public List<CourseModel> getAllCourses() {
    return courseService.getAllCourses();
  }
}

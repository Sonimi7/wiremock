package ru.otus.stub.service;

import org.springframework.stereotype.Service;
import ru.otus.stub.model.CourseModel;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService{

  private final List<CourseModel> courseModels;

  public CourseServiceImpl() {
    this.courseModels = new ArrayList<>();
    courseModels.add(new CourseModel("QA java", 15000));
    courseModels.add(new CourseModel("Java", 12000));
  }
  @Override
  public List<CourseModel> getAllCourses() {
    return courseModels;
  }

}

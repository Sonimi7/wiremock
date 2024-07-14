package ru.otus.stub.service;

import org.springframework.stereotype.Service;
import ru.otus.stub.model.CourseModel;

import java.util.List;
import java.util.UUID;
import java.util.stream.LongStream;

@Service
public class CourseServiceImpl implements ICourseService{

  @Override
  public List<CourseModel> getAllCourses() {
    return LongStream
        .range(1, 10)
        .mapToObj(val -> new CourseModel(val,"nameCourse" + UUID.randomUUID()))
        .toList();
  }
}

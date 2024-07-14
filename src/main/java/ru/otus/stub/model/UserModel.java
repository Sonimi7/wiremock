package ru.otus.stub.model;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
  private String name;
  private String course;
  private String email;
  private int age;

  public void setName(String name) {
    this.name = name;
  }

  public void setCourse(String course) {
    this.course = course;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setAge(int age) {
    this.age = age;
  }
}

package ru.otus.stub.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.stub.service.IUserService;

@RestController
@RequestMapping(value = "users")
public class UserController {

  private final IUserService userService;

  public UserController(IUserService userService) {
    this.userService = userService;
  }

  @GetMapping(value = "all")
  public Object[][] getAllUsers() {
    return userService.getAllUser();
  }
}

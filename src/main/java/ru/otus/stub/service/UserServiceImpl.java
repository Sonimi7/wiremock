package ru.otus.stub.service;

import org.springframework.stereotype.Service;
import ru.otus.stub.model.UserModel;

@Service
public class UserServiceImpl implements IUserService{
  @Override
  public Object[][] getAllUser() {
    UserModel userModel = new UserModel("Test user", "QA", "test@test.test", 23);
    return new Object[][]{{userModel}};
  }

}

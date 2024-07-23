package ru.otus.stub.service;

import org.springframework.stereotype.Service;
import ru.otus.stub.model.UserModel;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService{

  private final List<UserModel> userModels;
  public UserServiceImpl() {
    this.userModels = new ArrayList<>();
    userModels.add(new UserModel("Ivan", "QA", "test@test.test", 23));
    userModels.add(new UserModel("Petr", "Dev", "dev@test.test", 32));
  }
  @Override
  public List<UserModel> getAllUsers() {

    return userModels;
  }

}

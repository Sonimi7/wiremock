package ru.otus.stub.service;

import ru.otus.stub.model.UserModel;

import java.util.List;

public interface IUserService {
  List<UserModel> getAllUsers();
}

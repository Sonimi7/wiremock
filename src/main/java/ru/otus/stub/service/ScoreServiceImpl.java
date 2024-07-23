package ru.otus.stub.service;

import org.springframework.stereotype.Service;
import ru.otus.stub.model.ScoreModel;
import ru.otus.stub.model.UserModel;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScoreServiceImpl implements IScoreService{

  private final List<ScoreModel> scoreModels;

  public ScoreServiceImpl() {
    this.scoreModels = new ArrayList<>();
    scoreModels.add(new ScoreModel("Ivan", 3));
    scoreModels.add(new ScoreModel("Petr", 10));
  }

  @Override
  public List<ScoreModel> getAllScore() {

    return scoreModels;
  }
}

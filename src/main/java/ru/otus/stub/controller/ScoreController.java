package ru.otus.stub.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.stub.model.ScoreModel;
import ru.otus.stub.service.IScoreService;

import java.util.List;

@RestController
@RequestMapping(value = "scores")
public class ScoreController {

  private final IScoreService scoreService;

  public ScoreController(IScoreService scoreService) {
    this.scoreService = scoreService;
  }

  @GetMapping(value =  "all")
  public List<ScoreModel> getAllScore() {
    return scoreService.getAllScore();
  }

}

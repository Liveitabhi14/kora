package com.projects.kora.controller;

import com.projects.kora.model.Answer;
import com.projects.kora.model.MyVote;
import com.projects.kora.model.Question;
import com.projects.kora.service.KoraService;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;

@RestController
public class KoraController {
    @Autowired
    KoraService koraService;

    @GetMapping ("/kora")
    private String  welcomeMessage () {
        return koraService.welcomeMessage();
    }

    @PostMapping ("/kora/question")
    private Question saveQuestion (@RequestBody Question question) {
        return koraService.saveQuestion(question);
    }

    @PostMapping ("/kora/question/{quesId}/answer")
    private Answer saveAnswer (@PathVariable Integer quesId, @RequestBody Answer answer) {
        return koraService.saveAnswer(quesId, answer);
    }

    @GetMapping ("/kora/question/all")
    private List<Question> listViewOfQuestion ( @RequestParam(value = "page",defaultValue = "0" ) int page) {
        return koraService.listViewOfQuestion(page);
    }

    @GetMapping ("/kora/question/{quesId}/answer/all")
    private Pair< String , List<Answer> > seeAllAnsOfQues (@PathVariable int quesId ) {
        return koraService.seeAllAnsOfQues(quesId);
    }

    @GetMapping ("/kora/question/all/answer/top5")
    private LinkedHashMap<String,List<Answer>> listViewOfQuesAnsTop5 () {
        return koraService.listViewOfQuesAnsTop5();
    }

    @PostMapping ("/kora/upvote/answer/{ansId}")
    private MyVote upVote (@PathVariable Integer ansId) {
        return koraService.upVote(ansId);
    }

    @PostMapping ("/kora/downvote/answer/{ansId}")
    private MyVote downVote (@PathVariable Integer ansId) {
        return koraService.downVote(ansId);
    }

}

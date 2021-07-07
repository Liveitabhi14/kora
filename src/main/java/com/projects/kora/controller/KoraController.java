package com.projects.kora.controller;

import com.projects.kora.service.KoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class KoraController {
    @Autowired
    KoraService koraService;

    @GetMapping ("/kora")
    private String  welcomeMessage () {
        return koraService.welcomeMessage();
    }

    @PostMapping ("/kora/login")
    private String userLogin (@RequestBody User user) {
        return koraService.userLogin();
    }

    @PostMapping ("/kora/signup")
    private String userSignup (@RequestBody User user) {
        return koraService.userSignup();
    }

    @PostMapping ("/kora/postQues")
    private int saveQuestion (@RequestBody Question question) {
        koraService.saveQuestion(question);
        return question.id;
    }

    @PostMapping ("/kora/postAns")
    private int saveAnswer (@RequestBody Answer answer) {
        koraService.saveAnswer(answer);
        return answer.ansId;
    }

    @GetMapping ("/kora/viewQues")
    private List<Question> listViewOfQuestion () {
        return koraService.listViewOfQuestion();
    }

    @GetMapping ("/kora/viewQuesAns")
    private HashMap<Question,Answer[]> listViewOfQuesAnsTop5 () {
        return koraService.listViewOfQuesAnsTop5();
    }

    @GetMapping ("/kora/upvote/{ansId}")
    private String upvote ( @PathVariable("ansId") int ansId ) {
        return koraService.upvote(ansId);
    }

    @GetMapping ("/kora/downVote/{ansId}")
    private String downVote ( @PathVariable("ansId") int ansId ) {
        return koraService.downVote(ansId);
    }

}

package com.projects.kora.controller;

import com.projects.kora.design.Answer;
import com.projects.kora.design.MyVote;
import com.projects.kora.design.Question;
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

//    @PostMapping ("/kora/login")
//    private String userLogin (@RequestBody User user) {
//        return koraService.userLogin();
//    }
//
//    @PostMapping ("/kora/signup")
//    private String userSignup (@RequestBody User user) {
//        return koraService.userSignup();
//    }

    @PostMapping ("/kora/postQues")
    private Question saveQuestion (@RequestBody Question question) {
        return koraService.saveQuestion(question);
    }

    @PostMapping ("/kora/postAns")
    private Answer saveAnswer (@RequestBody Answer answer) {
        return koraService.saveAnswer(answer);
    }

    @GetMapping ("/kora/viewQues")
    private List<Question> listViewOfQuestion ( @RequestParam(value = "page",defaultValue = "0" ) int page) {
        return koraService.listViewOfQuestion(page);
    }

//    @GetMapping ("/kora/viewQuesAns")
//    private LinkedHashMap<Question,List<Answer>> listViewOfQuesAnsTop5 () {
//        return koraService.listViewOfQuesAnsTop5();
//    }
//
    @PostMapping ("/kora/upVote")
    private MyVote upVote (@RequestBody MyVote myVote) {
        return koraService.upVote(myVote);
    }

    @PostMapping ("/kora/downVote")
    private MyVote downVote (@RequestBody MyVote myVote) {
        return koraService.downVote(myVote);
    }

    @GetMapping ("/kora/quesAllAns/{quesId}")
    private List<Answer> seeAllAnsOfQues (@PathVariable("quesId") int quesId ) {
        return koraService.seeAllAnsOfQues(quesId);
    }

}

package com.projects.kora.controller;

import com.projects.kora.model.Answer;
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
    private int saveQuestion (@RequestBody Question question) {
        koraService.saveQuestion(question);
        return question.getQuesId();
    }

    @PostMapping ("/kora/postAns")
    private int saveAnswer (@RequestBody Answer answer) {
        koraService.saveAnswer(answer);
        return answer.getAnsId();
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
//    @GetMapping ("/kora/upVote/{ansId}")
//    private String upVote ( @PathVariable("ansId") int ansId ) {
//        return koraService.upVote(ansId);
//    }
//
//    @GetMapping ("/kora/downVote/{ansId}")
//    private String downVote ( @PathVariable("ansId") int ansId ) {
//        return koraService.downVote(ansId);
//    }
//
    @GetMapping ("/kora/quesAllAns/{quesId}")
    private Pair<Integer, List<Answer>> seeAllAnsOfQues (@PathVariable("quesId") int quesId ) {
        return koraService.seeAllAnsOfQues(quesId);
    }

}

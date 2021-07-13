package com.projects.kora.controller;

import com.projects.kora.design.Answer;
import com.projects.kora.design.MyVote;
import com.projects.kora.design.Question;
import com.projects.kora.service.KoraService;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
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

    @PostMapping ("/kora/postQues")
    private Question saveQuestion (@RequestBody Question question) {
        return koraService.saveQuestion(question);
    }

    @PostMapping ("/kora/postAns/{quesId}")
    private Answer saveAnswer (@PathVariable Integer quesId, @RequestBody Answer answer) {
        return koraService.saveAnswer(quesId, answer);
    }

//    @GetMapping ("/kora/viewQues")
//    private List<Question> listViewOfQuestion ( @RequestParam(value = "page",defaultValue = "0" ) int page) {
//        return koraService.listViewOfQuestion(page);
//    }
//
//    @GetMapping ("/kora/viewQuesAns")
//    private LinkedHashMap<String,List<Answer>> listViewOfQuesAnsTop5 () {
//        return koraService.listViewOfQuesAnsTop5();
//    }
//
    @PostMapping ("/kora/upVote/{ansId}")
    private MyVote upVote (@PathVariable Integer ansId) {
        return koraService.upVote(ansId);
    }

    @PostMapping ("/kora/downVote/{ansId}")
    private MyVote downVote (@PathVariable Integer ansId) {
        return koraService.downVote(ansId);
    }
//
//    @GetMapping ("/kora/quesAllAns/{quesId}")
//    private Pair< String , List<Answer> > seeAllAnsOfQues (@PathVariable("quesId") int quesId ) {
//        return koraService.seeAllAnsOfQues(quesId);
//    }

}

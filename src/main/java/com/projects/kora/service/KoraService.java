package com.projects.kora.service;

import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class KoraService {

    public String welcomeMessage() {
        return "Welcome to Kora";
    }

    public String userLogin() {
        return "You have been logged in successfully";
    }

    public String userSignup() {
        return "You have been signed in successfully";
    }

    public int saveQuestion ( Question question) {
        return 1;
    }

    public int saveAnswer ( Answer answer ) {
        return  1;
    }

    public List<Question> listViewOfQuestion () {

    }

    public LinkedHashMap<Question,Answer[]> listViewOfQuesAnsTop5 () {

    }

    public String upvote ( int ansId ) {
        return "up voted";
    }

    public String downVote ( int ansId ) {
        return "Down voted";
    }

    public LinkedHashMap<Question,List<Answer> > seeAllAnsOfQues (int quesId) {

    }

}

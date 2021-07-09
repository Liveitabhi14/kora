package com.projects.kora.service;

import com.projects.kora.model.Answer;
import com.projects.kora.model.Question;
import com.projects.kora.repository.AnswerRepository;
import com.projects.kora.repository.QuestionRepository;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class KoraService {

    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    AnswerRepository answerRepository;

    public String welcomeMessage() {
        return "Welcome to Kora";
    }

//    public String userLogin() {
//        return "You have been logged in successfully";
//    }
//
//    public String userSignup() {
//        return "You have been signed in successfully";
//    }

    public void saveQuestion ( Question question) {
        questionRepository.save(question);
    }

    public void saveAnswer ( Answer answer ) {
        answerRepository.save( answer);
    }

    public List<Question> listViewOfQuestion (int page) {
//        List<Question> questions = new ArrayList<Question>();
//        Iterable<Question> temp = questionRepository.findAll();
//        temp.forEach(questions::add);
//        return questions;

        Pageable currPage = PageRequest.of(page,20);
        Page<Question> questions = questionRepository.findAll(currPage);
        return questions.getContent();
    }

//    public LinkedHashMap<Question,List<Answer> listViewOfQuesAnsTop5 () {
//
//    }
//
//    public String upVote ( int ansId ) {
//        return "up voted";
//    }
//
//    public String downVote ( int ansId ) {
//        return "Down voted";
//    }
//
    public Pair<Integer ,List<Answer> > seeAllAnsOfQues (int quesId) {
        List<Answer> temp = answerRepository.findByquesId(quesId);
        return new Pair(quesId,temp);
    }

}

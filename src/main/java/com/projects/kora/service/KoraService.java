package com.projects.kora.service;

import com.projects.kora.design.Answer;
import com.projects.kora.design.MyVote;
import com.projects.kora.design.Question;
import com.projects.kora.repository.AnswerRepository;
import com.projects.kora.repository.MyVoteRepository;
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
    @Autowired
    MyVoteRepository myVoteRepository;

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

    public MyVote upVote ( MyVote myVote ) {
        int ansId = myVote.getAnsId();
        int userId = myVote.getUserId();
        MyVote myVote2 = myVoteRepository.findByAnsIdAndUserId(ansId,userId);
        List<Answer> answerList = answerRepository.findByansId(ansId);

        if(answerList.size() == 0 ) {
            System.out.println("answer is null");
            return myVote;
        }
        Answer answer = answerList.get(0);
        if ( myVote2 == null ) {
            answer.setUpVoteSum( answer.getUpVoteSum() + 1 );
        }
        else {
            if (myVote2.getUpVote() == 0) {
                answer.setUpVoteSum(answer.getUpVoteSum() + 1);
            }
            if (myVote2.getDownVote() == 1) {
                answer.setDownVoteSum(answer.getDownVoteSum() - 1);
            }
        }

        myVote.setUpVote(1);
        myVote.setDownVote(0);
        MyVote myVote1 = (MyVote) myVoteRepository.save(myVote);
        return myVote1;
    }

    public MyVote downVote ( MyVote myVote ) {
        int ansId = myVote.getAnsId();
        int userId = myVote.getUserId();
        MyVote myVote2 = myVoteRepository.findByAnsIdAndUserId(ansId,userId);
        List<Answer> answerList = answerRepository.findByansId(ansId);

        if(answerList.size() == 0 ) {
            System.out.println("answer is null");
            return myVote;
        }
        Answer answer = answerList.get(0);
        if( myVote2 == null ) {
            answer.setDownVoteSum( answer.getDownVoteSum() + 1 );
        }
        else {
            if (myVote2.getDownVote() == 0) {
                answer.setDownVoteSum(answer.getDownVoteSum() + 1);
            }
            if (myVote2.getUpVote() == 1) {
                answer.setUpVoteSum(answer.getUpVoteSum() - 1);
            }
        }

        myVote.setDownVote(1);
        myVote.setUpVote(0);
        MyVote myVote1 = (MyVote) myVoteRepository.save(myVote);
        return myVote1;
    }

    public Pair<Integer ,List<Answer> > seeAllAnsOfQues (int quesId) {
        List<Answer> temp = answerRepository.findByquesId(quesId);
        return new Pair(quesId,temp);
    }

}

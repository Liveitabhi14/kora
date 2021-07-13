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

    public Question saveQuestion ( Question question) {
        return questionRepository.save(question);
    }

    public Answer saveAnswer ( Answer answer ) {
        return answerRepository.save( answer);
    }

    public List<Question> listViewOfQuestion (int page) {
        Pageable currPage = PageRequest.of(page,20);
        Page<Question> questions = questionRepository.findAll(currPage);
        return questions.getContent();
    }


    public LinkedHashMap<String ,List<Answer>> listViewOfQuesAnsTop5 () {
        LinkedHashMap< String,List<Answer> >  result = new LinkedHashMap<>();
        List<Integer> quesIdList = answerRepository.findAllDistinctQuesId();
        for (Integer quesId : quesIdList ) {
            List<Answer> answerList = answerRepository.findTop5ByQuesIdOrderByUpVoteSumDesc(quesId);
            List<Question> questionList = questionRepository.findByQuesId(quesId);
            Question question = questionList.get(0);
            result.put(question.getQuesBody(),answerList);
        }
        return result;
    }

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
            myVote.setUpVote(1);
            myVote.setDownVote(0);
            return myVoteRepository.save(myVote);
        }
        else {
            if (myVote2.getUpVote() == 0) {
                answer.setUpVoteSum(answer.getUpVoteSum() + 1);
            }
            if (myVote2.getDownVote() == 1) {
                answer.setDownVoteSum(answer.getDownVoteSum() - 1);
            }
        }

        myVote2.setUpVote(1);
        myVote2.setDownVote(0);
        return myVoteRepository.save(myVote2);
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
            myVote.setDownVote(1);
            myVote.setUpVote(0);
            return myVoteRepository.save(myVote);
        }
        else {
            if (myVote2.getDownVote() == 0) {
                answer.setDownVoteSum(answer.getDownVoteSum() + 1);
            }
            if (myVote2.getUpVote() == 1) {
                answer.setUpVoteSum(answer.getUpVoteSum() - 1);
            }
        }

        myVote2.setDownVote(1);
        myVote2.setUpVote(0);
        return myVoteRepository.save(myVote2);
    }

    public Pair< String , List<Answer> > seeAllAnsOfQues (int quesId) {
        List<Answer> temp = answerRepository.findByquesId(quesId);
        List<Question> questionList = questionRepository.findByQuesId(quesId);
        Question question = questionList.get(0);
        return new Pair( question.getQuesBody(),temp );
    }

}

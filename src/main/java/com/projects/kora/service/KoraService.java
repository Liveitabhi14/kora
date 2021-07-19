package com.projects.kora.service;

import com.projects.kora.auth.config.JwtTokenUtil;
import com.projects.kora.auth.model.UserDAO;
import com.projects.kora.auth.repository.UserRepository;
import com.projects.kora.auth.service.AuthUserDetailsService;
import com.projects.kora.model.*;
import com.projects.kora.repository.*;
import javafx.util.Pair;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.*;

@Service
public class KoraService {

    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    AnswerRepository answerRepository;
    @Autowired
    MyVoteRepository myVoteRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    JwtTokenUtil jwtTokenUtil;
    @Autowired
    AuthUserDetailsService authUserDetailsService;
    @Autowired
    EventRepository eventRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    NotificationRepository notificationRepository;
    @Autowired
    EntityManager entityManager;


    public String welcomeMessage() {
        return "Welcome to Kora";
    }

    private int getUserId() { return authUserDetailsService.getUserIdByUsername(jwtTokenUtil.username); }

    public Question saveQuestion ( Question question) {
        UserDAO user1 = userRepository.findByUserId(getUserId());
        Category category = categoryRepository.findByCatName(question.getCategoryName());
        question.setCategory(category);
        question.setUser(user1);
        List<UserDAO> userList =  findUserListByCatName(question.getCategoryName());

        Notification notification = new Notification();
        notification.setEvent(eventRepository.findByEventType("Question posted"));
        notification.setPost(question);
        for(UserDAO user : userList) {
            if(user.getUserId() == user1.getUserId()) continue;
            notification.setUser1(user);
            notificationRepository.save(notification);
        }
        return questionRepository.save(question);
    }

    public Answer saveAnswer (Integer quesId, Answer answer ) {
        UserDAO user1 = userRepository.findByUserId(getUserId());
        answer.setUser(user1);
        Question question = questionRepository.findByQuesId(quesId);
        answer.setQuestion(question);

        Notification notification = new Notification();
        notification.setEvent(eventRepository.findByEventType("Answer posted"));

        Question question1 = questionRepository.findByQuesId(quesId);
        UserDAO user = question1.getUser();
        notification.setUser1(user);

        notification.setPost(answer);
        notificationRepository.save(notification);

        return answerRepository.save(answer);


    }

    public List<Question> listViewOfQuestion (int page) {
        Pageable currPage = PageRequest.of(page,20);
        Page<Question> questions = questionRepository.findAll(currPage);
        return questions.getContent();
    }

    public LinkedHashMap<String ,List<Answer>> listViewOfQuesAnsTop5 () {
        LinkedHashMap< String,List<Answer> >  result = new LinkedHashMap<>();
        List<Question> questionList = answerRepository.findAllDistinctQuesId();
        for (Question question : questionList ) {
            List<Answer> top5AnswerList = answerRepository.findTop5ByQuestion_quesIdOrderByUpVoteSumDesc(question.getQuesId());
            result.put(question.getQuesBody(), top5AnswerList);
        }
        return result;
    }

    public MyVote upVote ( Integer ansId ) {
        UserDAO user1 = userRepository.findByUserId(getUserId());
        MyVote myVote = myVoteRepository.findByAnswer_ansIdAndUser1_userId(ansId, getUserId());
        Answer answer = answerRepository.findByAnsId(ansId);

        if ( myVote == null ) {
            myVote = new MyVote();
            myVote.setUser(user1);
            myVote.setUpVote(1);
            myVote.setDownVote(0);
            answer.setUpVoteSum( answer.getUpVoteSum() + 1 );
            myVote.setAnswer(answer);
            answerRepository.save(answer);
            return myVoteRepository.save(myVote);
        }
        if (myVote.getUpVote() == 0) {
            answer.setUpVoteSum(answer.getUpVoteSum() + 1);
        }
        if (myVote.getDownVote() == 1) {
            answer.setDownVoteSum(answer.getDownVoteSum() - 1);
        }
        myVote.setUpVote(1);
        myVote.setDownVote(0);
        answerRepository.save(answer);
        return myVoteRepository.save(myVote);
    }

    public MyVote downVote ( Integer ansId ) {
        UserDAO user1 = userRepository.findByUserId(getUserId());
        MyVote myVote = myVoteRepository.findByAnswer_ansIdAndUser1_userId(ansId, getUserId());
        Answer answer = answerRepository.findByAnsId(ansId);

        if ( myVote == null ) {
            myVote = new MyVote();
            myVote.setUser(user1);
            myVote.setUpVote(0);
            myVote.setDownVote(1);
            myVote.setAnswer(answer);
            answer.setDownVoteSum( answer.getDownVoteSum() + 1 );
            answerRepository.save(answer);
            return myVoteRepository.save(myVote);
        }
        if (myVote.getUpVote() == 1) {
            answer.setUpVoteSum(answer.getUpVoteSum() - 1);
        }
        if (myVote.getDownVote() == 0) {
            answer.setDownVoteSum(answer.getDownVoteSum() + 1);
        }
        myVote.setUpVote(0);
        myVote.setDownVote(1);
        answerRepository.save(answer);
        return myVoteRepository.save(myVote);
    }

    public Pair< String , List<Answer> > seeAllAnsOfQues (int quesId) {
        List<Answer> temp = answerRepository.findByQuestion_quesId(quesId);
        Question question = questionRepository.findByQuesId(quesId);
        return new Pair( question.getQuesBody(),temp );
    }

    private List<UserDAO> findUserListByCatName(String categoryName) {
        int bitmapId = categoryRepository.findByCatName(categoryName).getBitmapId();
        TypedQuery<UserDAO> query = entityManager.createQuery("SELECT e FROM UserDAO e where MOD(e.bitmapOfCategory/(?1) , 2) = 1" , UserDAO.class);
        return query.setParameter(1, bitmapId).getResultList();
    }

}

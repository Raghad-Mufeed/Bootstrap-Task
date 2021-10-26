package io.javabrains.springbootquickstart.services;

import io.javabrains.springbootquickstart.models.Answer;
import io.javabrains.springbootquickstart.repositiroies.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    public List<Answer> getAllAnswers(int questionId){
        List<Answer> answers = new ArrayList<Answer>();
        answerRepository.findByQuestionId(questionId).forEach(answers::add);
        return answers;
    }

    public Optional<Answer> getAnswer(int answerId){
        return answerRepository.findById(answerId);
    }

    public void addAnswer(Answer answer){
        answerRepository.save(answer);
    }

    public void updateAnswer(Answer answer){
        answerRepository.save(answer);
    }

    public void deleteAnswer(int answerId){
        answerRepository.deleteById(answerId);
    }
}

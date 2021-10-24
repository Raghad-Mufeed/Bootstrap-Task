package io.javabrains.springbootquickstart.services;

import io.javabrains.springbootquickstart.models.Question;
import io.javabrains.springbootquickstart.repositiroies.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> getAllQuestions(int categoryId) {
        List<Question> questions = new ArrayList<Question>();
        questionRepository.findByCategoryId(categoryId).forEach(questions::add);
        return questions;
    }

    public Optional<Question> getQuestion(int questionId){
        return questionRepository.findById(questionId);
    }

    public void addQuestion(Question question){
        questionRepository.save(question);
    }

    public void updateQuestion(Question question){
        questionRepository.save(question);
    }

    public void deleteQuestion(int questionId){
        questionRepository.deleteById(questionId);
    }

}

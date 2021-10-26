package io.javabrains.springbootquickstart.services;

import com.sun.istack.NotNull;
import com.sun.tools.jconsole.JConsoleContext;
import io.javabrains.springbootquickstart.DTOModels.DTOQuestion;
import io.javabrains.springbootquickstart.models.Category;
import io.javabrains.springbootquickstart.models.Question;
import io.javabrains.springbootquickstart.repositiroies.CategoryRepository;
import io.javabrains.springbootquickstart.repositiroies.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.QueryAnnotation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Question> getAllQuestions(int categoryId) {
        List<Question> questions = new ArrayList<Question>();
        questionRepository.findByCategoryId(categoryId).forEach(questions::add);
        return questions;
    }

    public Optional<Question> getQuestion(int questionId){
        return questionRepository.findById(questionId);
    }

    public void addQuestion(DTOQuestion dtoQuestion){
        Question question = DTOToQuestion(dtoQuestion);
        questionRepository.save(question);
    }

    public void updateQuestion(DTOQuestion dtoQuestion){
        /*
        Question question = questionRepository.findById(dtoQuestion.getId());
        question.setText(dtoQuestion.getText());
        question.setLikeCount(dtoQuestion.getLikeCount());
        question.setDislikeCount(dtoQuestion.getDislikeCount());
        questionRepository.save(question);
        */
    }

    public void deleteQuestion(int questionId){
        questionRepository.deleteById(questionId);
    }

    public Question DTOToQuestion(DTOQuestion dtoQuestion) {
        Question question = new Question();
        question.setLikeCount(dtoQuestion.getLikeCount());
        question.setDislikeCount(dtoQuestion.getDislikeCount());
        question.setText(dtoQuestion.getText());
        question.setCategory(categoryRepository.getById(dtoQuestion.getCategoryId()));
        return question;
    }

}

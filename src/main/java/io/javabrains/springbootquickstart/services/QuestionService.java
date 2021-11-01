package io.javabrains.springbootquickstart.services;

import io.javabrains.springbootquickstart.models.Category;
import io.javabrains.springbootquickstart.models.DTOModels.QuestionDTO;
import io.javabrains.springbootquickstart.models.Question;
import io.javabrains.springbootquickstart.repositiroies.CategoryRepository;
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

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Question> getAllQuestions(int categoryId) {
        List<Question> questions = new ArrayList<Question>();
        questionRepository.findByCategoryId(categoryId).forEach(questions::add);
        return questions;
    }

    public Optional<Question> getQuestion(int questionId) {
        return questionRepository.findById(questionId);
    }

    public Question addQuestion(QuestionDTO questionDTO) {
        Category category =categoryRepository.getById(questionDTO.getCategoryId());
        Question question = new Question(questionDTO, category);
        return questionRepository.save(question);
    }

    public Question updateQuestion(QuestionDTO questionDTO) {
        Question question = new Question(questionDTO, categoryRepository.getById(questionDTO.getCategoryId()));
        return questionRepository.save(question);
    }

    public void deleteQuestion(int questionId) {
        questionRepository.deleteById(questionId);
    }

}

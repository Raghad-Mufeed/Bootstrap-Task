package io.javabrains.springbootquickstart.services;

import io.javabrains.springbootquickstart.DTOModels.DTOQuestion;
import io.javabrains.springbootquickstart.models.Category;
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

    public List<DTOQuestion> getAllQuestions(int categoryId) {
        List<DTOQuestion> questions = new ArrayList<DTOQuestion>();
        questionRepository.findByCategoryId(categoryId).forEach(question -> questions.add(QuestionToDTO(question)));
        questions.sort((a, b) -> (a.getId() > b.getId()) ? 1 : -1);
        return questions;
    }

    public DTOQuestion getQuestion(int questionId){
        Optional<Question> question = questionRepository.findById(questionId);
        if(question.isPresent()){
            return QuestionToDTO(question.get());
        }
        return null;
    }

    public List<DTOQuestion> addQuestion(int categoryId, DTOQuestion dtoQuestion){
        Question question = DTOToQuestion(dtoQuestion);
        questionRepository.save(question);
        return getAllQuestions(categoryId);
    }

    public List<DTOQuestion> updateQuestion(int categoryId, DTOQuestion dtoQuestion){
        Question question = DTOToQuestion(dtoQuestion);
        question.setId(dtoQuestion.getId());
        questionRepository.save(question);
        return getAllQuestions(categoryId);
    }

    public List<DTOQuestion> deleteQuestion(int categoryId, int questionId){
        questionRepository.deleteById(questionId);
        return getAllQuestions(categoryId);
    }

    public Question DTOToQuestion(DTOQuestion dtoQuestion) {
        Question question = new Question();
        question.setLikeCount(dtoQuestion.getLikeCount());
        question.setDislikeCount(dtoQuestion.getDislikeCount());
        question.setText(dtoQuestion.getText());
        Optional<Category> category = categoryRepository.findById(dtoQuestion.getCategoryId());
        if(category.isPresent()){
            question.setCategory(category.get());
        }
        return question;
    }

    public DTOQuestion QuestionToDTO(Question question) {
        DTOQuestion dtoQuestion = new DTOQuestion(question.getLikeCount(), question.getDislikeCount(),
                question.getText(), question.getCategory().getId());
        dtoQuestion.setId(question.getId());
        return dtoQuestion;
    }

}

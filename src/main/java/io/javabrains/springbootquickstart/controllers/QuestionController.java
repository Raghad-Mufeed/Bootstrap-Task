package io.javabrains.springbootquickstart.controllers;

import io.javabrains.springbootquickstart.models.Category;
import io.javabrains.springbootquickstart.models.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.javabrains.springbootquickstart.services.QuestionService;
import java.util.List;
import java.util.Optional;

@RestController
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @RequestMapping("/categories/{categoryId}/questions")
    public List<Question> getAllQuestions(@PathVariable int categoryId){
        return questionService.getAllQuestions(categoryId);
    }

    @RequestMapping("/categories/{categoryId}/questions/{questionId}")
    public Optional<Question> getQuestion(@PathVariable int questionId) {
        return questionService.getQuestion(questionId);
    }

    @RequestMapping(method = RequestMethod.POST , value = "/categories/{categoryId}/questions")
    public void addQuestion(@RequestBody Question question,@PathVariable int categoryId){
        question.setCategory(new Category(categoryId,"","","",null));
        questionService.addQuestion(question);
    }

    @RequestMapping(method = RequestMethod.PUT , value = "/categories/{categoryId}/questions")
    public void updateQuestion(@RequestBody Question question, @PathVariable int categoryId){
        question.setCategory(new Category(categoryId,"","","",null));
        questionService.updateQuestion(question);
    }

    @RequestMapping(method = RequestMethod.DELETE,value="/categories/{categoryId}/questions/{questionId}")
    public void deleteQuestion(@PathVariable int questionId) {
        questionService.deleteQuestion(questionId);
    }
}

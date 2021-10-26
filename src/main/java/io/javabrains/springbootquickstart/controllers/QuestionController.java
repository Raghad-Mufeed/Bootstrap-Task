package io.javabrains.springbootquickstart.controllers;

import ch.qos.logback.core.util.DefaultInvocationGate;
import com.sun.tools.jconsole.JConsoleContext;
import io.javabrains.springbootquickstart.DTOModels.DTOQuestion;
import io.javabrains.springbootquickstart.models.Category;
import io.javabrains.springbootquickstart.models.Question;
import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.javabrains.springbootquickstart.services.QuestionService;
import java.util.List;
import java.util.Optional;

@RestController
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/categories/{categoryId}/questions")
    public ResponseEntity<List<Question>> getAllQuestions(@PathVariable int categoryId){
        try {
            List<Question> results = questionService.getAllQuestions(categoryId);
            return new ResponseEntity<>(results, HttpStatus.OK);
        }
       catch(Error error) {
           return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
       }
    }

    @GetMapping("/categories/{categoryId}/questions/{questionId}")
    public ResponseEntity<Optional<Question>> getQuestion(@PathVariable int questionId) {
        try {
            Optional<Question> result = questionService.getQuestion(questionId);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        catch(Error error) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/categories/{categoryId}/questions")
    public ResponseEntity<String> addQuestion(@RequestBody DTOQuestion dtoQuestion){
        try {
            questionService.addQuestion(dtoQuestion);
            return new ResponseEntity<>("The question is added successfully", HttpStatus.OK);
        }
        catch(Error error) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/categories/{categoryId}/questions")
    public ResponseEntity<String> updateQuestion(@RequestBody DTOQuestion dtoQuestion){
        try {
            questionService.updateQuestion(dtoQuestion);
            return new ResponseEntity<>("The question is updated successfully", HttpStatus.OK);
        }
        catch(Error error) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/categories/{categoryId}/questions/{questionId}")
    public ResponseEntity<String> deleteQuestion(@PathVariable int questionId) {
        try {
            questionService.deleteQuestion(questionId);
            return new ResponseEntity<>("The question is deleted successfully", HttpStatus.OK);
        }
        catch(Error error) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}

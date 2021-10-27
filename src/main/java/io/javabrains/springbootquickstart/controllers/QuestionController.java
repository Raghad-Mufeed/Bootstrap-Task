package io.javabrains.springbootquickstart.controllers;

import io.javabrains.springbootquickstart.DTOModels.DTOQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.javabrains.springbootquickstart.services.QuestionService;
import java.util.List;

@RestController
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/categories/{categoryId}/questions")
    public ResponseEntity<List<DTOQuestion>> getAllQuestions(@PathVariable int categoryId){
        try {
            List<DTOQuestion> questions = questionService.getAllQuestions(categoryId);
            return new ResponseEntity<>(questions, HttpStatus.OK);
        }
       catch(Error error) {
           return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
       }
    }

    @GetMapping("/categories/{categoryId}/questions/{questionId}")
    public ResponseEntity<DTOQuestion> getQuestion(@PathVariable int questionId) {
        try {
            DTOQuestion result = questionService.getQuestion(questionId);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        catch(Error error) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/categories/{categoryId}/questions")
    public ResponseEntity<List<DTOQuestion>> addQuestion(@RequestBody DTOQuestion dtoQuestion, @PathVariable int categoryId){
        try {
            List<DTOQuestion> questions = questionService.addQuestion(categoryId, dtoQuestion);
            return new ResponseEntity<>(questions, HttpStatus.OK);
        }
        catch(Error error) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/categories/{categoryId}/questions")
    public ResponseEntity<List<DTOQuestion>> updateQuestion(@RequestBody DTOQuestion dtoQuestion, @PathVariable int categoryId){
        try {
            List<DTOQuestion> questions = questionService.updateQuestion(categoryId, dtoQuestion);
            return new ResponseEntity<>(questions, HttpStatus.OK);
        }
        catch(Error error) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/categories/{categoryId}/questions/{questionId}")
    public ResponseEntity<List<DTOQuestion>> deleteQuestion(@PathVariable int questionId, @PathVariable int categoryId) {
        try {
            List<DTOQuestion> questions = questionService.deleteQuestion(categoryId, questionId);
            return new ResponseEntity<>(questions, HttpStatus.OK);
        }
        catch(Error error) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}

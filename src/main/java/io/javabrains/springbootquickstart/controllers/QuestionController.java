package io.javabrains.springbootquickstart.controllers;

import io.javabrains.springbootquickstart.models.DTOModels.QuestionDTO;
import io.javabrains.springbootquickstart.models.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.javabrains.springbootquickstart.services.QuestionService;
import java.util.List;
import java.util.Optional;

@RequestMapping("/questions")
@RestController
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping
    public ResponseEntity<List<Question>> getAllQuestions(@RequestParam int categoryId){
        try {
            List<Question> questions = questionService.getAllQuestions(categoryId);
            return new ResponseEntity<>(questions, HttpStatus.OK);
        }
       catch(Error error) {
           return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
       }
    }

    @GetMapping("{questionId}")
    public ResponseEntity<Optional<Question>> getQuestion(@PathVariable int questionId) {
        try {
            Optional<Question> result = questionService.getQuestion(questionId);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        catch(Error error) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Question> addQuestion(@RequestBody QuestionDTO questionDTO){
        try {
            Question question = questionService.addQuestion(questionDTO);
            return new ResponseEntity<>(question, HttpStatus.OK);
        }
        catch(Error error) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    public ResponseEntity<Question> updateQuestion(@RequestBody QuestionDTO questionDTO){
        try {
            Question question = questionService.updateQuestion(questionDTO);
            return new ResponseEntity<>(question, HttpStatus.OK);
        }
        catch(Error error) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{questionId}")
    public ResponseEntity<String> deleteQuestion(@PathVariable int questionId) {
        try {
            questionService.deleteQuestion(questionId);
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        catch(Error error) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}

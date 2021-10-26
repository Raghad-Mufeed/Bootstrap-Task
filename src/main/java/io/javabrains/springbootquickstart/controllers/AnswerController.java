package io.javabrains.springbootquickstart.controllers;

import io.javabrains.springbootquickstart.models.Answer;
import io.javabrains.springbootquickstart.services.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @GetMapping("/categories/{categoryId}/questions/{questionId}/answers")
    public ResponseEntity<List<Answer>> getAllAnswers(@PathVariable int questionId){
        try {
            List<Answer> results = answerService.getAllAnswers(questionId);
            return new ResponseEntity<>(results, HttpStatus.OK);
        }
        catch(Error error) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/categories/{categoryId}/questions/{questionId}/answers/{answerId}")
    public ResponseEntity<Optional<Answer>> getAnswer(@PathVariable int answerId) {
        try {
            Optional<Answer> result = answerService.getAnswer(answerId);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        catch(Error error) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/categories/{categoryId}/questions/{questionId}/answers")
    public ResponseEntity<String> addAnswer(@RequestBody Answer answer){
        try {
            answerService.addAnswer(answer);
            return new ResponseEntity<>("The answer is added successfully", HttpStatus.OK);
        }
        catch(Error error) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/categories/{categoryId}/questions/{questionId}/answers")
    public ResponseEntity<String> updateAnswer(@RequestBody Answer answer) {
        try {
            answerService.updateAnswer(answer);
            return new ResponseEntity<>("The answer is updated successfully", HttpStatus.OK);
        }
        catch(Error error) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/categories/{categoryId}/questions/{questionId}/answers/{answerId}")
    public ResponseEntity<String> deleteAnswer(@PathVariable int answerId) {
        try {
            answerService.deleteAnswer(answerId);
            return new ResponseEntity<>("The answer is deleted successfully", HttpStatus.OK);
        }
        catch(Error error) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}

package io.javabrains.springbootquickstart.controllers;

import io.javabrains.springbootquickstart.DTOModels.DTOAnswer;
import io.javabrains.springbootquickstart.services.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @GetMapping("/categories/{categoryId}/questions/{questionId}/answers")
    public ResponseEntity<List<DTOAnswer>> getAllAnswers(@PathVariable int questionId){
        try {
            List<DTOAnswer> results = answerService.getAllAnswers(questionId);
            return new ResponseEntity<>(results, HttpStatus.OK);
        }
        catch(Error error) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/categories/{categoryId}/questions/{questionId}/answers/{answerId}")
    public ResponseEntity<DTOAnswer> getAnswer(@PathVariable int answerId) {
        try {
            DTOAnswer result = answerService.getAnswer(answerId);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        catch(Error error) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/categories/{categoryId}/questions/{questionId}/answers")
    public ResponseEntity<List<DTOAnswer>> addAnswer(@RequestBody DTOAnswer dtoAnswer, @PathVariable int questionId){
        try {
            List<DTOAnswer> answers = answerService.addAnswer(questionId, dtoAnswer);
            return new ResponseEntity<>(answers, HttpStatus.OK);
        }
        catch(Error error) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/categories/{categoryId}/questions/{questionId}/answers")
    public ResponseEntity<List<DTOAnswer>> updateAnswer(@RequestBody DTOAnswer dtoAnswer, @PathVariable int questionId) {
        try {
            List<DTOAnswer> answers = answerService.updateAnswer(questionId, dtoAnswer);
            return new ResponseEntity<>(answers, HttpStatus.OK);
        }
        catch(Error error) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/categories/{categoryId}/questions/{questionId}/answers/{answerId}")
    public ResponseEntity<List<DTOAnswer>> deleteAnswer(@PathVariable int answerId, @PathVariable int questionId) {
        try {
            List<DTOAnswer> answers = answerService.deleteAnswer(questionId, answerId);
            return new ResponseEntity<>(answers, HttpStatus.OK);
        }
        catch(Error error) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}

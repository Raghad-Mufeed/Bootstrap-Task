package io.javabrains.springbootquickstart.controllers;

import io.javabrains.springbootquickstart.models.DTOModels.AnswerDTO;
import io.javabrains.springbootquickstart.models.Answer;
import io.javabrains.springbootquickstart.services.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/answers")
@RestController
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @GetMapping
    public ResponseEntity<List<Answer>> getAllAnswers(@RequestParam int questionId){
        try {
            List<Answer> results = answerService.getAllAnswers(questionId);
            return new ResponseEntity<>(results, HttpStatus.OK);
        }
        catch(Error error) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("{answerId}")
    public ResponseEntity<Optional<Answer>> getAnswer(@PathVariable int answerId) {
        try {
            Optional<Answer> result = answerService.getAnswer(answerId);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        catch(Error error) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Answer> addAnswer(@RequestBody AnswerDTO answerDTO){
        try {
            Answer answer = answerService.addAnswer(answerDTO);
            return new ResponseEntity<>(answer, HttpStatus.OK);
        }
        catch(Error error) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    public ResponseEntity<Answer> updateAnswer(@RequestBody AnswerDTO answerDTO) {
        try {
            Answer answer = answerService.updateAnswer(answerDTO);
            return new ResponseEntity<>(answer, HttpStatus.OK);
        }
        catch(Error error) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{answerId}")
    public ResponseEntity<String> deleteAnswer(@PathVariable int answerId) {
        try {
            answerService.deleteAnswer(answerId);
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        catch(Error error) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}

package io.javabrains.springbootquickstart.controllers;

import io.javabrains.springbootquickstart.models.Answer;
import io.javabrains.springbootquickstart.models.Question;
import io.javabrains.springbootquickstart.services.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @RequestMapping("/categories/{categoryId}/questions/{questionId}/answers")
    public List<Answer> getAllAnswers(@PathVariable int questionId){
        return answerService.getAllAnswers(questionId);
    }

    @RequestMapping("/categories/{categoryId}/questions/{questionId}/answers/{answerId}")
    public Optional<Answer> getAnswer(@PathVariable int answerId) {
        return answerService.getAnswer(answerId);
    }

    @RequestMapping(method = RequestMethod.POST, value="/categories/{categoryId}/questions/{questionId}/answers")
    public void addAnswer(@RequestBody Answer answer, @PathVariable int questionId,@PathVariable int categoryId){
        answer.setQuestion(new Question(questionId,0,0,0,null,categoryId));
        answerService.addAnswer(answer);
    }

    @RequestMapping(method = RequestMethod.PUT, value="/categories/{categoryId}/questions/{questionId}/answers")
    public void updateAnswer(@RequestBody Answer answer, @PathVariable int questionId,@PathVariable int categoryId){
        answer.setQuestion(new Question(questionId,0,0,0,null,categoryId));
        answerService.updateAnswer(answer);
    }

    @RequestMapping(method=RequestMethod.DELETE,value="/categories/{categoryId}/questions/{questionId}/answers/{answerId}")
    public void deleteAnswer(@PathVariable int answerId) {
        answerService.deleteAnswer(answerId);
    }
}

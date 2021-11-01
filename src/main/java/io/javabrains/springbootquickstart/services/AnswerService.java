package io.javabrains.springbootquickstart.services;

import io.javabrains.springbootquickstart.models.DTOModels.AnswerDTO;
import io.javabrains.springbootquickstart.models.Answer;
import io.javabrains.springbootquickstart.repositiroies.AnswerRepository;
import io.javabrains.springbootquickstart.repositiroies.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private QuestionRepository questionRepository;

    public List<Answer> getAllAnswers(int questionId) {
        List<Answer> answers = new ArrayList<Answer>();
        answerRepository.findByQuestionId(questionId).forEach(answers::add);
        return answers;
    }

    public Optional<Answer> getAnswer(int answerId) {
        return answerRepository.findById(answerId);
    }

    public Answer addAnswer(AnswerDTO answerDTO) {
        Answer answer = new Answer(answerDTO, questionRepository.getById(answerDTO.getQuestionId()));
        return answerRepository.save(answer);
    }

    public Answer updateAnswer(AnswerDTO answerDTO) {
        Answer answer = new Answer(answerDTO, questionRepository.getById(answerDTO.getQuestionId()));
        return answerRepository.save(answer);
    }

    public void deleteAnswer(int answerId) {
        answerRepository.deleteById(answerId);
    }
}

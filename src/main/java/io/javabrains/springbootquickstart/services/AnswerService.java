package io.javabrains.springbootquickstart.services;

import io.javabrains.springbootquickstart.DTOModels.DTOAnswer;
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

    public List<DTOAnswer> getAllAnswers(int questionId){
        List<DTOAnswer> answers = new ArrayList<DTOAnswer>();
        answerRepository.findByQuestionId(questionId).forEach(answer -> answers.add(AnswerToDTO(answer)));
        answers.sort((a, b) -> (a.getId() > b.getId()) ? 1 : -1);
        return answers;
    }

    public DTOAnswer getAnswer(int answerId){
        Optional<Answer> answer = answerRepository.findById(answerId);
        if(answer.isPresent()){
            return AnswerToDTO(answer.get());
        }
        return null;
    }

    public List<DTOAnswer> addAnswer(int questionId, DTOAnswer dtoAnswer){
        Answer answer = DTOToAnswer(dtoAnswer);
        answerRepository.save(answer);
        return getAllAnswers(questionId);
    }

    public List<DTOAnswer> updateAnswer(int questionId, DTOAnswer dtoAnswer){
        Answer answer = DTOToAnswer(dtoAnswer);
        answer.setId(dtoAnswer.getId());
        answerRepository.save(answer);
        return getAllAnswers(questionId);
    }

    public List<DTOAnswer> deleteAnswer(int questionId, int answerId){
        answerRepository.deleteById(answerId);
        return getAllAnswers(questionId);
    }

    public Answer DTOToAnswer(DTOAnswer dtoAnswer) {
        Answer answer = new Answer();
        answer.setLikeCount(dtoAnswer.getLikeCount());
        answer.setDislikeCount(dtoAnswer.getDislikeCount());
        answer.setText(dtoAnswer.getText());
        answer.setQuestion(questionRepository.getById(dtoAnswer.getQuestionId()));
        return answer;
    }

    public DTOAnswer AnswerToDTO(Answer answer) {
        DTOAnswer dtoAnswer = new DTOAnswer(answer.getLikeCount(), answer.getDislikeCount(),
                answer.getText(), answer.getQuestion().getId());
        dtoAnswer.setId(answer.getId());
        return dtoAnswer;
    }
}

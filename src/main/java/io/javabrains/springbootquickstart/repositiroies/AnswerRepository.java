package io.javabrains.springbootquickstart.repositiroies;

import io.javabrains.springbootquickstart.models.Answer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnswerRepository extends CrudRepository<Answer, Integer> {
    public List<Answer> findByQuestionID(int questionId);
}

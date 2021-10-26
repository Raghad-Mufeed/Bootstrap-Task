package io.javabrains.springbootquickstart.repositiroies;

import io.javabrains.springbootquickstart.models.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
    public List<Answer> findByQuestionId(int questionId);
}

package io.javabrains.springbootquickstart.repositiroies;

import io.javabrains.springbootquickstart.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    public List<Question> findByCategoryId(int categoryId);
}

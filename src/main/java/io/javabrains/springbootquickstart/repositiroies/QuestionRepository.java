package io.javabrains.springbootquickstart.repositiroies;

import io.javabrains.springbootquickstart.models.Question;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface QuestionRepository extends CrudRepository<Question, Integer> {
    public List<Question> findByCategoryId(int categoryId);
}

package io.javabrains.springbootquickstart.repositiroies;

import io.javabrains.springbootquickstart.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}

package io.javabrains.springbootquickstart.services;

import io.javabrains.springbootquickstart.models.Category;
import io.javabrains.springbootquickstart.repositiroies.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories(){
        List<Category> categories = new ArrayList<Category>();
        categories = categoryRepository.findAll();
        return categories;
    }

    public Optional<Category> getCategory(int categoryId){
        return categoryRepository.findById(categoryId);
    }
}


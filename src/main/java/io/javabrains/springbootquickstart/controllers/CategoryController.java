package io.javabrains.springbootquickstart.controllers;

import io.javabrains.springbootquickstart.models.Category;
import io.javabrains.springbootquickstart.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@RequestMapping("/categories")
@RestController
public class CategoryController implements Serializable {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<List<Category>> getAllCategories() {
        try {
            List<Category> results = categoryService.getAllCategories();
            return new ResponseEntity<>(results, HttpStatus.OK);
        } catch (Error error) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("{categoryId}")
    public ResponseEntity<Optional<Category>> getCategory(@PathVariable int categoryId) {
        try {
            Optional<Category> result = categoryService.getCategory(categoryId);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Error error) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}

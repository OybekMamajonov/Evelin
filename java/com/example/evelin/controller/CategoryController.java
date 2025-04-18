package com.example.evelin.controller;

import com.example.evelin.dto.CategoryDto;
import com.example.evelin.model.Category;
import com.example.evelin.model.Result;
import com.example.evelin.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService  categoryService;

    @GetMapping
    public HttpEntity<?> getCategories(){
        List<Category> all = categoryService.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getCategoryById(@PathVariable Integer id){
        Category categoryById = categoryService.findById(id);
        return new ResponseEntity<>(categoryById, HttpStatus.OK);
    }

    @PostMapping
    public HttpEntity<?> addCategory(@RequestBody CategoryDto categoryDto){
        Result result = categoryService.addCategory(categoryDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> updateCategory(@PathVariable Integer id, @RequestBody CategoryDto categoryDto){
        Result result = categoryService.updateCategory(id,categoryDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteCategory(@PathVariable Integer id){
        Result result = categoryService.deleteCategory(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}

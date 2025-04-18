package com.example.evelin.service;

import com.example.evelin.dto.CategoryDto;
import com.example.evelin.model.Category;
import com.example.evelin.model.Result;
import com.example.evelin.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepo  categoryRepo;

    public List<Category> findAll(){
        return categoryRepo.findAll();
    }

    public Category findById(Integer id){
        return categoryRepo.findById(id).get();
    }

    public Result addCategory(CategoryDto categoryDto){
        Category category = new Category();
        category.setName(categoryDto.getName());
        categoryRepo.save(category);
        return new Result(true,"category added successfully");
    }

    public Result updateCategory(Integer id, CategoryDto categoryDto){
        Optional<Category> optionalCategory = categoryRepo.findById(id);
        if(optionalCategory.isPresent()){
            Category category = optionalCategory.get();
            category.setName(categoryDto.getName());
            categoryRepo.save(category);
            return new Result(true,"category updated successfully");
        }
        return new Result(false,"category not found");
    }

    public Result deleteCategory(Integer id){
        Optional<Category> optionalCategory = categoryRepo.findById(id);
        if(optionalCategory.isPresent()){
            categoryRepo.deleteById(id);
            return new Result(true,"category deleted successfully");
        }
        return new Result(false,"category not found");
    }

}

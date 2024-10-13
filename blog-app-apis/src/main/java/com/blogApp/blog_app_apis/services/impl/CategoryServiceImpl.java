package com.blogApp.blog_app_apis.services.impl;

import com.blogApp.blog_app_apis.entities.Category;
import com.blogApp.blog_app_apis.exceptions.ResourceNotFoundException;
import com.blogApp.blog_app_apis.payloads.CategoryDto;
import com.blogApp.blog_app_apis.repositories.CategoryRepo;
import com.blogApp.blog_app_apis.services.CategoryService;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = dtoToCategory(categoryDto);
        this.categoryRepository.save(category);
        return this.categoryToDto(category);
    }

    @Override
    public CategoryDto getCategoryById(Integer categoryId) {
        Category category = this.categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException(
                "Category ",
                "Category Id",
                categoryId
        ));

        return this.categoryToDto(category);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categoryList = this.categoryRepository.findAll();

        return categoryList.stream().map((this::categoryToDto)).collect(Collectors.toList());
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {

        Category category = this.categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException(
                "Category",
                " Category Id",
                categoryId
        ));

        category.setCategoryTitle(categoryDto.getCategoryTitle());
        category.setCategoryDesc(categoryDto.getCategoryDesc());

        Category updatedCategory = this.categoryRepository.save(category);
        return categoryToDto(updatedCategory);
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        this.categoryRepository.deleteById(categoryId);
    }

    private CategoryDto categoryToDto(Category category) {
        CategoryDto categoryDto = this.modelMapper.map(category, CategoryDto.class);
        return categoryDto;
    }

    private Category dtoToCategory(CategoryDto categoryDto) {
        Category category = this.modelMapper.map(categoryDto, Category.class);
        return category;
    }
}

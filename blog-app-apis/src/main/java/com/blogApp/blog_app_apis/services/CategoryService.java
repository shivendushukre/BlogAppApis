package com.blogApp.blog_app_apis.services;

import com.blogApp.blog_app_apis.payloads.CategoryDto;
import java.util.*;

public interface CategoryService {

    // create
    public CategoryDto createCategory(CategoryDto categoryDto);

    // read
    public CategoryDto getCategoryById(Integer categoryId);

    public List<CategoryDto> getAllCategories();

    // update
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

    // delete
    public void deleteCategory(Integer categoryId);

}

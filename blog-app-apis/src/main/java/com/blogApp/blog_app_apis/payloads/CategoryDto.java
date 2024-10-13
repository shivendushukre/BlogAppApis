package com.blogApp.blog_app_apis.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDto {

    private int category_id;

    @NotEmpty
    @Size(min = 1, max = 50, message = "Category Title must be of minimum 1 and maximum 50 characters.")
    private String categoryTitle;

    @NotEmpty
    @Size(min = 1, max = 100, message = "Category description must be of minimum 1 and maximum 100 characters.")
    private String categoryDesc;
}

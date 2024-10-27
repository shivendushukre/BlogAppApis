package com.blogApp.blog_app_apis.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {

    private int post_id;

    private String title;

    private String content;

    private String imageName;

    private Date createdDate;

    private CategoryDto category;

    private UserDto user;
}

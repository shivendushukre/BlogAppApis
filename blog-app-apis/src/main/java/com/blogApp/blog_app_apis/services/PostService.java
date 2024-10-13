package com.blogApp.blog_app_apis.services;

import com.blogApp.blog_app_apis.entities.Post;
import com.blogApp.blog_app_apis.payloads.PostDto;

import java.util.List;

public interface PostService {

    // create
    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

    // update
    public PostDto updatePost(PostDto postDto, Integer postId);

    // delete
    public void deletePost(Integer postId);

    // get all posts
    public List<PostDto> getAllPosts();

    public PostDto getPostById(Integer postId);

    // get all posts by category
    List<PostDto> getPostByCategory(Integer categoryId);

    //get all posts by User
    List<PostDto> getPostByUser(Integer userId);


    List<PostDto> searchPosts(String keyword);
}
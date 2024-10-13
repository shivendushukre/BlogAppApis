package com.blogApp.blog_app_apis.services.impl;

import com.blogApp.blog_app_apis.entities.Category;
import com.blogApp.blog_app_apis.entities.Post;
import com.blogApp.blog_app_apis.entities.User;
import com.blogApp.blog_app_apis.exceptions.ResourceNotFoundException;
import com.blogApp.blog_app_apis.payloads.CategoryDto;
import com.blogApp.blog_app_apis.payloads.PostDto;
import com.blogApp.blog_app_apis.repositories.CategoryRepo;
import com.blogApp.blog_app_apis.repositories.PostRepo;
import com.blogApp.blog_app_apis.repositories.UserRepo;
import com.blogApp.blog_app_apis.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {

        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException(
                "User",
                "user id",
                userId
        ));

        Category category = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException(
                "Category",
                "category id",
                categoryId
        ));

        Post post = this.dtoToPost(postDto);

        post.setImageName("default.png");
        post.setCreatedDate(new Date());
        post.setUser(user);
        post.setCategory(category);

        Post newPost = this.postRepo.save(post);
        return this.postToDto(newPost);
    }

    @Override
    public PostDto updatePost(PostDto postDto, Integer postId) {
        Post post = this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException(
                "Post",
                "Post id",
                postId
        ));

        post.setTitle(postDto.getTitle());
        post.setContent(post.getContent());

        Post updatedPost = this.postRepo.save(post);
        return this.postToDto(updatedPost);
    }

    @Override
    public void deletePost(Integer postId) {

    }

    @Override
    public List<PostDto> getAllPosts() {
        return List.of();
    }

    @Override
    public PostDto getPostById(Integer postId) {
        return null;
    }

    @Override
    public List<PostDto> getPostByCategory(Integer categoryId) {
        return List.of();
    }

    @Override
    public List<PostDto> getPostByUser(Integer userId) {
        return List.of();
    }

    @Override
    public List<PostDto> searchPosts(String keyword) {
        return List.of();
    }

    private PostDto postToDto(Post post) {
        PostDto postDto = this.modelMapper.map(post, PostDto.class);
        return postDto;
    }

    private Post dtoToPost(PostDto postDto) {
        Post post = this.modelMapper.map(postDto, Post.class);
        return post;
    }
}

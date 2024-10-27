package com.blogApp.blog_app_apis.repositories;

import com.blogApp.blog_app_apis.entities.Category;
import com.blogApp.blog_app_apis.entities.Post;
import com.blogApp.blog_app_apis.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {

    List<Post> findPostByUser(User user);

    List<Post> findPostByCategory(Category category);

    List<Post> findByTitleContaining(String title);
}

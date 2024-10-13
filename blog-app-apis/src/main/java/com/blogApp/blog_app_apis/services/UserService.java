package com.blogApp.blog_app_apis.services;

import com.blogApp.blog_app_apis.entities.User;
import com.blogApp.blog_app_apis.payloads.UserDto;

import java.util.List;

public interface UserService {

    public UserDto createUser(UserDto user);

    public UserDto updateUser(UserDto user, Integer userId);

    public UserDto getUserById(Integer userId);

    public List<UserDto> getAllUsers();

    public void deleteUser(Integer userId);
}

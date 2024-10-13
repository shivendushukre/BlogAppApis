package com.blogApp.blog_app_apis;

import com.blogApp.blog_app_apis.repositories.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlogAppApisApplicationTests {

	@Autowired
	private UserRepo userRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testUserRepo() {
		String className = this.userRepository.getClass().getName();
		System.out.println(className);

		String pckgName = this.userRepository.getClass().getPackageName();
		System.out.println(pckgName);
	}
}

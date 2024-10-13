package com.blogApp.blog_app_apis.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer post_id;

    @Column(nullable = false)
    private String title;

    private String content;

    private String imageName;

    private Date createdDate;

    @ManyToOne
    private Category category;

    @ManyToOne
    private User user;

}

package com.kiptoo.blog.listeners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import com.kiptoo.blog.repositories.AuthorRepository;
import com.kiptoo.blog.repositories.PostRepository;

import jakarta.annotation.Resource;

public class ContextEventListener implements ApplicationListener {
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private PostRepository postRepository;

    @Value("classpath:posts/*")
    private Resource[] postFiles;


    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        
        
    }
    
}

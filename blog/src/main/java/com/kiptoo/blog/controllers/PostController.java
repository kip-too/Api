package com.kiptoo.blog.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kiptoo.blog.entities.Post;
import com.kiptoo.blog.repositories.PostRepository;

@Controller
@RequestMapping("/posts")
public class PostController {
    private final PostRepository postRepository;
    private final int  PAGINATIONSIZE = 2;
   
      @Autowired
    public PostController(PostRepository postRepository){
        this.postRepository=postRepository;
    }
    public String getPaginatedposts(
       @RequestParam(value="page", defaultValue = "0") int page,
        @RequestParam(value="size", defaultValue = "" + PAGINATIONSIZE) int size,
        Model model){
        
      PageRequest pageRequest = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC,"id"));
      Page<Post> postsPage = postRepository.findAll(pageRequest);
      List<Post> posts = postsPage.toList();

      long postCount = postRepository.count();
      int numOfpages = (int) Math.ceil((postCount * 1.0)/PAGINATIONSIZE);

      model.addAttribute("posts", posts);
      model.addAttribute("postCount", postCount);
      model.addAttribute("pageRequested", page);
      model.addAttribute("paginationSize", PAGINATIONSIZE);
      model.addAttribute("numOfPages",numOfpages);
      return "posts";

    }
    @GetMapping("/{id}")
    public String getPostById(@PathVariable long id, Model model){
        Optional<Post> postOptional = postRepository.findById(id);
        if(postOptional.isPresent()){
            model.addAttribute("post", postOptional.get());

        }else{
            model.addAttribute("error", "no-post");
        }
        return "post";
    }
}

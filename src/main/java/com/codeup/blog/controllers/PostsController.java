package com.codeup.blog.controllers;

import com.codeup.blog.models.Post;
import com.codeup.blog.services.PostSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class PostsController {
    private final PostSvc service;

    @Autowired
    public PostsController(PostSvc service){
        this.service = service;
    }


    @GetMapping("/posts")
    public String index(Model viewModel){
//        ArrayList<Post> posts = new ArrayList<>();
        viewModel.addAttribute("posts", service.findAll());
//        posts.add(new Post("",""));
//        posts.add(new Post("",""));
//        viewModel.addAttribute(posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String postId(@PathVariable int id, Model modelView){
        modelView.addAttribute("post", service.findOne(id));
//        Post post = new Post("tile","body");
//        modelView.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String getCreate(Model viewModel){
        viewModel.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String postCreate(@ModelAttribute Post post){
        service.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String getEdit(@PathVariable int id, Model modelView){
        modelView.addAttribute("post", service.findOne(id));
        return "posts/edit";
    }

    @PostMapping
    public String postEdit(){
        return"";
    }

}

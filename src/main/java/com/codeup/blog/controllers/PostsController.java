package com.codeup.blog.controllers;

import com.codeup.blog.models.Post;
import com.codeup.blog.repositories.PostsRepository;
import com.codeup.blog.services.PostSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class PostsController {
    private final PostSvc service;
    private final PostsRepository postsDao;

    @Autowired
    public PostsController(PostSvc postSvc,PostsRepository postsDao){
        this.postsDao = postsDao;
        this.service = postSvc;
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
        modelView.addAttribute("post", service.findById((long) id));
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
        postsDao.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String showEditForm(Model modelView, @PathVariable long id) {
        Post existingPost = service.findById(id);
        modelView.addAttribute("post", existingPost);
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String updatePost(@PathVariable long id, @ModelAttribute Post post) {
        post.setId(id);
        service.save(post);

        return "redirect:/posts/" + post.getId();
    }

    @PostMapping("/posts/{id}/delete")
    public String removeFromExistence(@PathVariable long id) {
        service.delete(id);
        return "redirect:/posts";
    }
}

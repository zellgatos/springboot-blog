package com.codeup.blog.controllers;

import com.codeup.blog.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class PostsController {


    @GetMapping("/posts")
    public String index(Model viewModel){
        ArrayList<Post> posts = new ArrayList<>();

        posts.add(new Post("",""));
        posts.add(new Post("",""));
        viewModel.addAttribute(posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String postId(@PathVariable int id, Model modelView){
        Post post = new Post("tile","body");
        modelView.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String getCreate(){
        return "";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String postCreate(){
        return getCreate();
    }

}

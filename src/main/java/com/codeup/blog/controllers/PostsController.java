package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostsController {
    public String post = "This is a post";

    @GetMapping("/posts")
    @ResponseBody
    public String index(){
        return post;
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String postId(@PathVariable int id){
        return post + "by" + id ;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String getCreate(){
        return "<form method='post'>" +
                "<strong>Blog</strong>" +
                "<br>" +
                "<input type='text' name='blog'>" +
                "<br>" +
                "<button>Submit</button>" +
                "</form>";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String postCreate(){
        return getCreate();
    }

}

package com.codeup.blog.services;

import com.codeup.blog.models.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("postsvc")
public class PostSvc {
    private List<Post> posts;

    public PostSvc(){
        posts = new ArrayList<>();
        createPosts();
    }

    public List<Post> findAll(){
        return posts;
    }

    public Post save(Post post){
        post.setId((long) (posts.size() + 1));
        posts.add(post);
        return post;
    }

    public Post findOne(long id){
        return posts.get((int) (id - 1));
    }

    private void createPosts(){
        save(new Post("title1","description1"));
        save(new Post("title2","description2"));
        save(new Post("title3","description3"));
        save(new Post("title4","description4"));

    }
}

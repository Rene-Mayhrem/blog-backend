package com.blog.blog_api.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.blog_api.user.User;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/posts")
public class PostController {
  @Autowired
  private PostService service;

  @GetMapping
  public List<Post> getAllPosts () {
    return service.getAllPosts();
  }

  @PostMapping
  public Post createPost (@RequestBody Post post) {
    return service.createPost(post);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Post> getPostById (@PathVariable Long id) {
    return service.getPostById(id);
  }

  @PutMapping("/{id}")
  public Post updatePost (@PathVariable Long id, @RequestBody Post post) {
    return service.updatePost(id, post);
  }

  @DeleteMapping("/{id}")
  public void deletePost(@PathVariable Long id) {
    service.deletePost(id);
  }

  @GetMapping("/user/{userId}")
  public List<Post> getPostsByUser (@PathVariable Long userId) {
    User user = new User();
    user.setId(userId);
    return service.getPostsByUser(user);
  }
}

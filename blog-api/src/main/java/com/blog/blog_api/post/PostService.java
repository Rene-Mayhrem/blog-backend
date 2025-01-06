package com.blog.blog_api.post;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PostService {
  @Autowired
  private PostRepository repository;

  public List<Post> getAllPosts () {
    return repository.findAll();
  }

  public Post createPost (Post post) {
    return repository.save(post);
  }

  public ResponseEntity<Post> getPostById (Long id) {
    Optional<Post> post = repository.findById(id);
    return post.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  public Post updatePost (Long id, Post post) {
    post.setId(id);
    return repository.save(post);
  }

  public void deletePost (Long id) {
    repository.deleteById(id);
  }
}

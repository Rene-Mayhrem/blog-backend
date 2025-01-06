package com.blog.blog_api.post;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.blog_api.user.User;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
  List<Post> findByUser (User user);
}

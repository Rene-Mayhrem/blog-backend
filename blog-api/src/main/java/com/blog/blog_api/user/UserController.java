package com.blog.blog_api.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v1/users")
public class UserController {
  @Autowired
  private UserService service;

  @GetMapping
  public List<User> getAllUsers () {
    return service.getAllUsers();
  }

  @PostMapping
  public User createUser (@RequestBody User user) {
    return service.createUser(user);
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> getUserById (@PathVariable Long id) {
    return service.getUserById(id);
  }

  @PutMapping("/{id}")
  public User updateUser (@PathVariable Long id, @RequestBody User user) {
    return service.updateUser(id, user);
  }

  @DeleteMapping("/{id}")
  public void deleteUser (@PathVariable Long id) {
    service.deleteUser(id);
  }
  
}

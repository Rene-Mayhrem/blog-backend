package com.blog.blog_api.user;

import java.util.List;
import java.util.Optional;

import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  
  @Autowired
  private UserRepository repository;

  public List<User> getAllUsers () {
    return repository.findAll();
  }

  public User createUser (User user) {
    return repository.save(user);
  }

  public ResponseEntity<User> getUserById (Long id) {
    Optional<User> user = repository.findById(id);
    return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  public User updateUser (Long id, User user) {
    user.setId(id);
    return repository.save(user);
  }

  public void deleteUser (Long id) {
    repository.deleteById(id);
  }

}

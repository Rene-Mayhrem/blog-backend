package com.blog.blog_api.user;

import java.util.List;

import com.blog.blog_api.post.Post;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// ? Specfies that the class is an entity and is mapped to a db table
@Entity
// ? Lombok annotation that generates getters and setters, toString(), equals() methods
@Data
// ? Specfies and creates the constructor without any arguments
@NoArgsConstructor
// ? Specifies a constructor and creates the constructor with all the arguments
@AllArgsConstructor
public class User {
  // ? Creates an id as an index and also to have a generated value as identity
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotBlank(message = "Username is mandatory")
  @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
  private String username;
  @NotBlank(message = "Email is mandatory")
  @Email(message = "Email should be valid")
  private String email;
  @NotBlank(message = "Password is mandatory")
  @Size(min = 6, message = "Password must be at least 6 characters")
  private String password;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Post> posts;
}

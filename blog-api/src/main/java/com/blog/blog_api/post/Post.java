package com.blog.blog_api.post;

import java.time.LocalDateTime;

import com.blog.blog_api.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "Title is mandatory")
  @Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters")
  private String title;

  @NotBlank(message = "Content is mandatory")
  @Size(min = 10, message = "Content must be at least 10 characters")
  private String content;

  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  @ManyToOne
  private User user;
}

package com.project.blog.repository;

import com.project.blog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface postRepo extends JpaRepository<Post,Integer> {
}

package com.study.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.domain.post.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}

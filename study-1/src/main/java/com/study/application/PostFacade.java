package com.study.application;

import org.springframework.stereotype.Service;

import com.study.domain.post.Post;
import com.study.domain.post.PostCommand;
import com.study.domain.post.PostService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostFacade {
	
	private final PostService postService;
	
	public Post createPost(PostCommand postCommand) {
		return postService.createPost(postCommand);
	}
}

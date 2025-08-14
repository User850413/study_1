package com.study.domain.post;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

	private final PostStore postStore;
	
	@Override
	public Post createPost(PostCommand postCommand) {
		
		Post post = postCommand.toEntity();
		
		return postStore.postStore(post);
	}

}

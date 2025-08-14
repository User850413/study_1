package com.study.infrastructure;

import org.springframework.stereotype.Repository;

import com.study.domain.post.Post;
import com.study.domain.post.PostStore;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
@RequiredArgsConstructor
public class PostStoreImpl implements PostStore{

	private final PostRepository postRepository;
	
	@Override
	public Post postStore(Post post) {
		return postRepository.save(post);
	}

}

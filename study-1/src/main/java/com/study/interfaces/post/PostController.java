package com.study.interfaces.post;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.application.PostFacade;
import com.study.domain.post.Post;
import com.study.domain.post.PostCommand;
import com.study.interfaces.CommonResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {
	private final PostFacade postFacade;
	
	@PostMapping("/create")
	public CommonResponse createPost(@RequestBody @Valid PostDTO.CreatePostRequest request) {
		log.debug("post create!");
		
		PostCommand postCommand = request.toCommand();
		Post createdPost = postFacade.createPost(postCommand);
		var response = new PostDTO.PostStoreResponse(createdPost.getId());
		
		return CommonResponse.success(response);
		
	}
}

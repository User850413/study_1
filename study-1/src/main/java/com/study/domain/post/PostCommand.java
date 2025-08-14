package com.study.domain.post;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class PostCommand {
	
	private Long Id;
	private String title;
	private String content;
	private String author;
	
	public Post toEntity() {
		return Post.builder()
				.title(title)
				.content(content)
				.author(author)
				.build();
	}
}

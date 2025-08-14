package com.study.interfaces.post;

import com.study.domain.post.PostCommand;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

public class PostDTO {

	@Getter
	@Builder
	@ToString
	public static class CreatePostRequest{
		@NotNull(message = "제목은 필수 값입니다.")
		private String title;
		
		@NotNull(message = "내용은 필수 값입니다.")
		private String content;
		
		@NotNull(message = "작성자는 필수 값입니다.")
		private String author;
		
		public PostCommand toCommand() {
			return PostCommand.builder()
					.title(title)
					.content(content)
					.author(author)
					.build();
		}
	}
	
	@Getter
	@ToString
	public static class PostStoreResponse {
		private final String postId;
		public PostStoreResponse(Long postId) {
			this.postId = postId.toString();
		}
	}
	
}

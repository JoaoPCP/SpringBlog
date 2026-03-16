package jp.blog.application.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;

@Getter
public class CommentDTO {
    @NotNull()
    private Long authorId;
    @Size(min = 50, max = 1000)
    private String content;
}

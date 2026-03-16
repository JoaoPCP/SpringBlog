package jp.blog.application.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDTO {
    @NotNull()
    private Long authorId;
    @Size(min = 50, max = 1000)
    private String content;
}

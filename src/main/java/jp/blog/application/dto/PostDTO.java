package jp.blog.application.dto;

import jakarta.validation.constraints.*;
import jp.blog.domain.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDTO {
    @NotNull()
    private Long authorId;
    @Size(min = 20, max = 1000)
    private String title;
    @NotNull(message = "Content can't be null")
    private String content;
    @NotNull(message = "Category is required")
    private Category category;
}

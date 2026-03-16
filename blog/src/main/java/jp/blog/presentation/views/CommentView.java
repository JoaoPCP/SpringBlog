package jp.blog.presentation.views;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CommentView {
    private Long id;
    private Long authorId;
    private String authorName;
    private Long postId;
    private String content;
}

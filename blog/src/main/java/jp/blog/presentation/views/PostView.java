package jp.blog.presentation.views;

import jp.blog.domain.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostView {
    private Long id;
    private String title;
    private String category;
    private UserView author;
    private Date createdAt;
    private String content;
    private List<CommentView> comments;
}


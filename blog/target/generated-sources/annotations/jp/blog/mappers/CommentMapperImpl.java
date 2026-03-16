package jp.blog.mappers;

import javax.annotation.processing.Generated;
import jp.blog.application.dto.CommentDTO;
import jp.blog.domain.Comment;
import jp.blog.domain.Post;
import jp.blog.domain.User;
import jp.blog.presentation.views.CommentView;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-10T17:28:18-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class CommentMapperImpl implements CommentMapper {

    @Override
    public CommentDTO toDTO(Comment comment) {
        if ( comment == null ) {
            return null;
        }

        CommentDTO commentDTO = new CommentDTO();

        return commentDTO;
    }

    @Override
    public Comment toEntity(CommentDTO commentDTO) {
        if ( commentDTO == null ) {
            return null;
        }

        Comment comment = new Comment();

        comment.setContent( commentDTO.getContent() );

        return comment;
    }

    @Override
    public CommentView toView(Comment comment) {
        if ( comment == null ) {
            return null;
        }

        CommentView commentView = new CommentView();

        commentView.setAuthorId( commentAuthorId( comment ) );
        commentView.setAuthorName( commentAuthorUsername( comment ) );
        commentView.setPostId( commentPostId( comment ) );
        commentView.setId( comment.getId() );
        commentView.setContent( comment.getContent() );

        return commentView;
    }

    private Long commentAuthorId(Comment comment) {
        User author = comment.getAuthor();
        if ( author == null ) {
            return null;
        }
        return author.getId();
    }

    private String commentAuthorUsername(Comment comment) {
        User author = comment.getAuthor();
        if ( author == null ) {
            return null;
        }
        return author.getUsername();
    }

    private Long commentPostId(Comment comment) {
        Post post = comment.getPost();
        if ( post == null ) {
            return null;
        }
        return post.getId();
    }
}

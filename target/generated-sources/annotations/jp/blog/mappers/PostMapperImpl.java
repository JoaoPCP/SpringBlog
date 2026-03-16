package jp.blog.mappers;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import jp.blog.application.dto.PostDTO;
import jp.blog.domain.Comment;
import jp.blog.domain.Post;
import jp.blog.presentation.views.CommentView;
import jp.blog.presentation.views.PostView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-16T19:47:48-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class PostMapperImpl implements PostMapper {

    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public Post toEntity(PostDTO postDTO) {
        if ( postDTO == null ) {
            return null;
        }

        Post post = new Post();

        post.setTitle( postDTO.getTitle() );
        post.setContent( postDTO.getContent() );
        post.setCategory( postDTO.getCategory() );

        return post;
    }

    @Override
    public PostView toView(Post post) {
        if ( post == null ) {
            return null;
        }

        PostView postView = new PostView();

        postView.setId( post.getId() );
        postView.setTitle( post.getTitle() );
        if ( post.getCategory() != null ) {
            postView.setCategory( post.getCategory().name() );
        }
        postView.setAuthor( userMapper.toView( post.getAuthor() ) );
        postView.setCreatedAt( post.getCreatedAt() );
        postView.setContent( post.getContent() );
        postView.setComments( commentListToCommentViewList( post.getComments() ) );

        return postView;
    }

    protected List<CommentView> commentListToCommentViewList(List<Comment> list) {
        if ( list == null ) {
            return null;
        }

        List<CommentView> list1 = new ArrayList<CommentView>( list.size() );
        for ( Comment comment : list ) {
            list1.add( commentMapper.toView( comment ) );
        }

        return list1;
    }
}

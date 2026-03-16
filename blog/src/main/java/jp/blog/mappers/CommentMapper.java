package jp.blog.mappers;

import jp.blog.application.dto.CommentDTO;
import jp.blog.presentation.views.CommentView;
import jp.blog.domain.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface CommentMapper {
    CommentDTO toDTO(Comment comment);
    Comment toEntity(CommentDTO commentDTO);
    @Mapping(source = "author.id", target = "authorId")
    @Mapping(source = "author.username", target = "authorName")
    @Mapping(source = "post.id", target = "postId")
    CommentView toView(Comment comment);
}

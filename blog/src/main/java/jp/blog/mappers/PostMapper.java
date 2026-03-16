package jp.blog.mappers;

import jp.blog.application.dto.PostDTO;
import jp.blog.domain.Post;
import jp.blog.presentation.views.PostView;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CommentMapper.class, UserMapper.class})
public interface PostMapper {
    Post toEntity(PostDTO postDTO);
    PostView toView(Post post);
}

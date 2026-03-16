package jp.blog.mappers;


import jp.blog.application.dto.UserDTO;
import jp.blog.domain.User;
import jp.blog.presentation.views.UserView;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CommentMapper.class, PostMapper.class})
public interface UserMapper {
        UserDTO toDTO(User user);
        User toEntity(UserDTO userDTO);
        UserView toView(User user);
}

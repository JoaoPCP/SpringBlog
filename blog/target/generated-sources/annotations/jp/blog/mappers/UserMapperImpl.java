package jp.blog.mappers;

import javax.annotation.processing.Generated;
import jp.blog.application.dto.UserDTO;
import jp.blog.domain.User;
import jp.blog.presentation.views.UserView;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-10T17:28:18-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO toDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setUsername( user.getUsername() );
        userDTO.setEmail( user.getEmail() );
        userDTO.setPassword( user.getPassword() );

        return userDTO;
    }

    @Override
    public User toEntity(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        user.setUsername( userDTO.getUsername() );
        user.setEmail( userDTO.getEmail() );
        user.setPassword( userDTO.getPassword() );

        return user;
    }

    @Override
    public UserView toView(User user) {
        if ( user == null ) {
            return null;
        }

        UserView userView = new UserView();

        userView.setId( user.getId() );
        userView.setUsername( user.getUsername() );
        userView.setEmail( user.getEmail() );

        return userView;
    }
}

package jp.blog.application.dto;

import jakarta.validation.constraints.*;
import jp.blog.Messager;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    @Size(min = 3, max = 50, message = "U")
    private String username;
    @Email(message = Messager.INVALID_EMAIL)
    private String email;
    @NotNull(message = "password" + Messager.IS_REQUIRED)
    private String password;
}

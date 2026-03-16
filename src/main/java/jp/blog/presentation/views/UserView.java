package jp.blog.presentation.views;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserView {
    private Long id;
    private String username;
    private String email;
}

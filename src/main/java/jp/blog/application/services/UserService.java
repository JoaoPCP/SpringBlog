package jp.blog.application.services;

import jp.blog.application.dto.UserDTO;
import jp.blog.mappers.UserMapper;
import jp.blog.domain.User;
import jp.blog.infra.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public User save(UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        return userRepository.save(user);
    }
    public List<User> findAll() { return userRepository.findAll(); }
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }


}

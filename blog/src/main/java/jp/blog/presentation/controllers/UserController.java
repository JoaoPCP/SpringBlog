package jp.blog.presentation.controllers;

import jp.blog.domain.User;
import jp.blog.application.dto.UserDTO;
import jp.blog.application.services.UserService;
import jp.blog.mappers.UserMapper;
import jp.blog.presentation.views.UserView;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;
    private UserMapper userMapper;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDTO user) {
        User newUser = userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @GetMapping
    public ResponseEntity<List<UserView>> getAllUsers() {
        List<User> users = userService.findAll();
        List<UserView> userViews = users.stream().map(userMapper::toView).toList();
        return ResponseEntity.ok(userViews);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserView> findUserById(@PathVariable Long id) {
        User user = userService.findById(id);
        return ResponseEntity.ok(userMapper.toView(user));
    }
}
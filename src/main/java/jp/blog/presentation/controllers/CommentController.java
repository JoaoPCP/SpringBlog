package jp.blog.presentation.controllers;

import jp.blog.application.dto.CommentDTO;
import jp.blog.mappers.CommentMapper;
import jp.blog.application.services.CommentService;
import jp.blog.application.services.PostService;
import jp.blog.application.services.UserService;
import jp.blog.presentation.views.CommentView;
import jp.blog.domain.Comment;
import jp.blog.domain.Post;
import jp.blog.domain.User;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/comments")
@AllArgsConstructor
public class CommentController {
    private final CommentService commentService;
    private final UserService userService;
    private final PostService postService;
    private final CommentMapper commentMapper;

    @PostMapping("{postId}")
    public ResponseEntity<CommentView> addCommentPost(@PathVariable Long postId, @RequestBody CommentDTO commentDTO) {
        User author     = userService.findById(commentDTO.getAuthorId());
        Post post       = postService.findById(postId);
        Comment comment = commentService.addCommentToPost(post, author, commentDTO);
        CommentView commentView = commentMapper.toView(comment);

        return ResponseEntity.status(HttpStatus.CREATED).body(commentView);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteComment(@PathVariable Long id) {
        Comment comment = commentService.findById(id);
        commentService.deleteComment(comment);
        return ResponseEntity.ok("Comentário deletado com sucesso");
    }
}

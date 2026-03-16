package jp.blog.application.services;

import jp.blog.application.dto.CommentDTO;
import jp.blog.mappers.CommentMapper;
import jp.blog.domain.Comment;
import jp.blog.domain.Post;
import jp.blog.domain.User;
import jp.blog.infra.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    public Comment addCommentToPost(Post post, User author, CommentDTO commentDTO) {
        Comment comment = commentMapper.toEntity(commentDTO);
        comment.setPost(post);
        comment.setAuthor(author);
        commentRepository.save(comment);
        return comment;
    }

    public Comment findById(Long id) {
        return commentRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
    }

    public void deleteComment(Comment comment) {
        commentRepository.delete(comment);
    }
}

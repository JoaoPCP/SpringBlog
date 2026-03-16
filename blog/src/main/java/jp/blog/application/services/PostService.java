package jp.blog.application.services;

import jp.blog.application.dto.PostDTO;
import jp.blog.mappers.PostMapper;
import jp.blog.domain.Category;
import jp.blog.domain.Post;
import jp.blog.domain.User;
import jp.blog.infra.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PostService {
    private final PostRepository repo;
    private final PostMapper postMapper;

    public Post createPost(PostDTO postDTO, User author) {
        Post post = postMapper.toEntity(postDTO);
        post.setAuthor(author);
        repo.save(post);
        return post;
    }

    public List<Post> findAll(String title, String categoryName) {
        if (title != null && categoryName != null) {
            Category categoryEnum = Category.valueOf(categoryName.toUpperCase());
            return repo.findByTitleContainingIgnoreCaseAndCategory(title, categoryEnum, Sort.by(Sort.Direction.DESC, "createdAt"));
        } else if (categoryName != null) {
            Category categoryEnum = Category.valueOf(categoryName.toUpperCase());
            return repo.findByCategory(categoryEnum, Sort.by(Sort.Direction.DESC, "createdAt"));
        } else if (title != null) {
            return repo.findByTitleContainingIgnoreCase(title, Sort.by(Sort.Direction.DESC, "createdAt"));
        }
        return repo.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
    }

    public Post findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
    }

    public void deletePost(Post post) {
        repo.delete(post);
    }
}

package jp.blog.infra;

import jp.blog.domain.Category;
import jp.blog.domain.Post;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {
    List<Post> findByTitle(String title, Sort sort);
    Post findByAuthorId(Long userId, Sort sort);
    List<Post> findByCategory(Category category, Sort sort);
    List<Post> findByTitleContainingIgnoreCaseAndCategory(String title, Category categoryName, Sort sort);
    List<Post> findByTitleContainingIgnoreCase(String title, Sort sort);
}

package jp.blog.infra;

import jp.blog.domain.Category;
import jp.blog.domain.Post;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {
    public List<Post> findByTitle(String title, Sort sort);
    public Post findByAuthorId(Long userId, Sort sort);
    public List<Post> findByCategory(Category category, Sort sort);
    public List<Post> findByTitleContainingIgnoreCaseAndCategory(String title, Category categoryName, Sort sort);
    public List<Post> findByTitleContainingIgnoreCase(String title, Sort sort);
}

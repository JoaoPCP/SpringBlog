// java
package jp.blog.presentation.controllers;

import jp.blog.application.dto.PostDTO;
import jp.blog.mappers.PostMapper;
import jp.blog.application.services.PostService;
import jp.blog.domain.Post;
import jp.blog.domain.User;
import jp.blog.application.services.UserService;
import jp.blog.presentation.views.PostView;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/posts")
@AllArgsConstructor
public class PostController {

    private final PostService postService;
    private final UserService userService;
    private final PostMapper postMapper;

    private final UriComponentsBuilder uriBuilder = UriComponentsBuilder.newInstance();

    @PostMapping
    public ResponseEntity<PostView> createPost(@RequestBody PostDTO post) {
        User author = userService.findById(post.getAuthorId());
        Post newPost = postService.createPost(post, author);
        URI uri = uriBuilder.path("/posts/{id}").buildAndExpand(newPost.getId()).toUri();
        return ResponseEntity.created(uri).body(postMapper.toView(newPost));
    }

    @GetMapping
    public ResponseEntity<List<PostView>> getAllPosts(@RequestParam(required = false) String title, @RequestParam(required = false) String categoryName) {
        List<Post> posts = postService.findAll(title, categoryName);
        List<PostView> response = posts.stream().map(postMapper::toView).toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<PostView> getPostById(@PathVariable Long id) {
        Post post = postService.findById(id);
        return ResponseEntity.ok(postMapper.toView(post));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePost(@PathVariable Long id) {
        Post post = postService.findById(id);
        postService.deletePost(post);
        return ResponseEntity.ok("Post deletado com sucesso");
    }
}

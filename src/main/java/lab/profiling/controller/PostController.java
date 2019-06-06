package lab.profiling.controller;

import lab.profiling.dto.PostDto;
import lab.profiling.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {

  private PostService postService;

  @Autowired
  public PostController(PostService postService) {
    this.postService = postService;
  }

  @GetMapping("/posts/latest")
  public List<PostDto> getLatestPosts() {
    return postService.getLatestPosts();
  }
}

package lab.profiling.service;

import lab.profiling.dto.AuthorDto;
import lab.profiling.dto.PostDto;
import lab.profiling.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {
  private PostRepository postRepository;

  @Autowired
  public PostService(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  public List<PostDto> getLatestPosts() {
    return postRepository.findFirst10ByOrderByCreatedAtDesc()
                         .stream()
                         .map(p -> PostDto.builder()
                                          .id(p.getId())
                                          .author(AuthorDto.builder()
                                                           .id(p.getAuthor()
                                                                .getId())
                                                           .name(p.getAuthor()
                                                                  .getName())
                                                           .build())
                                          .title(p.getTitle())
                                          .content(p.getContent())
                                          .build()
                         )
                         .collect(Collectors.toList());
  }
}

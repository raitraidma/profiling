package lab.profiling.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class PostDto {
  private Integer id;
  private String title;
  private AuthorDto author;
  private String content;
  private List<CommentDto> comments;
}

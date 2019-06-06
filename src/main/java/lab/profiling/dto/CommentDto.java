package lab.profiling.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CommentDto {
  private Integer id;
  private AuthorDto author;
  private String content;
}

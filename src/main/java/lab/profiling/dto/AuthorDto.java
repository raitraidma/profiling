package lab.profiling.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AuthorDto {
  private Integer id;
  private String name;
}

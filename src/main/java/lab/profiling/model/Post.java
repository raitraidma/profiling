package lab.profiling.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "post")
public class Post extends BaseEntity {

  @Column(name = "title", nullable = false)
  private String title;

  @Column(name = "content", nullable = false)
  private String content;

  @ManyToOne
  @JoinColumn(name = "author_id", nullable = false)
  private Author author;

  @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<Comment> comments;
}

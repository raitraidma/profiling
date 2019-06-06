package lab.profiling.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "author")
public class Author extends BaseEntity {

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "is_active", nullable = false)
  private Boolean isActive;
}

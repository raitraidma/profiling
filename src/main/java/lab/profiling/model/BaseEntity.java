package lab.profiling.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "created_at", nullable = false)
  private ZonedDateTime createdAt;
}

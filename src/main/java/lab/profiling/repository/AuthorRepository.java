package lab.profiling.repository;

import lab.profiling.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
  Optional<Author> findByIdAndIsActiveTrue(Integer id);
}

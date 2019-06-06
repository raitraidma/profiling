package lab.profiling.repository;

import lab.profiling.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
  List<Post> findFirst10ByOrderByCreatedAtDesc();
}

package lab.profiling.repository;

import lab.profiling.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
  int countByContentIgnoreCaseContaining(String text);
  List<Comment> findFirst10ByOrderByCreatedAtDesc();
}

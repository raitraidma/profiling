package lab.profiling.service;

import lab.profiling.dto.AuthorDto;
import lab.profiling.dto.CommentDto;
import lab.profiling.repository.CommentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CommentService {
  private CommentRepository commentRepository;

  @Autowired
  public CommentService(CommentRepository commentRepository) {
    this.commentRepository = commentRepository;
  }

  public int getCountOfCommentsThatContainText(String text) {
    return commentRepository.countByContentIgnoreCaseContaining(text);
  }

  public List<CommentDto> getLatestComments() {
    return commentRepository.findFirst10ByOrderByCreatedAtDesc()
                            .stream()
                            .map(c -> CommentDto.builder()
                                                .id(c.getId())
                                                .author(AuthorDto.builder()
                                                                 .id(c.getAuthor()
                                                                      .getId())
                                                                 .name(c.getAuthor()
                                                                        .getName())
                                                                 .build())
                                                .content(c.getContent())
                                                .build())
                            .collect(Collectors.toList());
  }

  public void logCountOfComments(int countOfCommentsThatContainText) {
    log.info("There were {} comments", countOfCommentsThatContainText);
  }
}

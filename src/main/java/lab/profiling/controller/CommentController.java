package lab.profiling.controller;

import lab.profiling.dto.CommentDto;
import lab.profiling.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentController {

  private CommentService commentService;

  @Autowired
  public CommentController(CommentService commentService) {
    this.commentService = commentService;
  }

  @GetMapping("/comments/contains/{text}/count")
  public int getCountOfCommentsThatContainText(@PathVariable String text) {
    int countOfCommentsThatContainText = commentService.getCountOfCommentsThatContainText(text);
    commentService.logCountOfComments(countOfCommentsThatContainText);
    return countOfCommentsThatContainText;
  }

  @GetMapping("/comments/latest")
  public List<CommentDto> getLatestComments() {
    return commentService.getLatestComments();
  }
}

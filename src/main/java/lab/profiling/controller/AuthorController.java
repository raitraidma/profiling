package lab.profiling.controller;

import lab.profiling.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {

  private AuthorService authorService;

  @Autowired
  public AuthorController(AuthorService authorService) {
    this.authorService = authorService;
  }

  @GetMapping(value = "/authors/{id}/avatar", produces = "image/jpg")
  public byte[] getAvatar(@PathVariable Integer id) {
    return authorService.getAvatarOfActiveAuthor(id);
  }
}

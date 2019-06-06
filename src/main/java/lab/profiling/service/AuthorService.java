package lab.profiling.service;

import lab.profiling.model.Author;
import lab.profiling.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorService {

  private AvatarService avatarService;
  private AuthorRepository authorRepository;

  @Autowired
  public AuthorService(AvatarService avatarService, AuthorRepository authorRepository) {
    this.avatarService = avatarService;
    this.authorRepository = authorRepository;
  }

  public byte[] getAvatarOfActiveAuthor(Integer authorId) {
    try {
      Optional<Author> author = authorRepository.findByIdAndIsActiveTrue(authorId);
      if (author.isPresent()) {
        return avatarService.getImageFromExternalService(author.get());
      }
    } catch (Exception ignore) {}

    return new byte[0];
  }
}

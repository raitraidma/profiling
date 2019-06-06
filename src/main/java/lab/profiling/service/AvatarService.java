package lab.profiling.service;

import lab.profiling.model.Author;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AvatarService {
  private ResourceLoader resourceLoader;

  @Autowired
  public AvatarService(ResourceLoader resourceLoader) {
    this.resourceLoader = resourceLoader;
  }

  @Cacheable("avatar")
  public byte[] getImageFromExternalService(Author author) throws IOException {
    return IOUtils.toByteArray(resourceLoader.getResource("classpath:avatars/" + (author.getId() % 4 + 1) + ".jpg").getInputStream());
  }
}

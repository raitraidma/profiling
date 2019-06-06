package lab.profiling;

import com.opentable.db.postgres.embedded.EmbeddedPostgres;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import javax.annotation.PreDestroy;
import java.io.IOException;

@SpringBootApplication
@EnableCaching
public class ProfilingApplication {
  private static EmbeddedPostgres EMBEDDED_POSTGRES;

  public static void main(String[] args) throws IOException {

    EMBEDDED_POSTGRES = EmbeddedPostgres.builder()
                                        .setPort(15432)
                                        .setCleanDataDirectory(true)
                                        .start();

    SpringApplication.run(ProfilingApplication.class, args);
  }

  @PreDestroy
  public void onExit() throws IOException {
    if (EMBEDDED_POSTGRES != null) {
      EMBEDDED_POSTGRES.close();
    }
  }
}

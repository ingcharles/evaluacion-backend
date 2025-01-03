package ec.gob.registrosocial.evaluacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {"ec.gob.registrosocial"})
@EntityScan(basePackages = {"ec.gob.registrosocial"})
@SpringBootApplication(scanBasePackages = "ec.gob.registrosocial")
public class RegistroSocialServiceApplication {
  public static void main(String[] args) {
    SpringApplication.run(RegistroSocialServiceApplication.class, args);
  }
}

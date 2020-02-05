package basket;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class LoadDatabase {

  @Bean
  CommandLineRunner initDatabase(BasketRepository repository) {
    return args -> {
      log.info("Preloading " + repository.save(new Basket(12, "[{\"productId\":12,\"quantity\":1}]")));
      log.info("Preloading " + repository.save(new Basket(23, "[{\"productId\":2112,\"quantity\":4}]")));
    };
  }
}
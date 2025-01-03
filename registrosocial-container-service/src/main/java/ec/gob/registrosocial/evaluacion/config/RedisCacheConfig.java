package ec.gob.registrosocial.evaluacion.config;

import com.github.benmanes.caffeine.cache.Caffeine;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.redisson.spring.cache.CacheConfig;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@EnableCaching
public class RedisCacheConfig {

  private static final String LOCALIZACION_NIVEL = "localizacion";
  private static final String LOCALIZACION_ID = "findByIdLocalizacion";
  private static final Integer MINUTES_EXPIRES_MATERIA = 720;

  //@Value("${redis.address}")
  //private String redisAddress;

  @Bean
  @Profile("dev")
  public CacheManager cacheManager() {
    CaffeineCacheManager cacheManager = new CaffeineCacheManager();
    cacheManager.setCaffeine(
        Caffeine.newBuilder()
            .maximumSize(2000)
            .expireAfterAccess(MINUTES_EXPIRES_MATERIA, TimeUnit.MINUTES));
    cacheManager.setCacheNames(List.of(LOCALIZACION_NIVEL, LOCALIZACION_ID));
    return cacheManager;
  }

  /*@Bean
  @Profile("prod")
  public CacheManager getCahe(RedissonClient redissonClient) {
    Map<String, CacheConfig> config = new HashMap<>();
    config.put(LOCALIZACION_NIVEL, createCacheConfigWithTTL(24));
    config.put(LOCALIZACION_ID, createCacheConfigWithTTL(24));
    return new RedissonSpringCacheManager(redissonClient, config);
  }*/

  private CacheConfig createCacheConfigWithTTL(int hours) {
    CacheConfig cacheConfig = new CacheConfig();
    cacheConfig.setTTL(TimeUnit.HOURS.toMillis(hours));
    return cacheConfig;
  }

  /*@Bean(destroyMethod = "shutdown")
  @Profile("prod")
  public RedissonClient redisson() {
    final Config config = new Config();
    config.useSingleServer().setAddress(redisAddress);
    return Redisson.create(config);
  }*/
}

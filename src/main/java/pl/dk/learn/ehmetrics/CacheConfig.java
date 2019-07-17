package pl.dk.learn.ehmetrics;

import net.sf.ehcache.Cache;
import net.sf.ehcache.config.CacheConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
class CacheConfig {

    static final String CACHE_NAME = "playCache";

    static final int MAX_ELEMENTS_IN_MEMORY = 200;

    @Bean
    Cache playCache(EhCacheCacheManager cacheManager) {
        CacheConfiguration cacheConfiguration = new CacheConfiguration()
            .name(CACHE_NAME)
            .maxEntriesLocalHeap(MAX_ELEMENTS_IN_MEMORY);
        Cache cache = new Cache(cacheConfiguration);
        cacheManager.getCacheManager().addCache(cache);
        cacheManager.initializeCaches();
        return cache;
    }
}

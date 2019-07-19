package pl.dk.learn.ehmetrics

import net.sf.ehcache.Cache
import net.sf.ehcache.Element
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cache.CacheManager
import spock.lang.Specification

import static java.util.UUID.randomUUID
import static java.util.concurrent.TimeUnit.SECONDS
import static org.awaitility.Awaitility.await

@SpringBootTest
class CacheMetricsIntSpec extends Specification {

    @Autowired
	CacheManager cacheManager

    def "should generate cache metrics"() {
		def playCache = (Cache) cacheManager.getCache(CacheConfig.CACHE_NAME).getNativeCache()
		when:
        generateCacheTraffic(playCache)

        then:
        await().atMost(5, SECONDS).until {
            playCache.getStatistics().cacheMissCount() > 0
        }
        noExceptionThrown()
    }

    private void generateCacheTraffic(Cache playCache) {
        for (int i = 1; i < 1000; i++) {
            playCache.put(new Element(i%7, randomUUID()))
        }
        for (int i = 1; i < 1000; i++) {
            playCache.get(i%9)
        }
    }
}

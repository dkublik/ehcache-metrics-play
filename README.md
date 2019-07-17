EhCache Metrics Demo
===============

code example for https://dkublik.github.io/2019/07/17/default-metrics-in-spring-boot.html


## Requirements

* Java 11

* Gradle 5.5.1

## To run
import to your favorite IDE and lunch EhMetricsPlayApplication.java  
or  
from command line:
```
./gradlew bootRun
```

Metrics will be written to logs every 1 minute.
The can be also checked at http://localhost:8080/actuator/metrics

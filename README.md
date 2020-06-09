# Building REST services with Spring And Spring Actuators Tutorial
###### Code Author: Joseph Ishak

## Security
User: user
Password: Shown in console on start

## @Annotations Covered From Week 2
1. ### Component - Makes a class the most generic type of Spring Bean
2. ### Endpoint - Identifies a type as being an actuator endpoint that provides information about the running application. Endpoints can be exposed over a variety of technologies including JMX and HTTP
3. ### ReadOperation - Maps to HTTP GET
4. ### Getter - Lombok to generate the default getter
5. ### RequiredArgsConstructor - Generates a constructor with required arguments. Required arguments are final fields and fields with constraints such as @NonNull.


## Endpoints
1. ### - /actuator - Shows features currently available
2. ### - /actuator/health - Shows a single status of UP, DOWN, OUT_OF_SERVICE, UNKNOWN
3. ### - /actuator/metrics - Shows metrics about threads, connections, memory, files and much more
4. ### - /actuators/loggers - Shows all the different loggers
5. ### - /actuators/info - Allows you to provide additional information through the use of application properties. Start every property with info.property_name 
6. ### - /actuators/httptracing - Shows information about previous requests to the API
7. ### - /actuators/threaddump - The first one gives an insight into which threads are currently running.
8. ### - /actuators/heapdump - When calling this endpoint, a complete *.HPROF file is downloaded. This file can then be imported within a tool like VisualVM or JProfiler to see exactly what’s happening.




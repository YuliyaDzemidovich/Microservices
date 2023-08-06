### Experiments with microservices

There are 3 modules:
1. microservice1  
2. microservice2  
3. microservice3

#### Use case  
User does a HTTP request which triggers this flow:  

1. microservice1 endpoint -> kafka producer;  
2. kafka consumer -> feign call to microservice2  
3. microservice2 endpoint -> restTemplate call to microservice3  
4. microservice3 endpoint


**TraceId** in logs is consistent across all microservices and in kafka topic.

See microservice1 readme for more info.
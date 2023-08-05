# Microservice 1

#### Contains:
1. REST controller  
2. Kafka producer and consumer  

Entry endpoint -> produces to kafka topic -> (separate thread) consume from kafka topic

#### 1. Run Kafka in docker:
```
docker compose -f zk-single-kafka-single.yml up -d
docker compose -f zk-single-kafka-single.yml down
```
#### 2. Use kafka-ui to create a new kafka topic
#### 3. Start Spring Boot application in modules microservice 1, 2, 3
#### 4. Send any message to /test endpoint
#### 5. Observe logs in all microservices

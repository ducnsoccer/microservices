./gradlew :microservices:product-service:build
cd microservices/product-service
docker build -t product-service .
docker images | grep product-service
docker run --rm -p8080:8080 -e "SPRING_PROFILES_ACTIVE=docker" product-service
docker run -d -p8080:8080 -e "SPRING_PROFILES_ACTIVE=docker" --name my-prd-srv product-service
docker logs my-prd-srv -f
--tail 0
--since 5m
docker rm -f my-prd-srv

./gradlew build && docker-compose build
docker images | grep demo01
docker-compose up -d
docker-compose ps
docker-compose logs -f
docker-compose logs -f product review
localhost:8080/product-composite/123
docker-compose down

docker system prune -f --volumes
docker-compose up -d --scale product=0
docker-compose up -d --scale product=1

docker ps --format {{.Names}}

http://localhost:8080/swagger-ui.html

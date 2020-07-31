FROM openjdk:8u141-jre
ENV TZ="Asia/Ho_Chi_Minh"
EXPOSE 5432 6789
VOLUME /tmp
ADD target/auth-service-0.0.1-SNAPSHOT.jar auth-service.jar
ENTRYPOINT exec java -jar auth-service.jar
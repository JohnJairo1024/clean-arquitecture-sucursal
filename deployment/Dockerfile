FROM openjdk:8-jdk-alpine
COPY ${JAR_FILE} app-service.jar
#EXPOSE 8085
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app-service.jar"]
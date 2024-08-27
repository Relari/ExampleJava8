FROM openjdk:11.0-jre-slim
EXPOSE 8082
ARG JAR_FILE=target/*.jar
ADD ${JAR_FILE} ms-historical.jar
ENTRYPOINT ["java","-jar","/ms-historical.jar"]
FROM openjdk:8u92-jre-alpine
MAINTAINER pk

COPY ./target/assignment.jar /assignment.jar

ENTRYPOINT ["java","-jar","assignment.jar"]

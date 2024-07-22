FROM openjdk:17-alpine

WORKDIR /app

COPY pom.xml
RUN mvn package 

COPY target/*.jar tp_AeroFIT.mvc

EXPOSE 8080

CMD ["java","-jar","app.jar"]
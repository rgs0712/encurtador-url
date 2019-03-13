FROM openjdk:8
ADD target/encurtador.jar encurtador.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "encurtador.jar"]
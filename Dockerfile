FROM openjdk:17-alpine
EXPOSE 8080
COPY target/StudentApp-0.0.1-SNAPSHOT.jar studentapp
ENTRYPOINT ["java", "-jar","studentapp"]
FROM openjdk:8-jre-alpine
ARG VERSION=Github
VOLUME /tmp

EXPOSE 8761
ADD target/discovery-service-${VERSION}-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
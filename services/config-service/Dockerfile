FROM openjdk:8-jre-alpine
ARG VERSION=Github
VOLUME /tmp

EXPOSE 8888
ADD target/config-service-${VERSION}-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
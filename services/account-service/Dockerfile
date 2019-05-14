FROM openjdk:8-jre-alpine
ARG VERSION=0.0.1
VOLUME /tmp

ADD target/account-service-${VERSION}-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
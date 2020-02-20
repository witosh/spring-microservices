FROM java:8
ARG VERSION=Github
VOLUME /tmp

EXPOSE 8093
ADD target/auth-service-${VERSION}-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
FROM java:8
ARG VERSION=Github
VOLUME /tmp

EXPOSE 8000
ADD target/account-service-${VERSION}-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
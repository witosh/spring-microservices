# Microservices project Config, Eureka, Zuul, OAuth2

## Spring Cloud architecture

| No.        | Topics           | 
| ------------- |:-------------|
| 1. | [*Spring Cloud Config*](#sprin-cloud-config)|
| 2. | [*Spring Eureka*](#spring-eureka)|

## Building project cases

| No.        | Topics           | 
| ------------- |:-------------|
| 1. | [*Using Docker from Maven*](#using-docker-from-maven)|


### Spring Cloud Config

To create a Spring Cloud Config Server we need to:
- add the required dependencies
- tell spring where to look for our configuration files
- add @EnableConfigServer annotation


Add needed depenedcy:
```
<dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-config-server</artifactId>
</dependency>
```

Add annotation:
```java
@EnableConfigServer
@SpringBootApplication
public class ConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigApplication.class, args);
	}
}
```

In Spring Cloud Config, we can use file system to put our configuration files. To use a file system backend, we need to:
```yml
spring:
  cloud:
    config:
      server:
        native:
            search-locations: classpath:/config 
```

Setup more conventional port 8888 in various ways:
```yml
server:
   port: 8888
```

[Spring Cloud Config with File System Backend](https://medium.com/@danismaz.furkan/spring-cloud-config-with-file-system-backend-c18ae16b7ad5)

**[⬆ Back to Top](#spring-cloud-architecture)**

### Spring Eureka Service Registry

To create a Spring Cloud - Eureka Service Registry we need to:
- add the required dependencies
- tell spring where to look for our configuration files
- add @EnableEurekaServer annotation

Add necessary annotation:
```java
@SpringBootApplication
@EnableEurekaServer
public class DiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryApplication.class, args);
	}

}
```

Add needed depenedcy:
```
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
	<version>2.1.0.RELEASE</version>
</dependency>
```

#### Bootstrap configuration
Configuration in bootstrap.yml file

Set-up name of application:
```yml
spring:
  application:
    name: discovery-service
```

Initializes Spring Environment with remote property sources:
```yml
spring:
	cloud:
		config:
			uri=http://config-server:8888
```

To desirable to fail startup of a service if it cannot connect to the Config Server, set:
```yml
spring:
	cloud:
		config:
			failFast=true
```
Config server may occasionally be unavailable when your app starts, you can ask it to keep trying after a failure. By adding 
```yml
spring:
	cloud:
		config:
			retry.*
```
and above *failFast* configuration.


[Spring boot microservices with Eureka server](https://medium.com/@kapilanishantha/spring-boot-microservices-with-eureka-server-5e3585a97f2)

**[⬆ Back to Top](#spring-cloud-architecture)**

### Using Docker from Maven

The Docker plugin from Spotify. It actually supports only two operations: 
- building a Docker image,
- pushing a Docker image to the Registry.

The plugin is not calling Docker directly but instead acts as a wrapper around Docker-client also developed by Spotify.

**This means that the plugin can only use Docker features that are offered by the docker-client library and if at any point this library breaks because an incompatible Docker version appeared, the plugin will also break.**

```xml
<plugin>
		<groupId>com.spotify</groupId>
		<artifactId>dockerfile-maven-plugin</artifactId>
		<version>1.3.7</version>
		<executions>
			<execution>
				<id>default</id>
					<goals>
						<goal>build</goal>
						<goal>push</goal>
					</goals>
			</execution>
		</executions>
		<configuration>
		<repository>${docker.registry}/${project.artifactId}</repository>
			<tag>${project.version}</tag>
			<skip>false</skip>
		</configuration>
</plugin>
```

[Using Docker from Maven and Maven from Docker](https://codefresh.io/howtos/using-docker-maven-maven-docker/)

**[⬆ Back to Top](#building-project-cases)**

<!-- In this project, I will try to prepare all the infrastructure for microservices and write a couple of my services. -->
<!-- ## Microservices architecture:
* **config-service** - centralized point of configurations for services. Let's say that we have 20 or 50 services in your project. It's reasonable to place all configurations in one place. So, when new **service** is running it's communicating with **config-service** to get proper configuration. 
To be able to create configuration server you need:
   - [x] * *@EnableConfigServer* * annotation, 
   - [x] * *spring-cloud-config-server* * dependency. 
 By default server will be run localy on port 8080. To change this behaviour 
* **discovery-service** -  -->
<!--
https://www.baeldung.com/spring-security-oauth-dynamic-client-registration
https://medium.com/@darutk/diagrams-and-movies-of-all-the-oauth-2-0-flows-194f3c3ade85
-->
<!--
http://blog.marcosbarbero.com/centralized-authorization-jwt-spring-boot2/
https://projects.spring.io/spring-security-oauth/docs/oauth2.html
https://spring.io/blog/2013/07/03/spring-security-java-config-preview-web-security
https://www.oauth.com/
https://github.com/marcosbarbero/spring-boot2-oauth2-jwt/tree/master/oauth2-jwt-server/src/main/java/com/marcosbarbero/lab/sec/oauth/jwt/config/security
-->

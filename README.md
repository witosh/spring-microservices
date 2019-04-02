# Microservices project

In this project, I will try to prepare all the infrastructure for microservices and write a couple of my services. 

## Microservices architecture:
* **config-service** - centralized point of configurations for services. Let's say that we have 20 or 50 services in your project. It's reasonable to place all configurations in one place. So, when new **service** is running it's communicating with **config-service** to get proper configuration. 
To be able to create configuration server you need:
   - [x] * *@EnableConfigServer* * annotation, 
   - [x] * *spring-cloud-config-server* * dependency. 
 By default server will be run localy on port 8080. To change this behaviour 
* **discovery-service** - 


## Docker command - cheat sheet
* docker ps - check running container
* docker image ls, docker container ls --all or docker images - show docker images


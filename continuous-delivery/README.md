# Continuous Delivery with Docker and Jenkins.

## Table of Contents

| No.        | Topics           | 
| ------------- |:-------------|
| 1. | [*Jenkins Scalability type*](#jenkins-scalability)|
| 2. | [*Running Jenkins on Docker*](#running-jenkins-on-docker)|
| 3. | [*Log inside running Jenkins container*](#log-inside-running-jenkins-container)|
| 4. | [*Needed Jenkins plugins*](#needed-jenkins-plugins)|
| . | [*Whats the difference between a proxy server and a reverse proxy server*](#whats-the-difference-between-a-proxy-server-and-a-reverse-proxy-server)|


### Jenkins Scalability

##### Horizontal scaling

Use Jenkins slaves to balance the load and scale up the Jenkins infrastructure. Such a
process is called the horizontal scaling

##### Horizontal scaling

The other possibility would be to use only one
master node and increase resources of its machine. That process is called the vertical
scaling.

**[⬆ Back to Top](#table-of-contents)**

### Running Jenkins on Docker

```
docker run -d -p 8080:8080 -v $HOME/jenkins_home:/var/jenkins_home --name jenkins jenkins/jenkins:lts
```
> run - run docker container
> -d - run container in the background
> --name - give container name
> -p - map a container's port with the host
> -v - ption will create a data volume named jenkins-home-prod and will map it to the /var/jenkins_home directory inside the container
> jenkins/jenkins:lts - the Docker image and its version used to create a container. jenkins/jenkins is the Jenkins Docker image, and lts is a particular version of that image

**[⬆ Back to Top](#table-of-contents)**

### Jenkins container command

Logging inside the running Jenkins container, using the same docker exec
command:

```bash
sudo docker exec -it jenkins bash
```
> exec  -  run a command in a running container 
> -it - *t* flag create pseudo terminal (pseudo-TTY) to exec command, *i* flag keep STDIN open even if not attached 

Get the data inside the Jenkins container
```bash
sudo docker exec -it jenkins_dev cat /var/jenkins_home/secrets/initialAdminPassword
```
See the content of the /var/jenkins_home directory inside the jenkins_home Jenkins container:
```bash
sudo docker exec -it jenkins ls -lrt /var/jenkins_home
```

Check which container is applied to specific volume
```bash
docker ps -a --filter volume=jenkins-home-prod
```

Check active Jenkins container:
```bash
sudo docker ps --format "{{.ID}}: {{.Image}} {{.Names}}"
```

To create an empty jenkins-home-staging data volume
```bash
docker volume create --name jenkins-home-staging
```

Copying data between data volumes:
```bash
sudo docker run --rm -it --user root -v jenkins-home-prod:/var/jenkins_home -v jenkins-home-staging:/var/jenkins_home_staging jenkins/jenkins:lts bash -c "cd /var/jenkins_home_staging && cp -a /var/jenkins_home/* ."
```
> run --rm jenkins/jenkins:lts - create an interactive container using the Docker image for Jenkins jenkins/jenkins:lts (the container is temporary).
> --user root  all actions performed on this temporary container
> -v jenkins-home-prod:/var/jenkins_home  it will mount the content of the jenkins-home-prod data volume onto the /var/jenkins_home directory present inside the container.
> -v jenkins-home-staging:/var/jenkins_home_staging  it will mount the non-existing content of the jenkins-home-staging data volume onto the non-existing /var/jenkins_home_staging directory inside the container
> bash -c cd /var/jenkins_home_staging && cp -a /var/jenkins_home/* . , copy the content of /var/jenkins_home to /var/jenkins_home_staging

**[⬆ Back to Top](#table-of-contents)**

### Needed Jenkins plugins

Plugins:
- Pipeline Maven Integration
- GitHub 
- Credentials

**[⬆ Back to Top](#table-of-contents)**

### Whats the difference between a proxy server and a reverse proxy server

[Whats the difference between a proxy server and a reverse proxy server](https://stackoverflow.com/a/366212)

**[⬆ Back to Top](#table-of-contents)**

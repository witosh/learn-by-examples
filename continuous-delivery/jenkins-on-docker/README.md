# How to run Jenkins on docker?

According to *Learning Continuous Integration with Jenkins* by *Nikhil Pathania*: "The true advantage of having Jenkins on Docker is when you have to quickly create multiple developments and staging instances of your production Jenkins server."

We will try to install [Long Term Support (LTS)](https://www.jenkins.io/download/lts/), but first of all, it's need to setup docker host. If we have docker installed on the server or local computer we will be able to run the command to automatically pull the Jenkins LTS image from the host and run it on server. 

```bash
docker run -d -v jenkins_home:/var/jenkins_home -p 8080:8080 -p 50000:50000 --name jenkins jenkins/jenkins:lts
```
Docker properties
*docker run -d* - run container in the background
*-v* - docker flag create a new volume and mount it to the container /var/jenkins_home internal directory
*-p* - map a container's port with the host
*--name* - setup container name
*jenkins/jenkins:lts* - the Docker image and its version used to create a container. jenkins/jenkins is the Jenkins Docker image, and it's a particular version of that image

The result of these command should be:
```
Unable to find image 'jenkins/jenkins:lts' locally
lts: Pulling from jenkins/jenkins
...
```

Right now Jenkins should be launched, and you should see the configuration page:

There is many ways for get *initialAdminPassword* for Jenkins container e.g:
```bash
docker container exec -it <container_id> cat /var/jenkins_home/secrets/initialAdminPassword
``` 

After that, you should move through standard configuration steps which lead to starting page. 

At the end lest play with our container:

Check created volume by listing all volumes:
```bash
docker volume ls
```
Excpeced result show be smoething like that:

|DRIVER  |  VOLUME NAME|
| ------------- |:-------------|
|local   |  1beaefe237e73a2033c44e0ebdc4a6680d207fd8ebc6ed12a2dc6391573b76e7|
|local   |  3ee370779bf4b2220242c04be9b6153cee0a37f46f7d6b5c8012c09ea69d35f7|
|local   |  dc1836eb77e1ab547558e28fa16202c283b11e60a0d6eb19a44559b171b8e079|
|local   |  jenkins_home|

but if you have a lot of volumes we want to list only one, created and named by us.
```bash
docker volume ls -f name=jenkins_home

```
With this knowledge let's check which container is bound to *jenkins_prod* volume:
```bash
docker ps -a --filter volume=jenkins_home --format "{{.Names}}"
```
we should see value:
| Names |
| -----|
|jenkins|

Ok, so add ID to formatting:
```bash
docker ps -a --filter volume=jenkins_home --format "{{.ID}} - {{.Names}}"
```
|ID  - NAMES|
| -------------|
|20dec1c89d02 - jenkins|

Based on that container id we can stop/tart jenkins container by:
```bash
docker container stop 20dec1c89d02
```

Backup data from the volume:
Then we try to remove our volume but before that, we backup existed volume to the local catalog. Create a file by: ```mkdir jenkins_home``` to backup data from a container to a local directory. 

For copying the files from the host to the docker container :
- set the path in your localhost to where the file is stored.
- set the path in your docker container to where you want to store the file inside your docker container.
- copy the file which you want to store in your docker container with the help of CP command. 
```bash
sudo docker cp /home/(name)/(folder_name)/(file_name)  (container_id):/(to_the_place_you_want_the_file_to_be)
```

and in reality:
```bash
docker cp -a /home/root/continuous_delivery/jenkins_home/ 20dec1c89d02:/var/jenkins_home
```

Jenkins configuration: all users and jobs are right now locally backups. More about backup volumes on [Stackoverflow](https://stackoverflow.com/questions/50580536/backup-docker-volumes-is-simple-tar-archiving-not-sufficient)

### Other  Jenkins container command

Logging inside the running Jenkins container, using the same docker exec
command:

```bash
sudo docker exec -it jenkins bash
```
- *exec*  -  run a command in a running container 
- *-it* - *t* flag create pseudo terminal (pseudo-TTY) to exec command, *i* flag keep STDIN open even if not attached 

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
- *run --rm jenkins/jenkins:lts* - create an interactive container using the Docker image for Jenkins jenkins/jenkins:lts (the container is temporary).
- *--user root* - all actions performed on this temporary container
- *-v jenkins-home-prod:/var/jenkins_home* -  it will mount the content of the jenkins-home-prod data volume onto the /var/jenkins_home directory present inside the container.
- *-v jenkins-home-staging:/var/jenkins_home_staging* - it will mount the non-existing content of the jenkins-home-staging data volume onto the non-existing /var/jenkins_home_staging directory inside the container
- *bash -c cd /var/jenkins_home_staging && cp -a /var/jenkins_home/* .* - copy the content of /var/jenkins_home to /var/jenkins_home_staging

**[⬆ Back to Table of Contents](https://github.com/witosh/learn-by-examples/blob/master/continuous-delivery/README.md)

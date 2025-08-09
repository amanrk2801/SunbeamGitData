# Jenkins

## installation

```bash

# install pre-requisite
> sudo apt-get install openjdk-17-jre

# visit the url: https://www.jenkins.io/

# download the key to connect to the jenkins apt repository
> sudo wget -O /etc/apt/keyrings/jenkins-keyring.asc \
  https://pkg.jenkins.io/debian-stable/jenkins.io-2023.key

# add the apt repository source for jenkins
> echo "deb [signed-by=/etc/apt/keyrings/jenkins-keyring.asc]" \
  https://pkg.jenkins.io/debian-stable binary/ | sudo tee \
  /etc/apt/sources.list.d/jenkins.list > /dev/null

# update the apt source
> sudo apt-get update

# install the jenkins
> sudo apt-get install jenkins

# check the status of jenkins
> sudo systemctl status jenkins

# start the jenkins service
> sudo systemctl start jenkins

# enable the jenkins to start automatically
> sudo systemctl enable jenkins

# visit the url: http://localhost:8080

```

## create a docker hub token

```bash

# visit the url: https://app.docker.com/settings/personal-access-tokens
# create a personal token with
# - permissions: Read, Write, Delete
# - expiration: None

# now you can login with the token
> echo <token> | docker login -u <user name> --password-stdin

```

## setup jenkins for docker

```bash

# add the jenkins user to docker group
> sudo usermod -aG docker jenkins

# reboot the machine
> sudo reboot

```

## configure the job

```bash

# remove the service
> docker service rm website

# sleep
> sleep 10

# remove the image
> docker image rm amitksunbeam/website

# build the image
> docker image build -t amitksunbeam/website .

# docker login
> echo <token> | docker login -u amitksunbeam --password-stdin

# push the image to docker hub
> docker image push amitksunbeam/website

# start the service
> docker service create --name website -p 9090:80 --replicas 2 amitksunbeam/website

```

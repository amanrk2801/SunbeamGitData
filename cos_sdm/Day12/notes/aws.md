# AWS

## EC2

- create an EC2 instance
  - region: Mumbai (ap-south-1)
  - name: web-server
  - AMI: Ubuntu Server 24.04
  - instance type: t2.micro
  - key: kdac-may21
  - disk: 10GB

```bash

# change the permissions of pem file
> chmod 400 ~/Downloads/kdac-may21.pem

# connect to the ec2 instance
# > ssh -i <pem file path> ubuntu@<public ip address of ec2 instance>
> ssh -i ~/Downloads/kdac-may21.pem ubuntu@43.204.218.134

```

## EC2 instance configuration

### mysql

```bash

# update apt cache
> sudo apt-get update

# install mysql server
> sudo apt-get install mysql-server

# start mysql using root permissions
> sudo mysql
mysql> ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'root';
mysql> FLUSH PRIVILEGES;

```

### backend

```bash


# download the nvm
curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.40.3/install.sh | bash

# in lieu of restarting the shell
\. "$HOME/.nvm/nvm.sh"

# Download and install Node.js:
nvm install 22

# Verify the Node.js version:
node -v
nvm current

# Verify npm version:
npm -v 9.2".

```

- copy the server directory from local machine to ec2 instance
  - note: please execute these commands on your local machine

```bash

# go the parent directory of server
# > cd <parent>

# archive the server directory
> tar -cvf server.tar server

# upload the server.tar to the server
> scp -i ~/Downloads/kdac-may21.pem server.tar ubuntu@<ip address>:~/

```

- configure the server on ec2 instance
  - note: please execute these commands on ec2 instance

```bash

# go the home directory
> cd ~/

# unarchive the server.tar file
> tar -xvf server.tar

# go to the server directory and download all packages
> cd server
> npm install

# install pm2 (process manager) to run express application forever
> npm install -g pm2

# start the server in background
> cd ~/server/
> pm2 start --name server server.js

# get the list of servers running
> pm2 list

```

- configure the ec2 instance to open a required port

```bash

# go to the management console
# from instances list, select the required instance
# go to the security tab
# open security group
# click "Edit Inbound rules"
# add a new rule
# - type: custom TCP
# - port range: 4000
# - source: Anywhere IPv4
# - filter: 0.0.0.0
# add a new rule
# - type: custom TCP
# - port range: 80
# - source: Anywhere IPv4
# - filter: 0.0.0.0

```

## configure react / frontend

### build the project

- note: please execute these commands on your machine

```bash

# build the react project
# note: this command creates a dist directory with website files
> yarn build

# archive the website
> cd dist
> tar -cvf website.tar *

# upload the website.tar file to the server
> scp -i ~/Downloads/kdac-may21.pem website.tar ubuntu@<ip>:~/

```

### install a webserver (apache2)

```bash

# update the apt cache
> sudo apt-get update

# install apache2
> sudo apt-get install apache2

# go the htdocs directory of apache
> cd /var/www/html

# move the website from home to htdocs
> sudo mv ~/website.tar .

# unarchive the website.tar file
> sudo tar -xvf website.tar

```

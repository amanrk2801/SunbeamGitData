# docker swarm

- execute a command every after 1 second
  > watch -n 1 <command>
  > watch -n 1 docker container ls

## swarm

```bash

# check if the mode is running in swarm mode
# run the following command and check status of Swarm (active or inactive)
> docker system info

# check if the mode is running in swarm mode
> docker system info | grep Swarm

# initialize the swarm (cluster)
> docker swarm init

# stop the cluster
# note: run this command on the leader manager
> docker swarm leave --force

# generate a token for worker
> docker swarm join-token worker

# generate a token for manager
> docker swarm join-token manager


```

## nodes

```bash

# get the list of nodes
> docker node ls

# get details of selected node
> docker node inspect <node id>

# remove a selected node
> docker node rm <node id>

# promote a worker
> docker node promote <worker id>

# demote a manager
> docker node demote <manager id>

```

## service

```bash

# get the list of services
> docker service ls

# create a service
# params:
# - --name: service name
# - -p: used to publish the port
# - --replicas: used to specify the desired count
# > docker service create --name <service name> -p <source port>:<container port> --replicas <desired count> <image name>
> docker service create --name httpd -p 9090:80 --replicas 5 httpd

# get the service details
# > docker service inspect <service name>
> docker service inspect httpd

# get the containers created by selected service
# > docker service ps <service name>
> docker service ps httpd

# remove the service
# > docker service rm <service name>
> docker service rm httpd

# scale the service
# note: increase or decrease number of containers
# > docker service scale <service name>=<new desired count>
> docker service scale httpd=5

```

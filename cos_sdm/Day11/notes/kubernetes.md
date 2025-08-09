# Kubernetes

## minikube

- installation
  - minikube creates a virtual machine with linux running in it
  - this cluster running in this virtual machine is simulated (not real)

```bash

# download the minikube
> curl -LO https://github.com/kubernetes/minikube/releases/latest/download/minikube-linux-amd64
> sudo install minikube-linux-amd64 /usr/local/bin/minikube && rm minikube-linux-amd64

# add the following command in ~/.bashrc
> vim ~/.bashrc
> alias kubectl="minikube kubectl --"
> source ~/.bashrc

```

- manage minikube

```bash

# start the cluster
> minikube start

# check the cluster status
> minikube status

# stop the cluster
# note: this command will NOT remove the cluster
> minikube stop

# delete the cluster
# note:
# - this command will delete everything (virtual machine) from the machine
# - once deleted, the cluster needs to be reinstalled (using minikube start)
> minikube delete

# take the control (shell) of virtual machine created by minikube
> minikube ssh

# get the cluster information
> minikube kubectl -- custer-info
> kubectl cluster-info

# expose a service outside the cluster
> minikube service <service name>

```

## generic commands

```bash

# get a list of objects
> kubectl get <object>

# get details of selected object
> kubectl describe <object> <object name>

# delete an object
> kubectl delete <object> <object name>

```

## node (machine)

```bash

# get the list of nodes
> kubectl get nodes
> kubectl get node

# get all the information about a selected node
> kubectl describe node <node name>

```

## namespace

```bash

# get the list of namespaces
> kubectl get namespaces
> kubectl get namespace
> kubectl get ns

# create a namespace
# > kubectl create namespace <namespace name>
> kubectl create namespace myns

# delete a namespace
# note: all the ns members will also get deleted while deleting the ns
# > kubectl delete namespace <ns name>
> kubectl delete namespace myns

```

## pod

```bash

# get the list of pods in default namespace
> kubectl get pods
> kubectl get pod

# get the details list of pods
> kubectl get pods -o wide

# create a pod using yaml configuration file
> kubectl create -f <yaml file>
> kubectl apply -f <yaml file>

# get details of selected pod
# > kubectl describe pod <pod name>
> kubectl describe pod pod1

# delete selected pod
# > kubectl delete pod <pod name>
> kubectl delete pod pod1

```

## service

```bash

# get the list of services
> kubectl get service
> kubectl get svc

# create a service using yaml configuration file
> kubectl create -f <yaml file>
> kubectl apply -f <yaml file>

# get the details of selected service
# > kubectl describe service <service name>
> kubectl describe service myservice

```

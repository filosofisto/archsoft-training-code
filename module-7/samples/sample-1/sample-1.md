# Sample 1

## Docker Hub Login

    sudo docker login

## Create Access Token (optional)

    https://hub.docker.com/settings/security

## Build Image

    sudo docker build -t filosofisto/angular06-inventory:1.0.0 .

## Push Image do Docker Hub

    sudo docker push filosofisto/angular06-inventory:1.0.0

## K8s Deploy Deployment

    microk8s kubectl apply -f deploy.yml

## K8s Deploy Service

    microk8s kubectl apply -f svc.yml
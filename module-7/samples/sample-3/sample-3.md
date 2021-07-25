# Spring-5

## Build Container Image

    sudo docker build -t filosofisto/spring-5:1.0.0 .

## Push Image do Docker Hub

    sudo docker push filosofisto/spring-5:1.0.0

## K8s Deploy Deployment

    microk8s kubectl apply -f deploy.yml

## K8s Deploy Service

    microk8s kubectl apply -f svc.yml
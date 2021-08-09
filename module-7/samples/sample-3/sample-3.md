# Spring-5

## Build Container Image

    sudo docker build -t filosofisto/spring-5:1.0.0 .

## Push Image do Docker Hub

    sudo docker push filosofisto/spring-5:1.0.0

## Create Secret

    microk8s kubectl create secret generic database-credential --from-literal=dbuser=postgresadmin --from-literal=dbpassword=admin123

## K8s Deploy Deployment and Service

    microk8s kubectl apply -f deploy.yml

## Delete

    microk8s kubectl delete service spring-5-service

    microk8s kubectl delete deploy spring-5-deploy
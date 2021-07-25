# Back: Spring-10 + Front: Angular31

## Build Container Image

    sudo docker build -t filosofisto/spring-10:1.0.0 .

    sudo docker build -t filosofisto/angular31-spring10:1.0.0 .

## Push Images do Docker Hub

    sudo docker push filosofisto/spring-10:1.0.0

    sudo docker push filosofisto/angular31-spring10:1.0.0

## K8s Deploy Deployment and Service

    microk8s kubectl apply -f deploy.yml

## Delete

    microk8s kubectl delete service spring-10-service

    microk8s kubectl delete service angular31-spring10-service

    microk8s kubectl delete deploy spring-10-deploy

    microk8s kubectl delete deploy angular31-spring10-deploy
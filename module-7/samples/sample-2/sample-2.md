# Postgresql

## Config Map for Postgresql Configuration

    microk8s kubectl create -f postgres-configmap.yml

## Persistence Volume

    microk8s kubectl create -f postgres-storage.yml

## Deployment

    microk8s kubectl create -f postgres-deploy.yml 

## Service

    microk8s kubectl create -f postgres-service.yml 

## Delete

    microk8s kubectl delete service postgres-service

    microk8s kubectl delete deployment postgres-deployment

    microk8s kubectl delete configmap postgres-config

    microk8s kubectl delete persistentvolumeclaim postgres-pv-claim

    microk8s kubectl delete persistentvolume postgres-pv-volume
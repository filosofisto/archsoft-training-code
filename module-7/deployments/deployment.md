# Deployment

## Deploy

    microk8s kubectl apply -f deploy.yml

 ## Inspecting Deployments

    microk8s kubectl get deploy hello-deploy   
    microk8s kubectl describe deploy hello-deploy 

## ReplicaSets

    microk8s kubectl get rs
    microk8s kubectl describe rs

## Deploy Service

    microk8s kubectl apply -f svc.yml

## Accessing App

    http://localhost:30001/

## Rolling Update

Change the line

    image: nigelpoulton/k8sbook:latest

for this one

    image: nigelpoulton/k8sbook:edge

Update

    microk8s kubectl apply -f deploy.yml --record

Monitor rollout

    microk8s kubectl rollout status deployment hello-deploy

Verify

    microk8s kubectl get deploy hello-deploy
    microk8s kubectl describe deploy hello-deploy

## Rollback Update

--record flag mantain a documented revision history of the deployment

    microk8s kubectl rollout history deployment hello-deploy
    microk8s kubectl get rs
    microk8s kubectl describe rs

## Rollback Operation

    microk8s kubectl rollout undo deployment hello-deploy --to-revision=2

## Clean up the lab

    microk8s kubectl delete -f deploy.yml
    microk8s kubectl delete -f svc.yml

## Scale Replicas

    microk8s kubectl scale --replicas=<number of replicas> deployment/<deploy name>

Ex: Stop all pods from a deploy

    microk8s kubectl scale --replicas=0 deployment/spring-5-deploy
# Pods

## Deploy a Pod

    microk8s kubectl apply -f pod.yml

## Get Pods

    microk8s kubectl get pods
    microk8s kubectl get pods --watch | Monitoring the status of creation

    mkctl get pods -o wide | More information
    mkctl get pods -o yaml | Details in yaml format

## Describe Pod

    microk8s kubectl describe pods hello-pod

## Running commands in Pod

    microk8s kubectl exec hello-pod -- ps aux

## Login Pod and execute commands

    microk8s kubectl exec -it hello-pod -- sh
    apk add curl
    curl localhost:8080

## Logs

    microk8s kubectl logs hello-pod

## Delete Pod

    microk8s kubectl delete -f pod.yml
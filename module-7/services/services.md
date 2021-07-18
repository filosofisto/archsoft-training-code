# Services

## Service Type

- ClusterIP (default): Gives the Service a stable IP address internally within the cluster. It will not makes the Service available outside of the cluster on a stable port.

- NodePort: Extends ClusterIP and add TCP or UDP port. It makes the Service available outside of the cluster on a stable port.

- LoadBalance: This builds on top of NodePort and integrates with cloud-based load-balancers.

- ExternalName: Used to direct traffic to services that exist outside of the Kubernetes cluster.

## Post Service to API Server

    microk8s kubectl apply -f svc.yml

## Introspecting Service

    microk8s kubectl get svc hello-svc
    microk8s kubectl describe svc hello-svc

## Endpoints

Every Service has its own Endpoint object with the same name as the Service.
It holds a list of all the Pods the Service matches and is dynamically updated as matching Pods come and go.

## Get Endpoint

    microk8s kubectl get ep hello-svc
    microk8s kubectl describe ep hello-svc
# Spring-5

## Build Container Image

    sudo docker build -t filosofisto/spring-5:1.0.0 .

## Push Image do Docker Hub

    sudo docker push filosofisto/spring-5:1.0.0

## Create Secret

### Manually Creation

    microk8s kubectl create secret generic database-credential --from-literal=dbuser=postgresadmin --from-literal=dbpassword=admin123

### Config Creation

    echo -n postgresadmin | base64

    echo -n admin123 | base64

    apiVersion: v1
    kind: Secret
    metadata:
      name: database-credential
    type: Opaque
    data:
      dbuser: cG9zdGdyZXNhZG1pbg==
      dbpassword: YWRtaW4xMjM=

### TLS public/private key pair

    kubectl create secret tls <secret-object-name> --cert=<cert-path> --key=<key-file-path>

### Creation From File

    kubectl create secret generic sample-db-secret --from-file=username.txt --from-file=password.txt

## K8s Deploy Deployment and Service

    microk8s kubectl apply -f deploy.yml

## Delete

    microk8s kubectl delete service spring-5-service

    microk8s kubectl delete deploy spring-5-deploy


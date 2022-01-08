# SpringBoot Demos

Site: spring.io/guides/gs/spring-boot-kubernetes

## Create App | Package | Test

    curl https://start.spring.io/starter.tgz -d dependencies=webflux,actuator | tar -xzvf -
    ./mvnw install
    java -jar target/demo-0.0.1-SNAPSHOT.jar
    sudo snap install jq
    curl localhost:8080/actuator | jq .

## Containerize

If docker.sock belongs to sudo you can change the owner with below command:

    sudo chown eduardo:eduardo /var/run/docker.sock


    ./mvnw spring-boot:build-image
    docker run -p 8080:8080 demo:0.0.1-SNAPSHOT
    curl localhost:8080/actuator/health
    docker login
    docker tag demo:0.0.1-SNAPSHOT filosofisto/springguides-demo
    docker push filosofisto/springguides-demo

## Kubernetes

    microk8s kubectl create deployment demo --image=filosofisto/springguides-demo --dry-run=client -o=yaml > deployment.yaml
    or
    mkctl create deployment demo --image=filosofisto/springguides-demo --dry-run=client -o=yaml > deployment.yaml

    microk8s kubectl create service clusterip demo --tcp=8080:8080 --dry-run=client -o=yaml >> deployment.yaml
    or
    mkctl kubectl create service clusterip demo --tcp=8080:8080 --dry-run=client -o=yaml >> deployment.yaml

    microk8s kubectl apply -f deployment.yaml
    or 
    mkctl apply -f deployment.yaml

    microk8s kubectl port-forward svc/demo 8080:8080
    or
    mkctl port-forward service/demo 8080:8080

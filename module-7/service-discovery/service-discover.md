# Service Discover

    microk8s kubectl get svc -n kube-system -l k8s-app=kube-dns
    microk8s kubectl describe svc -n kube-system -l k8s-app=kube-dns7

    microk8s kubectl get deploy -n kube-system -l k8s-app=kube-dns
    microk8s kubectl describe deploy -n kube-system -l k8s-app=kube-dns

    microk8s kubectl get pods -n kube-system -l k8s-app=kube-dns
    microk8s kubectl describe pods -n kube-system -l k8s-app=kube-dns

 ## Apply sd-example.yml

    microk8s kubectl apply -f sd-example.yml   

    microk8s kubectl get all -n dev
    microk8s kubectl get all -n prod

### Log on to the jump Pod in the dev namespace

    microk8s kubectl exec -it jump -n dev -- bash
    cat /etc/resolv.conf
    microk8s kubectl get service -n kube-system

Verify that the ClusterIP of kube-dns is equal of nameserver on resolv.conf

    apt update && apt install curl -y
    curl ent:8080

When curl is issued:

- Container automatically appended dev.svc.cluster.local to the ent name and sent the query to the IP address of the cluster DNS specified in /etc/resolv.conf 
- DNS returned the ClusterIP for the ent Service running int the local dev Namespace and the app sent the traffic to that address
- ...

    curl ent.prod.svc.cluster.local:8080

## Troubeshoot DNS

Make sure DNS is working

    microk8s kubectl get deploy -n kube-system -l k8s-app=kube-dns
    microk8s kubectl get pods -n kube-system -l k8s-app=kube-dns

Check log od pods

    microk8s kubectl logs coredns-7f9c69c78c-6mrxk -n kube-system

kube-dns Service should match the IP address in the /etc/resolv.conf

    microk8s kubectl get svc kube-dns -n kube-system

The respective Endpoint of kube-dns should be up and have the IP addresses of the coredns Pods listening on port 53 TCP and UDP

    microk8s kubectl get ep -n kube-system -l k8s-app=kube-dns

Use nslookup to check query DNS

    microk8s kubectl run -it dnsutils --image gcr.io/kubernetes-e2e-test-images/dnsutils:1.3
    nslookup kubernetes

Rebuild DNS Pods

    microk8s kubectl delete pods -n kube-system -l k8s-app=kube-dns

Now check if Pods was restarted

    microk8s kubectl get pods -n kube-system -l k8s-app=kube-dns
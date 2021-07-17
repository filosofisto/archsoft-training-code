# Kubernets

## Docker

Remove old versions

    sudo apt-get remove docker docker-engine docker.io containerd runc

Install

    sudo apt-get install apt-transport-https ca-certificates curl gnupg lsb-release
    curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo gpg --dearmor -o /usr/share/keyrings/docker-archive-keyring.gpg
    echo "deb [arch=amd64 signed-by=/usr/share/keyrings/docker-archive-keyring.gpg] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable" | sudo tee /etc/apt/sources.list.d/docker.list > /dev/null
    sudo apt-get update
    sudo apt-get install docker-ce docker-ce-cli containerd.io

Verify Installation

    sudo docker run hello-world

## MicroK8s


### Install

    sudo snap install microk8s --classic

### Add user to microk8s admin group

    sudo usermod -a -G microk8s $USER
    sudo chown -f -R $USER ~/.kube
    su - $USER

### Check status

    microk8s status --wait-ready

### Enable some services

    microk8s enable dashboard dns ingress

### Kubectl

    microk8s kubectl get all --all-namespaces
    
Add alias for microk8s kubectl (optional)

    vim ~/.bashrc
    alias mkctl="microk8s kubectl"
    source ~/.bashrc

### Access the Kubernetes dashboard 

    microk8s dashboard-proxy

    https://127.0.0.1:10443

### Status | Start | Stop Kubernetes

    microk8s start
    microk8s stop
    microk8s status

### View kubectl config

    microk8s kubectl config view
    mkctl config view

See the current context (Context bring together cluster and users under a friendle name)

    microk8s kubectl config current-context
    mkctl config current-context
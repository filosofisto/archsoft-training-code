# Docker 01

## Comandos

- Exibe a versao do docker (Client e Server)

```
docker version
```

- Lista as imagens

```
docker image ls | docker images
```  
  
- Pull images (download de imagens)

```
docker image pull ubuntu:latest
docker image pull redis:latest
docker image pull gcr.io/google-containers/git-sync:v3.1.5
```

Obtem um imagem do DockerHub.
Neste primeiro exemplo carrega a ultima versao do ubuntu
No segundo carrega a ultima versao do redis
No terceiro carrega uma imagem da Google 

- Executando comandos no container

```
docker container run -it ubuntu:latest /bin/bash
docker container run -it mcr.microsoft.com/powershell:lts-nanoserver-1903 pwsh.exe
docker container run --name ctr1 -it alpine:latest sh
```

- Conectando a um container em execucao

```
docker container exec -it <container id> <command ex: bash>
```
  
- Listando containers em execucao

```
docker ps
```

- Parando um container

```
docker stop <container id>
```

- Parando todos os containers

```
docker container stop $(docker container ls –aq)
```

- Removendo um container

```
docker container rm <container id>
```

- Removendo todos os containers

```
docker container stop $(docker container ls –aq) && docker system prune –af ––volumes
```
  
- Pulling de todas as imagens (tags) de uma imagem

```
docker image pull -a nigelpoulton/tu-demo
```

- Removendo todas as imagens

```
docker rmi $(docker images -a -q)
```

- Removendo todos os container parados, networks nao utilizadas e imagens dangling

```
docker system prune
```

- Filtrando Imagens

```
docker image ls --filter dangling=true    
```
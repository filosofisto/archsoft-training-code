# Docker 01

## Comandos

- docker version
  
  Exibe a versao do docker (Client e Server)

- docker image ls | docker images
  
  Lista as imagens

- docker image pull ubuntu:latest
  docker image pull redis:latest
  docker image pull gcr.io/google-containers/git-sync:v3.1.5
  
  Obtem um imagem do DockerHub.
  Neste primeiro exemplo carrega a ultima versao do ubuntu
  No segundo carrega a ultima versao do redis
  No terceiro carrega uma imagem da Google 

- docker container run -it ubuntu:latest /bin/bash
  docker container run -it mcr.microsoft.com/powershell:lts-nanoserver-1903 pwsh.exe [ *** apenas host windows *** ]
  docker container run --name ctr1 -it alpine:latest sh

  Executa um servico do container (download, instala e executa a aplicacao)

- ps -elf

  Dentro do container para verificar os processos em execucao

- docker container exec -it <container id> <command ex: bash>

  Conectar ao termial de um container

- docker ps

  Lista os containers em execucao

- docker container stop <container id>

  Parar um container (por id)

- Multiplas tags

  docker image pull -a nigelpoulton/tu-demo

- Removendo Images

  docker system prune

- Filtrando

  docker image ls --filter dangling=true    

## Criando Aplicacao Angular e usar um NGINX em um Container Docker

- ng new angular-nginx-docker --minimal
- cd angular-nginx-dockerng build --prod
- ng build --prod
- docker run -it -p 80:80 \
    -v /$PWD/dist/angular-nginx-docker://usr/share/nginx/html:ro \
    nginx:alpine

## Customizando configuracao do NGNIX

- docker run -it -p 80:80 \
    -v /$PWD/dist/angular-nginx-docker://usr/share/nginx/html:ro \
    -v /$PWD/.nginx/nginx.conf://etc/nginx/nginx.conf:ro \
    nginx:alpine

## Containerizando com NGINX  

- ng new angular-nginx-dockerized --minimal
- cd angular-nginx-dockerized
- docker build -t angular-nginx-dockerized .
- docker run -d -p 80:80 angular-nginx-docker

## Publicando Imagem no DockerHub

- Criar usuario no DockerHub
- docker login
- docker build -t filosofisto/angular-nginx-dockerized:0.0.1 .
- docker push filosofisto/angular-nginx-dockerized:0.0.1

## Usando Imagem do DockerHub

- docker container run -p 80:80 filosofisto/angular-nginx-dockerized:0.0.1 &


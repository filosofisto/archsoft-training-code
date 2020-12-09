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

- docker ps

  Lista os containers em execucao

- Multiplas tags

  docker image pull -a nigelpoulton/tu-demo

- Removendo Images

  docker system prune

- Filtrando

  docker image ls --filter dangling=true  
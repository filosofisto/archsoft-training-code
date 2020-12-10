# Docker 02

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

## Container Postgres

- docker create -v $PWD/postgresql/data --name PostgresData alpine
- docker run -p 5432:5432 --name postgres -e POSTGRES_PASSWORD=admin -d --volumes-from PostgresData postgres

# Docker 02

## Project CPPBox 

Thanks to Troy Milles - Web Servers and API using C++ (Linkedin Learning)

### Comandos

```
docker build -t cppbox .
docker run -ti cppbox:latest bash
find /usr -name libboost*.*
```
  
Para verificar se a instalacao ocorreu com sucesso.
Se encontrar arquivos com este patterns entao a instalacao foi com sucesso.

```
cd cppweb
docker run -v $PWD:/usr/src/cppweb -ti cppbox:latest bash
```

Cria um volume, que permite adicionar/editar arquivos e compartilha-los entre o host e o container (host <-> container)

### Build

```
docker run -v $PWD:/usr/src/cppweb -ti cppbox:latest bash
cd /usr/src/cppweb/hello_crow/build
cmake ..
make
```

### Execute

```
docker run -v $PWD:/usr/src/cppweb -p 8080:8080 -e PORT=8080 cppbox:latest /usr/src/cppweb/hello_crow/build/hello_crow
```

## Criando Aplicacao Angular e usar um NGINX em um Container Docker

```
ng new angular-nginx-docker --minimal
cd angular-nginx-docker
ng build --prod
docker run -it -p 80:80 -v $PWD/dist/angular-nginx-docker:/usr/share/nginx/html:ro nginx:alpine
```

## Customizando configuracao do NGNIX

```
docker run -it -p 80:80 \
    -v $PWD/dist/angular-nginx-docker://usr/share/nginx/html:ro \
    -v $PWD/.nginx/nginx.conf:/etc/nginx/nginx.conf:ro \
    nginx:alpine
```

## Containerizando com NGINX  

```
ng new angular-nginx-dockerized --minimal
cd angular-nginx-dockerized
docker build -t angular-nginx-dockerized .
docker run -d -p 80:80 angular-nginx-dockerized
```

## Publicando Imagem no DockerHub

- Criar usuario no DockerHub

```
docker login
docker build -t filosofisto/angular-nginx-dockerized:0.0.1 .
docker push filosofisto/angular-nginx-dockerized:0.0.1
```

## Usando Imagem do DockerHub

```
docker container run -d -p 80:80 filosofisto/angular-nginx-dockerized:0.0.1
```



# Project CPPBox 

Thanks to Troy Milles - Web Servers and API using C++ (Linkedin Learning)

## Comandos

- docker build -t cppbox .
  
  Para criar a imagem

- docker run -ti cppbox:latest bash

  Para executar o bash no container

- find /usr -name libboost*.*

  Para verificar se a instalacao ocorreu com sucesso.
  Se encontrar arquivos com este patterns entao a instalacao foi com sucesso.

- docker run -v /home/eduardo/Develop/archsoft-training-code/module-3/docker01/cppweb:/usr/src/cppweb -ti cppbox:latest bash

  Cria um volume, que permite adicionar/editar arquivos e compartilha-los entre o host e o container (host <-> container)

## Build

- docker run -v /home/eduardo/Develop/archsoft-training-code/module-3/docker01/cppweb:/usr/src/cppweb -ti cppbox:latest bash
- cd /usr/src/cppweb/hello_crow/build
- cmake ..
- make

## Execute

- docker run -v /home/eduardo/Develop/archsoft-training-code/module-3/docker01/cppweb:/usr/src/cppweb -p 8080:8080 -e PORT=8080 cppbox:latest /usr/src/cppweb/hello_crow/build/hello_crow


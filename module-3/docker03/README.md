# Docker 03

## Container Postgres

```
docker pull postgres
docker run -d --name dev-postgres -e POSTGRES_PASSWORD=admin -v ${PWS}/postgresql/data/:/var/lib/postgresql/data -p 5432:5432 postgres
cat dump.sql | docker exec -i dev-postgres psql -U postgres
docker exec -it dev-postgres psql -U postgres
```

- Commands psql:
  - \l          => List Databases
  - \c postgres => Switch to postgres database
  - \dt         => Show tables

## Debug Java Application in a Docker Container

- Adicionar o plugin do Docker
- Connectar com o docker (Setting/Preferences -> Build > Execution > Deployment | Docker), adicionando um conector (+ button)
- Executa (play button)

Para debugar a aplicacao executando no container eh necessario criar um outro Launcher do tipo 
Remote JVM Debugger com o Before launch apontando para o Launcher do Docker, com o Configure Docker Custom Command:

```
java -agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=*:5005 -jar debug01-1.0-SNAPSHOT.jar
```

- Launcher Docker
```
<component name="ProjectRunConfigurationManager">
  <configuration default="false" name="Dockerfile" type="docker-deploy" factoryName="dockerfile" server-name="Docker">
    <deployment type="dockerfile">
      <settings>
        <option name="imageTag" value="" />
        <option name="buildCliOptions" value="" />
        <option name="command" value="java -jar debug01-1.0-SNAPSHOT.jar" />
        <option name="containerName" value="debug01" />
        <option name="entrypoint" value="" />
        <option name="commandLineOptions" value="" />
        <option name="sourceFilePath" value="Dockerfile" />
      </settings>
    </deployment>
    <method v="2" />
  </configuration>
</component>
```

- Launcher Remote Debug
```
<component name="ProjectRunConfigurationManager">
  <configuration default="false" name="debug01 remote debug" type="Remote">
    <module name="debug01" />
    <option name="USE_SOCKET_TRANSPORT" value="true" />
    <option name="SERVER_MODE" value="false" />
    <option name="SHMEM_ADDRESS" />
    <option name="HOST" value="localhost" />
    <option name="PORT" value="5005" />
    <option name="AUTO_RESTART" value="false" />
    <RunnerSettings RunnerId="Debug">
      <option name="DEBUG_PORT" value="5005" />
      <option name="LOCAL" value="false" />
    </RunnerSettings>
    <method v="2">
      <option name="com.intellij.docker.debug.DockerBeforeRunTask" command="java -agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=*:5005 -jar debug01-1.0-SNAPSHOT.jar" run-config="Dockerfile" />
    </method>
  </configuration>
</component>
```
  

# Docker04

## Java/SpringBoot + Angular/NGINX + Postgres

- Construir o container do Frontend

```
cd angular31-spring10
docker build -t angular31-spring10 .
```

- Executar Frontend

```
docker run -p 80:80 angular31-spring10
firefox http://localhost
```

- Construir o container do Backend

```
cd spring-10
docker build -t spring-10 .
```

- Executar o Backend

```
docker run --rm -it spring-10
```


# Docker 03

## Container Postgres

```
docker pull postgres
docker run -d --name dev-postgres -e POSTGRES_PASSWORD=admin -v ${PWS}/postgresql/data/:/var/lib/postgresql/data -p 5432:5432 postgres
cat dump.sql | docker exec -i dev-postgres psql -U postgres
docker exec -it dev-postgres psql -U postgres
```

- Commands psql:
  \l          => List Databases
  \c postgres => Switch to postgres database
  \dt         => Show tables


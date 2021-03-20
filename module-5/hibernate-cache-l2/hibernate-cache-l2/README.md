# Hibernate Cache L2

## Objetivo
- Cache de segundo nivel para JPA

## Postgresql

## Container Postgres

```
docker pull postgres
docker run -d --name dev-postgres -e POSTGRES_PASSWORD=socrates -v $PWS/postgresql/data:/var/lib/postgresql/data -p 5432:5432 postgres
cat dump.sql | docker exec -i dev-postgres psql -U postgres
docker exec -it dev-postgres psql -U postgres
```
   
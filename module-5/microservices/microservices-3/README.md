# Microservice 3

## Objetivo

- CQRS - Command and Query Responsability Segregation

## Comandos

### Lista de Topicos

    ./kafka-topics.sh --list --zookeeper localhost:2181

### Criar Topico de Produtos

    ./kafka-topics.sh --zookeeper localhost:2181 --create --topic product --partitions 3 --replication-factor 1

### Criar Topico AddProductToOrder

    ./kafka-topics.sh --zookeeper localhost:2181 --create --topic addProductToOrder --partitions 3 --replication-factor 1

### Consumir Mensagens

    ./kafka-console-consumer.sh --bootstrap-server 127.0.0.1:9092 --topic product --group test

### Exercicio

- Integrar Order e Customer atraves do message broker
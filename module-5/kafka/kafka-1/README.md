# Projeto Kafka-1

##Objetivo
- KafkaProducer

##Instruções

###Consume Messages

    su -l kafka
    cd kafka/bin/

    ./kafka-console-consumer.sh --bootstrap-server 127.0.0.1:9092 --topic first_topic --group my-first-application

###List Topics

    ./kafka-topics.sh --list --zookeeper localhost:2181

###Remove a topic

    ./kafka-topics.sh --zookeeper localhost:2181 --delete --topic first_topic

###Create a topic

    ./kafka-topics.sh --zookeeper localhost:2181 --create --topic first_topic --partitions 3 --replication-factor 1
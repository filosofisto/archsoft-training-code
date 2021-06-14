#!/bin/sh
java -jar service-registry/target/service-registry-0.0.1-SNAPSHOT.jar &
java -jar gateway/target/gateway-0.0.1-SNAPSHOT.jar &
java -jar authentication/target/authentication-0.0.1-SNAPSHOT.jar &
java -jar product/target/product-0.0.1-SNAPSHOT.jar &


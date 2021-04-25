#Project spring-mongodb-1

##Commands

[comment]: <> (###Start docker-compose)

[comment]: <> (    docker-compose up)

###Run MongoDB as Container 
Se o container nao existe execute o docker run, caso contrario execute o docker start:

    docker run --name mongodb -v ${PWD}/mongodb_data_container:/data/db -p 27017:27017 -e MONGO_INITDB_ROOT_USERNAME=root --privileged=true -e MONGO_INITDB_ROOT_PASSWORD=root -d mongo --auth
    docker start mongodb
[comment]: <> (    docker run -d -p 27017-27019:27017-27019 --name mongodb mongo)

###Iterate with mongodb
    docker exec -it mongodb bash
    mongo

###Show MongoDB databases
    show dbs

###Create a database
    use appdb

###Create a user for database
    db.createUser({user: "appuser", pwd: "12345678", roles: [{role: "readWrite", db: "appdb"}]})

###Connect via console with appuser
    mongo -u appuser -p 12345678 --authenticationDatabase admin

###Create Collection | Add a Product
    > use appdb
    switched to db appdb
    > db.createCollection('product')
    { "ok" : 1 }
    > db.product.insert({name: "Apple", description: "Great product", price: 27000.25})
    WriteResult({ "nInserted" : 1 })
    > db.product.find().pretty()
    {
    "_id" : ObjectId("60854d4dc1d8088e6bdc3483"),
    "name" : "Apple",
    "description" : "Great product",
    "price" : 27000.25
    }

## Exercise

Implement CRUD operations for Customer
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

##For play with MongoDB
Import recipes

    mongoimport --file recipes.json

    show dbs
    use recipes
    db.getName()

Find samples

    db.recipes.find()
    db.recipes.find().pretty()
    db.recipes.find().count()
    db.recipes.find({ "title": "Tacos" })
    db.recipes.find({ "title": "Tacos", "cook_time": 20 })
    db.recipes.find({ "title": "Tacos" }, { "title": 1 })
    db.recipes.find({ "title": "Tacos" }, { "title": 0 })
    db.recipes.find({}, { "title": 1 })
    db.recipes.find({ "title": { $regex: /taco/i }}, { "title": 1 })
    db.recipes.insertOne({ "title": "New recipe" })
    db.recipes.find({}, { "title": 1 }).sort({ "title": 1 })
    db.recipes.find({}, { "title": 1 }).sort({ "title": -1 })
    db.recipes.find({}, { "title": 1 }).sort({ "title": 1 }).limit(3)
    db.recipes.find({}, { "title": 1 }).sort({ "title": 1 }).skip(2)
    db.recipes.find({ "cook_time": { $lt: 32 }}, { "title": 1 })
    db.recipes.find({ "cook_time": { $lt: 32 }}, { "title": 1, "cook_time": 1 })
    db.recipes.find({ "cook_time": { $gt: 32 }}, { "title": 1, "cook_time": 1 })
    db.recipes.find({ "cook_time": { $gte: 32 }}, { "title": 1, "cook_time": 1 })
    db.recipes.find({ "cook_time": { $lte: 32 }, "prep_time": { $lte: 10 }}, { "title": 1, "cook_time": 1, "prep_time": 1 })
    db.recipes.find({ "_id": ObjectId("5e6fd805fa98021236426a24")}, { "title": 1, "cook_time": 1, "prep_time": 1 })
    db.recipes.find({ "tags": "easy"}, { "title": 1, "tags": 1 })
    db.recipes.find({ "tags": { $all: ["easy", "quick"] }}, { "title": 1, "tags": 1 })
    db.recipes.find({ "tags": { $in: ["easy", "quick"] }}, { "title": 1, "tags": 1 })
    db.recipes.find({ "ingredients.name": "egg" }, { "title": 1, "ingredients.name": 1 }).pretty()

Update samples

    db.recipes.updateOne({ "title": "New recipe" }, { $set: { "title": "Thin crust pizza" }})
    db.recipes.updateOne({ "title": "Thin crust pizza" }, { $set: { "vegan": false }})
    db.recipes.updateOne({ "title": "Thin crust pizza" }, { $unset: { "vegan": 1 }})
    db.recipes.updateOne({ "title": "Tacos" }, { $inc: { "likes_count": 1 }})
    db.recipes.updateOne({ "title": "Tacos" }, { $push: { "likes": 60 }})
    db.recipes.updateOne({ "title": "Tacos" }, { $pull: { "likes": 60 }})

Delete samples

    db.recipes.deleteOne({"_id" : ObjectId("608650c5825efff7599de84b")})

[comment]: <> (    db.recipes.find&#40;{ $or: [{"cook_time": { $lte: 32 }, "prep_time": { $lte: 10 }}], { "title": 1, "cook_time": 1, "prep_time": 1 }&#41;)
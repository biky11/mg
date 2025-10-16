import json
from pymongo import MongoClient

dict={
    "name":"ancel",
    "age":21
}

client=MongoClient("mongodb://localhost:27017/")
db=client["pyjs"]
col=db["usr"]

a=col.insert_one(dict)
print(a.inserted_id)


#mongoexport --db ptjs --collection usr --out expjs.json
#mongoimport --db ptjs --collection usr --file expjs.json

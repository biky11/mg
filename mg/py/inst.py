from pymongo import MongoClient

client= MongoClient("mongodb://localhost:27017")

db=client["pydb1"]
col=db["usr"]

records=[
    {"name":"ancee","age":20},
    {"name":"sujal","age":21},
    {"name":"chaitu","age":21}
    ]

i=col.insert_many(records);
print("inserted is : ",i.inserted_ids);

for doc in col.find():
    print(doc)
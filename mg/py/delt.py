from pymongo import MongoClient

c=MongoClient("mongodb://localhost:27017/")
db=c["pydb1"]
col=db["usr"]

i=col.delete_many({"age":{"$gt":1}})
print(i.deleted_count)
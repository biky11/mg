from pymongo import MongoClient

c=MongoClient("mongodb://localhost:27017/")

db=c["pydb1"]
col=db["usr"]

i=col.update_many({"age":{'$lt':90}},{"$set":{"clg":"srm"}})
for x in col.find():
    print(x)
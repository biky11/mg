import json

with open("js_dump.json",'r')as a:
    js_dp=json.load(a)
    
print("loaded file : \n",js_dp)

print("name ",js_dp["name"])
print("\n age ",js_dp["age"])

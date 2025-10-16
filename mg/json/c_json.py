import json

dict={
    "name":"ancel",
    "age":21,
    "country":"india"
}

print("py dictionary : \n",dict)
print("file type : ",type(dict))

json_s=json.dumps(dict)
print("\njson file",json_s)
print("\ntype ",type(json_s))

with open("js_dump.json",'a')as a:
    a.write(json_s)
    print("\n json data saved to file")

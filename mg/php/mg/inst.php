<?php
require 'vendor/autoload.php';

$client=new MongoDB\Client("mongodb://localhost:27017");
$db=$client->phpdb2;

$col=$db->usr;

$res=$col->insertOne(['name'=>"ancel","age"=>20]);

echo "result : ".$res->getInsertedId();

$res2=$col->insertMany([['name'=>'sujal','age'=>21],['name'=>'shubham','age'=>19]]);

foreach($res2->getInsertedIds() as $id){
    echo " result : ".$id."<br>";
}
?>
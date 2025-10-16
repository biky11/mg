<?php

require "vendor/autoload.php";
$client= new MongoDB\Client("mongodb://localhost:27017");

$db=$client->phpdb2;
$col=$db->usr;

$res=$col->updateOne(["name"=>"ancel"],['$set'=>["age"=>69]]);
echo "matched : ".$res->getMatchedCount()." modified : ".$res->getModifiedCount()."<br>";

$res2=$col->updateMany(["age"=>['$gt'=>1]],['$set'=>["clg"=>"srm"]]);
echo "matched : ".$res2->getMatchedCount()." modified : ".$res2->getModifiedCount()."<br>";

?>
<?php


require "vendor/autoload.php";
$client=new MongoDB\Client("mongodb://localhost:27017");

$db=$client->phpdb2;
$col=$db->usr;

$res=$col->deleteOne(["name"=>"ancel"]);
echo "deleteed : ".$res->getDeletedCount();

$res=$col->deleteMany(["age"=>['$lt'=>90]]);
echo "delete : ".$res->getDeletedCount();

?>
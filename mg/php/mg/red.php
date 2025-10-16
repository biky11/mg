<?php
require 'vendor/autoload.php';

$client = new MongoDB\Client("mongodb://localhost:27017");

$db=$client->phpdb2;
$col=$db->usr;

$rev=$col->find(["age"=>['$gt'=>1]]);

if($rev){
    foreach($rev as $doc){
    echo "name : ".$doc["name"]." age : ".$doc["age"]."<br>";
    }
}


?>
<?php

include("db_info.php");
//here we are getting the values off the database

$id = $_GET["id"];
//we will have a counter or something like that binded to the convert button
//the counter will be the same amount as the id in the db and we will use that to retrieve the data

$query = $mysqli -> prepare("SELECT (amount, currency) FROM conversions WHERE id = ?") ; 

$query->bind_param("i", $id);

$query -> execute(); 

$array = $query->get_result();

$response = [];

while($value = $array -> fetch_assoc()){
    $response[] = $value;

}
$json_response = json_encode($response);
echo($json_response);



?>
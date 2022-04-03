<?php

include("db_info.php");
//here we are going to take the user input and store them in the db

$amount = $_POST["amount"]; 
$currency = $_POST["currency"];


$query = $mysqli -> prepare("INSERT INTO conversions (amount, currency) VALUES (?, ?)"); 

$query -> bind_param("ii", $ammount, $currency); //links the variables to the query

$query -> execute();

$array = [];
$array["status"] = "success";

$json_array = json_encode($array);
echo $json_array;



?>
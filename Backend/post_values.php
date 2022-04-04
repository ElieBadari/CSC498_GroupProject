<?php

include("db_info.php");
//here we are going to take the user input and store them in the db
include("get_rate.php");

$amount = $_POST["amount"]; 
$currency = $_POST["currency"];


$query = $mysqli -> prepare("INSERT INTO conversions (amount, currency, rate) VALUES (?, ?, ?)"); 




$query -> bind_param("iii", $amount, $currency, $rate); //links the variables to the query

$query -> execute();

$array = [];
$array["status"] = "success";

$json_array = json_encode($array);
echo $json_array;



?>
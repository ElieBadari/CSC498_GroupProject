<?php

include("db_info.php");
//here we are going to take the user input and store them in the db
include("get_rate.php");

$rate = $_POST["rate"];
$amount = $_POST["amount"]; 
$currency = $_POST["currency"];


$query = $mysqli -> prepare("INSERT INTO conversions (amount, currency) VALUES (?, ?)"); 

//here i must calculate the converted amount using the get_rate api
if(currency == 1){ //means convert to lbp
    $amount = $amount * intval($rate);
}else{//convert to usd
    $amount = $amount / intval($rate);
}


$query -> bind_param("ii", $amount, $currency); //links the variables to the query

$query -> execute();

$array = [];
$array["status"] = "success";

$json_array = json_encode($array);
echo $json_array;



?>
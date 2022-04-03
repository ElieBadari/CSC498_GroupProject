<?php

//this is to allow php to enter phpmyadmin page programatically 
//we should never leave the username as root and password ass null (when the db is online/public)
$db_host = "localhost"; //localhost because the db is hosted locally on my computer
$db_user = "root";//user used to log into the db default is root
$db_pass = null;//default = null  
$db_name = "currencyconverterdb";

//constructor 
$mysqli = new mysqli($db_host,$db_user,$db_pass,$db_name);
//this php file can talk to the dbms using this php file because of the above line
if(mysqli_connect_errno()){
    die("connection failed");
}



?>
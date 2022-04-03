<?php

include("db_info.php");

$query = $mysqli -> prepare("SELECT * FROM courses;") ; //mysqli + prepare is used to counter sql injection
                                                        //prepare prepares the query then runs it
                                                        //sql injection is the worst type of hacking


?>
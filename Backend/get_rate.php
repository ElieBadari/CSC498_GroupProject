<?php

$url = "https://lirarate.org/wp-json/lirarate/v2/rates?currency=LBP&_ver=t20224410";

$cURL = curl_init($url);

curl_setopt($cURL, CURLOPT_RETURNTRANSFER, 1);

curl_setopt($cURL, CURLOPT_URL, $url);

$result = curl_exec($cURL);

curl_close($cURL);

$stdClass = (json_decode($result));

$array = json_decode(json_encode($stdClass),true);

$rate = $array['buy'][count($array['buy']) -1][1];









?>
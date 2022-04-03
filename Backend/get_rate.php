<?php

include("db_info.php");
include("simple_html_dom.php");

//here we are getting the entire page converting it to dom and storing in var = $html
$html = file_get_html("https://lirarate.org/");
//what we are going to try to do is find the conversion rate
//we are interested in the class = wp-block-columns

foreach($html -> find(".tab-content") as $post_div )
{

    echo"<pre>";
    die(var_dump($post_div));

        
}




?>
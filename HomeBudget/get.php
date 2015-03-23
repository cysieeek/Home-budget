<?php

include "Database.php";

$mysql = new Mysql("mysql.hostinger.pl", "u906935981_pz", "Aq12wS", "u906935981_pz");

/*
 * return value array
 * valuse = 0
 * message = error while execute query
 * -----------------
 * valuse = 1
 * message = GET_SUCCESS
 * array = array
 * -----------------
 * valuse = 2
 * message = GET_SUCCESS_NULL
 */
if(isset($_POST['get_summary'])){
    $response = array();
    $mysql->connect();
    $result = $mysql->getSummary($_POST['get_summary']);
    if($result === false){
        $response['response_value'] = 0;
        $response['response_message'] = $result;
    }
    else{
        $row = mysqli_fetch_assoc($result);
        if($row != null){
            $response['response_value'] = 1;
            $response['response_message'] = 'GET_SUCCESS';
            $response['response_array'] = $row;
        }
        else{
            $response['response_value'] = 2;
            $response['response_message'] = 'GET_SUCCESS_NULL';
        }
    }
    echo json_encode($response);
    $mysql->close();
}

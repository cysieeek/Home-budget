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
if(isset($_POST['get_element']) && isset($_POST['get_element_type'])){
    $response = array();
    $mysql->connect();
    $result = $mysql->getElement($_POST['get_element'], $_POST['get_element_type']);
    if($result === false){
        $response['response_value'] = 0;
        $response['response_message'] = $mysql->getError();
    }
    else{
        if(mysqli_num_rows($result) >= 0){
            $temp_id = array();
            $temp_name = array();
            $i = 0;
            while($row = mysqli_fetch_array($result)){
                $temp_id['id['.$i.']'] = $row['id'];
                $temp_name['name['.$i++.']'] = $row['name'];
            }
        
            $response['response_value'] = 1;
            $response['response_message'] = 'GET_SUCCESS';
            $response['response_array_id'] = $temp_id;
            $response['response_array_name'] = $temp_name;
        }        
        else{
            $response['response_value'] = 2;
            $response['response_message'] = 'GET_SUCCESS_NULL';
        }
    }
    echo json_encode($response);
    $mysql->close();
}

if(isset($_POST['get_element_detail']) && isset($_POST['get_element_id'])){
    $response = array();
    $mysql->connect();
    $result = $mysql->getElementDetail($_POST['get_element_detail'], $_POST['get_element_id']);
    if($result === false){
        $response['response_value'] = 0;
        $response['response_message'] = $mysql->getError();
    }
    else{
        if(mysqli_num_rows($result) >= 0){
            $temp_id = array();
            $temp_name = array();
            $temp_value = array();
            $i = 0;
            while($row = mysqli_fetch_array($result)){
                $temp_id['id['.$i.']'] = $row['id'];
                $temp_name['name['.$i.']'] = $row['name'];
                $temp_value['value['.$i++.']'] = $row['value'];
            }
            $response['response_value'] = 1;
            $response['response_message'] = 'GET_SUCCESS';
            $response['response_array_id'] = $temp_id;
            $response['response_array_name'] = $temp_name;
            $response['response_array_element_value'] = $temp_value;
        }        
        else{
            $response['response_value'] = 2;
            $response['response_message'] = 'GET_SUCCESS_NULL';
        }
    }
    echo json_encode($response);
    $mysql->close();
}

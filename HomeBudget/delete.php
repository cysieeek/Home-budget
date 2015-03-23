<?php

/*
 * return value array()
 * valuse = 0
 * message = error while execute query
 * -----------------
 * valuse = 1
 * message = ELEMENT_DELETED
 */
if(isset($_POST['delete_element'])){
    $mysql->connect();
    if($result = $mysql->deleteElement($_POST['delete_element'])){
        $response['response_value'] = 1;
        $response['response_message'] = "ELEMENT_DELETED";
    }
    else{
        $response['response_value'] = 0;
        $response['response_message'] = $result;
    }
    $mysql->close();
    echo json_encode($response);
}

/*
 * return value array()
 * valuse = 0
 * message = error while execute query
 * -----------------
 * valuse = 1
 * message = ELEMENT_DETAIL_DELETED
 */
if(isset($_POST['delete_element_detail'])){
    $mysql->connect();
    if($result = $mysql->deleteElementDetail($_POST['delete_element_detail'])){
        $response['response_value'] = 1;
        $response['response_message'] = "ELEMENT_DETAIL_DELETED";
    }
    else{
        $response['response_value'] = 0;
        $response['response_message'] = $result;
    }
    $mysql->close();
    echo json_encode($response);
}

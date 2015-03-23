<?php

class Mysql{
    private $host;
    private $user;
    private $password;
    private $name;
    private $link;
    
    public function __construct($h, $u, $p, $d){
        $this->host = $h;
        $this->user = $u;
        $this->password = $p;
        $this->name = $d;
    }
    
    public function connect(){
        $this->link = new mysqli($this->host, $this->user, $this->password, $this->name);
        $this->link->set_charset("utf8");
    }
    
    private function getError(){
        return mysqli_error($this->link);
    }
    
    public function close(){
        mysqli_close($this->link);
    }
    
    /*
     * return value boolean or string
     * if query successed
     * true
     * -----------
     * if query failed
     * a string that describes the error
     */
    public function insertToken($token){
        $this->clear($token);
        $query = "insert into user (id) values ('". $token ."');";
        if(mysqli_query($this->link, $query)){
           return true;
        }else{
            return $this->getError();
        }
    }
    
    /*
     * return value boolean or string
     * if query successed
     * true
     * -----------
     * if query failed
     * a string that describes the error
     */
    public function insertElement($token, $name, $type){
        $this->clear($token);
        $this->clear($name);
        $this->clear($type);
        $query = "insert into element (id_user, name, type) values ('". $token ."', '". $name ."', '". $type ."');";
        if(mysqli_query($this->link, $query)){
           return true;
        }
        else{
            return $this->getError();
        }
    }
    
    /*
     * return value boolean or string
     * if query successed
     * true
     * -----------
     * if query failed
     * a string that describes the error
     */
    public function insertElementDetail($id_element, $name, $value){
        $this->clear($id_element);
        $this->clear($name);
        $this->clear($value);
        $query = "insert into element_detail (id_element, name, value) values ('". $id_element ."', '". $name ."', '". $value ."');";
        if(mysqli_query($this->link, $query)){
           return true;
        }else{
            return $this->getError();
        }
    }
    
    /*
     * return value boolean or string
     * if query successed
     * true
     * -----------
     * if query failed
     * a string that describes the error
     */
    public function deleteToken($token){
        $this->clear($token);
        $query = "delete from user where id like '". $token ."');";
        if(mysqli_query($this->link, $query)){
           return true;
        }else{
            return $this->getError();
        }
    }
    
    /*
     * return value boolean or string
     * if query successed
     * true
     * -----------
     * if query failed
     * a string that describes the error
     */
    public function deleteElement($id){
        $this->clear($id);
        $query = "delete from element where id = '". $id ."';";
        if(mysqli_query($this->link, $query)){
           return true;
        }
        else{
            return $this->getError();
        }
    }
    
    /*
     * return value boolean or string
     * if query successed
     * true
     * -----------
     * if query failed
     * a string that describes the error
     */
    public function deleteElementDetail($id){
        $this->clear($id);
        $query = "delete from element_detail where id = '". $id ."';";
        if(mysqli_query($this->link, $query)){
           return true;
        }else{
            return $this->getError();
        }
    }
      
    /*
     * return value mysqli_result object or string
     * if query successed
     * mysqli_result object
     * -----------
     * if query failed
     * a string that describes the error
     */
    public function getSummary($token){
        $this->clear($token);
        $query = "select * from summary where id like '". $token ."';";
        $result = mysqli_query($this->link, $query);
        if($result === false){
           return $this->getError();
        }
        else{
           return $result;
        }
    }
    
    /*
     * return value mysqli_result object or string
     * if query successed
     * mysqli_result object
     * -----------
     * if query failed
     * a string that describes the error
     */
    public function getElement($token){
        $this->clear($token);
        $query = "select element.* from element join user on user.id = elemetn.id_user where user.id = '". $token ."';";
        if($result = mysqli_query($this->link, $query)){
           return $result;
        }
        else{
            return $this->getError();
        }
    }
    
    /*
     * return value mysqli_result object or string
     * if query successed
     * mysqli_result object
     * -----------
     * if query failed
     * a string that describes the error
     */
    public function getElementDetail($token){
        $this->clear($token);
        $query = "select element_detail.* from element_detail "
                . "join element on element.id = element_detail.id_element "
                . "join user on user.id = elemetn.id_user "
                . "where user.id = '". $token ."';";
        if($result = mysqli_query($this->link, $query)){
           return $result;
        }else{
            return $this->getError();
        }
    }
    
    /*
     * return value boolean or string
     * if query successed and query return row
     * true
     * -----------
     * if query successed and query dont return row
     * true
     * -----------
     * if query failed
     * a string that describes the error
     */
    public function tokenExist($token){
        $this->clear($token);
        $query = "select * from user where id = '". $token ."';";
        $result = mysqli_query($this->link, $query);
        if(!$result){
            return $this->getError();
        }
        if(mysqli_num_rows($result) > 0){
            return true;
        }
        return false;
    }
    
    
    private function clear($text){
        if(empty($text)){
            return false;
        }
        if(get_magic_quotes_gpc()) {
            $text = stripslashes($text);
        }
        return (mysqli_real_escape_string($this->link, htmlspecialchars(trim($text))));
    }

}

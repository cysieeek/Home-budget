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
    
    public function getError(){
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
        $query = "insert into user (id) values ('". $this->clear($token) ."');";
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
    public function insertElement($token, $name, $type){
        $query = "insert into element (id_user, name, type)"
                . " values ('". $this->clear($token) ."', '".  $this->clear($name) ."', '". $this->clear($type) ."');";
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
        $query = "insert into element_detail (id_element, name, value)"
                . " values ('". $this->clear($id_element) ."', '". $this->clear($name) ."', '". $this->clear($value) ."');";
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
    public function deleteToken($token){
        $query = "delete from user where id like '". $this->clear($token) ."');";
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
    public function deleteElement($token, $id){
        $query = 'delete from element '
                . 'join user on user.id = element.id_user '
                . 'where element.id = "'. $this->clear($id) .'" and user.id = "'.$this->clear($token).'";';
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
    public function deleteElementDetail($token, $id){
        $query = 'delete from element_detail '
                . 'join element on element.id = element_detail.id_element '
                . 'join user on user.id = element.id_user '
                . 'where id = "'. $this->clear($id) .'" and user.id = "'.$this->clear($token).'";';
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
    public function updateElement($token, $id, $name){
        $query = 'update element '
                . 'join user on user.id = element.id_user '
                . 'set name="'.$this->clear($name).'" '
                . 'where element.id="'.$this->clear($id).'" and user.id="'.$this->clear($token).'";';
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
    public function updateElementDetail($token, $id, $name, $value){
        $this->clear($id);
        $query = 'update element_detail '
                . 'join element on element.id = element_detail.id_element '
                . 'join user on user.id = element.id_user '
                . 'set element_detail.name = "'.$this->clear($name).'", element_detail.value = "'.$this->clear($value).'" '
                . 'where element_detail.id = "'. $this->clear($id) .'" and user.id = "'.$this->clear($token).'";';
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
    public function getElement($token, $type){
        $this->clear($token);
        $this->clear($type);
        $query = 'select element_detail.* from element_detail '
                . 'join element on element.id = element_detail.id_element '
                . 'join user on user.id = element.id_user '
                . 'where element.type like "'.$type.'" and '
                . 'user.id like "'. $token .'";';
        return mysqli_query($this->link, $query);
    }
    
    /*
     * return value mysqli_result object or string
     * if query successed
     * mysqli_result object
     * -----------
     * if query failed
     * a string that describes the error
     */
    public function getElementDetail($token, $id){
        $this->clear($token);
        $this->clear($id);
        $query = 'select element_detail.* from element_detail '
                . 'join element on element.id = element_detail.id_element '
                . 'join user on user.id = element.id_user '
                . 'where element.id like "'.$id.'" and '
                . 'user.id like "'. $token .'";';
        return mysqli_query($this->link, $query);
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

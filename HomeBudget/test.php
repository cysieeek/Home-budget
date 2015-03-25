<?php

echo  '<form action="insert.php" method="post">
        insert Token:<br>
        <input type="text" name="insert_token">
        <input type="submit" value="Submit">
        </form> ';


echo  '<form action="check.php" method="post">
        check Token:<br>
        <input type="text" name="check_token">
        <input type="submit" value="Submit">
        </form> ';


echo  '<form action="get.php" method="post">
        get element:<br>
        <input type="text" name="get_element" placeholder="token">
        <input type="text" name="get_element_type" placeholder="type">
        <input type="submit" value="Submit">
        </form> ';

echo  '<form action="get.php" method="post">
        get element_detaul:<br>
        <input type="text" name="get_element_detail" placeholder="token">
        <input type="text" name="get_element_id" placeholder="id">
        <input type="submit" value="Submit">
        </form> ';
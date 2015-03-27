<?php

echo  '<form action="insert.php" method="post">
        insert Token:<br>
        <input type="text" name="insert_token" placeholder="token">
        <input type="submit" value="Submit">
        </form> ';

echo  '<form action="insert.php" method="post">
        insert element:<br>
        <input type="text" name="insert_element" placeholder="token">
        <input type="text" name="insert_element_name" placeholder="name">
        <input type="text" name="insert_element_type" placeholder="type">
        <input type="submit" value="Submit">
        </form> ';

echo  '<form action="insert.php" method="post">
        insert element_detail:<br>
        <input type="text" name="insert_element_detail" placeholder="token">
        <input type="text" name="insert_element_detail_id_element" placeholder="id_element">
        <input type="text" name="insert_element_detail_name" placeholder="name">
        <input type="text" name="insert_element_detail_value" placeholder="value">
        <input type="submit" value="Submit">
        </form> ';

echo  '<form action="check.php" method="post">
        check Token:<br>
        <input type="text" name="check_token" placeholder="token">
        <input type="submit" value="Submit">
        </form> ';


echo  '<form action="get.php" method="post">
        get element:<br>
        <input type="text" name="get_element" placeholder="token">
        <input type="text" name="get_element_type" placeholder="type">
        <input type="submit" value="Submit">
        </form> ';

echo  '<form action="get.php" method="post">
        get element_detail:<br>
        <input type="text" name="get_element_detail" placeholder="token">
        <input type="text" name="get_element_id" placeholder="id">
        <input type="submit" value="Submit">
        </form> ';

echo  '<form action="update.php" method="post">
        update element:<br>
        <input type="text" name="update_element" placeholder="token">
        <input type="text" name="update_element_id" placeholder="id">
        <input type="text" name="update_element_name" placeholder="name">
        <input type="submit" value="Submit">
        </form> ';

echo  '<form action="update.php" method="post">
        update element_detail:<br>
        <input type="text" name="update_element_detail" placeholder="token">
        <input type="text" name="update_element_detail_id" placeholder="id">
        <input type="text" name="update_element_detail_name" placeholder="name">
        <input type="text" name="update_element_detail_value" placeholder="value">
        <input type="submit" value="Submit">
        </form> ';
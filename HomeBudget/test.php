<?php

echo  '<form action="insert.php" method="post">
        Token:<br>
        <input type="text" name="insert_token">
        <input type="submit" value="Submit">
        </form> ';


echo  '<form action="check.php" method="post">
        Token:<br>
        <input type="text" name="check_token">
        <input type="submit" value="Submit">
        </form> ';


echo  '<form action="get.php" method="post">
        Token:<br>
        <input type="text" name="get_summary">
        <input type="submit" value="Submit">
        </form> ';
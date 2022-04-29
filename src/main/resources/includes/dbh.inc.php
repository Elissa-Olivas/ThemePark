<?php

function OpenCon() {
    $serverName = "localhost";
    $dbUsername = "root";
    $dbPassword = "";
    $dbName = "phpThemeParkDatabase";
$conn = new mysqli($serverName, $dbUsername, $dbPassword, $dbName) or die("Connect failed: %s\n". $conn -> error);


return $conn;
}

function CloseCon($conn)
{
    $conn -> close();
}

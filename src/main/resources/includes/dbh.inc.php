<?php

function OpenCon() {
    $serverName = "localhost";
    $dbUsername = "root";
    $dbPassword = "Code!7890";
    $dbName = "phpThemeParkDatabase";
$conn = new mysqli($serverName, $dbUsername, $dbPassword, $dbName) or die("Connect failed: %s\n". $conn -> error);


return $conn;
}

function CloseCon($conn)
{
    $conn -> close();
}
//$serverName = "localhost";
//$dbUsername = "root";
//$dbPassword = "Code!7890";
//$dbName = "phpThemeParkDatabase";
//
//$conn = mysqli_connect($serverName, $dbUsername, $dbPassword, $dbName);
//
//if (!$conn) {
//    die("Connection failed: " . mysqli_connect_error());
//
//
//}
<?php
    session_start();
?>



<!DOCTYPE html>
<html lang="en" dr="ltr" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" th:href="@{../static/css.css}"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <style>
        body {
            text-align: center;
        }

        h1 {
            text-align: center;
            font-family: Copperplate, Papyrus, fantasy;
        }
    </style>
</head>
<body>
<section class="navigation">
    <div class="nav-container">
        <div class="brand">
            <img th:src="'../static/images/' + 'MickeyLogo2.png'" alt="" width="50" height="50"
                 class="d-inline-block align-text-top">
            <a th:href="@{/}">GISNEYLAND</a>
        </div>
        <nav>
            <div class="nav-mobile"><a id="nav-toggle" th:href="@{/}"><span></span></a></div>
            <ul class="nav-list">
                <li>
                    <a href="index.php">index</a>
                </li>
                <?php
                if (isset($_SESSION["useruid"])) {
                    echo "<li><a href='index.php'>Profile Page</a></li>";
                    echo "<li><a href='../includes/logout.inc.php'>Log Out</a></li>";
                }
                else {
                    echo "<li><a href='signup.php'>Sign Up</a></li>";
                    echo "<li><a href='login.php'>Log In</a></li>";
                }
                ?>
            </ul>
        </nav>
    </div>
</section>
<div class="wrapper">

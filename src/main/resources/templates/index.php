<?php
    include_once 'header.php';
//include '../includes/dbh.inc.php';
//$conn = OpenCon();
//echo "Connected Successfully";
//CloseCon($conn);
//require_once '../includes/functions.inc.php';
?>

<div class="wrapper">
    <section class="index-intro">
        <?php
        if (isset($_SESSION["useruid"])) {
            echo "<p>Hello " . $_SESSION["useruid"] . "</p>";
        }
        ?>
        <h1>Welcome to the home page</h1>
        <p>Here is an important paragraph</p>
    </section>

<?php
include_once 'footer.php';
?>
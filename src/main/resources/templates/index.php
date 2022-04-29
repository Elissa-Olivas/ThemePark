<?php
include_once 'header.php';
include '../includes/dbh.inc.php';
?>

    <div class="wrapper">
    <section class="index-intro">
        <?php
        if (isset($_SESSION["useruid"])) {
            echo "<p>Hello " . $_SESSION["useruid"] . "</p>";
        }
        ?>
        <h1>Welcome to MyGisney</h1>
    </section>

<?php
include_once 'footer.php';
?>
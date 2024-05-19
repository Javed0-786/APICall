<?php
    $conn = mysqli_connect("localhost", "root", "", "test");
    
    $name = $_GET['name'];
    $email = $_GET['email'];

    $query = "INSERT INTO users (name, email) VALUES ('$name', '$email')";
    $result = mysqli_query($conn, $query);
    if($result==true)
        $response = "inserted";
    else 
        $response = "failed";

    echo json_encode($response);
?>
    

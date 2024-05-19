<?php
    $conn = mysqli_connect("localhost", "root", "", "test");
    $query = "SELECT * FROM users";
    $raw = mysqli_query($conn, $query);
    while($res=mysqli_fetch_array($raw))
    {
        $data[]=$res;
    }
    print(json_encode($data));
    ?>
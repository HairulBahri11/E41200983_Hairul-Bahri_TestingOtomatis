<?php

$server = "localhost";
$username = "root";
$password = "";
$db = "risquna1";
$koneksi = mysqli_connect($server, $username, $password, $db);

if (mysqli_connect_errno()) {
    echo "Koneksi Gagal : " . mysqli_connect_error();
}else{
    echo "Koneksi berhasil \n";
}

?>
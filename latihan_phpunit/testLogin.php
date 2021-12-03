<?php

//menggunakan framework phpunit
use PHPUnit\Framework\TestCase;

//memanggil kelas yang digunakan untuk testing
require_once 'login.php';

//kelas untuk menjalankan testing
class testLogin extends TestCase{
    
    //membuat fungsi testLoginData
    function testLoginData(){
        
        //buat  objek dari kelas login
        $insert = new login();

        //menginputkan data email dan password yang ada di database
        $email = "irul@email.com";
        $password = "123";

        $hasil = $insert->login_proses($email,$password);

        //memeriksa dan mencocokkan secara otomatis
        //pabila cocok maka tampilan akan berhasil login
        $this->assertTrue($hasil);
    }

}





?>
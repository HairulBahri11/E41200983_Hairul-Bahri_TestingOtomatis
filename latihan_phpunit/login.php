<?php


class login{

    //membuat method untuk menmanpung email dan password
    public function login_proses($email , $password){
            
        include 'koneksi.php';

         // menyeleksi data user dengan username dan password yang sesuai
        $query = "SELECT * from users where email = '$email' AND password = '$password'";
        $q = mysqli_query($koneksi,$query);

       
        //mengecek jika query benar maka 
        if ($q) {
            //tampilkan berhasil login
            echo 'Berhasil Login';
            return true;
        } else {
            //jika query salah , tampilkan gagal login
            echo 'Gagal Login';
            return true;
        }

        
    }

   
}


?>
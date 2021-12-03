package com.risquna.risqunaridho;

import android.content.Context;
import android.util.Log;

import com.risquna.risqunaridho.Admin.API.ApiClient;
import com.risquna.risqunaridho.Admin.API.ApiInterface;
import com.risquna.risqunaridho.Admin.model.login.Login;
import com.risquna.risqunaridho.Admin.model.login.LoginActivity;
import com.risquna.risqunaridho.Admin.model.login.LoginData;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.concurrent.CountDownLatch;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


@RunWith(MockitoJUnitRunner.class)

public class LoginUnitTest {
    private static final String FAKE_STRING = "Login Berhasil";

    private String email = "tes@gmail.com";
    private String password = "123";
    private Login login;
    private String message;
    private final CountDownLatch latch = new CountDownLatch(1);

    private ApiInterface apiInterface;

    @Before
    public void beforeTest() {
        MockitoAnnotations.initMocks(this);
        apiInterface = ApiClient.getClient(LoginActivity.class).create(ApiInterface.class);
    }

    @Test
    public void test_login() throws InterruptedException {
//        Assert.assertNotNull(apiInterface);
        apiInterface.ardLogin(email, password).enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                login = response.body();
                message = login.getStatus();
                latch.countDown();
                System.out.println(message);
            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                Log.e("error", t.getMessage());
                latch.countDown();
            }
        });
        latch.await();
        Assert.assertNotNull(login);
        System.out.println(login.getStatus());
        assert message.equals(FAKE_STRING);
    }
}

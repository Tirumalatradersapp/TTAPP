package com.ttapp.utils;

import com.ttapp.pojos.login.LoginResponse;
import com.ttapp.pojos.registation.registrationParams.RegistrationParams;
import com.ttapp.pojos.registation.registrationResponse.RegisterResponse;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.Header;
import retrofit.http.POST;

/**
 * Created by halya on 2/7/17.
 */

public interface APIInterface {
    @POST(AllUrl.REGISTRATION)
    Call<RegisterResponse> register(@Header("Content-Type") String content,
                                   @Body RegistrationParams registrationParams);

    @POST(AllUrl.LOGIN)
    Call<LoginResponse> login(@Header("Content-Type") String content,
                              @Body RegistrationParams registrationParams);
}

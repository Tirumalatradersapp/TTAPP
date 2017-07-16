package com.ttapp.activities;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ttapp.R;
import com.ttapp.pojos.registation.registrationParams.Data;
import com.ttapp.pojos.registation.registrationParams.RegistrationParams;
import com.ttapp.pojos.registation.registrationResponse.RegisterResponse;
import com.ttapp.utils.APIInterface;
import com.ttapp.utils.NetworkDetector;
import com.ttapp.utils.RestClient;
import com.ttapp.utils.Validations;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;

public class Signup extends AppCompatActivity implements View.OnClickListener{
    private EditText name,mobile,email,firmName,password,confirmPassword,disrict,mandal,village,
            address;
    private TextInputLayout nameLayout,mobileLayout,emailLayout,firmNameLayout,passwordLayout,
            confirmPasswordLayout,disrictLayout,mandalLayout,villageLayout, addressLayout;
    private Button signup;
    private LinearLayout loginLayout;
    private NetworkDetector networkDetector;
    private ProgressDialog progressDialog;
    private static final String TAG=Signup.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        initializeViews();
        initializeClickListeners();
    }

    private void initializeViews() {
        networkDetector=new NetworkDetector(this);
        name=(EditText)findViewById(R.id.signup_name);
        mobile=(EditText)findViewById(R.id.signup_number);
        email=(EditText)findViewById(R.id.signup_email);
        firmName=(EditText)findViewById(R.id.signup_firmName);
        password=(EditText)findViewById(R.id.signup_Password);
        confirmPassword=(EditText)findViewById(R.id.signup_confirm_Password);
        disrict=(EditText)findViewById(R.id.signup_district);
        mandal=(EditText)findViewById(R.id.signup_mandal);
        village=(EditText)findViewById(R.id.signup_village);
        address=(EditText)findViewById(R.id.signup_address);

        nameLayout=(TextInputLayout) findViewById(R.id.signup_nameLayout);
        mobileLayout=(TextInputLayout)findViewById(R.id.signup_numberLayout);
        emailLayout=(TextInputLayout)findViewById(R.id.signup_emailLayout);
        firmNameLayout=(TextInputLayout)findViewById(R.id.signup_firmNameLayout);
        passwordLayout=(TextInputLayout)findViewById(R.id.signup_passwordLayout);
        confirmPasswordLayout=(TextInputLayout)findViewById(R.id.signup_confirm_passwordLayout);
        disrictLayout=(TextInputLayout)findViewById(R.id.signup_districtLayout);
        mandalLayout=(TextInputLayout)findViewById(R.id.signup_mandalLayout);
        villageLayout=(TextInputLayout)findViewById(R.id.signup_villageLayout);
        addressLayout=(TextInputLayout)findViewById(R.id.signup_addressLayout);

        signup=(Button)findViewById(R.id.signup_button);
        loginLayout=(LinearLayout)findViewById(R.id.signup_login_layout);

    }


    private void initializeClickListeners() {
        signup.setOnClickListener(this);
        loginLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.signup_button:
                checkVaalidations();
                break;
            case R.id.signup_login_layout:
                startActivity(new Intent(this,Login.class));
                break;
        }
    }

    private void checkVaalidations() {
        if (name.getText().toString().length()==0) {
            nameLayout.setError("Enter Name");
        } else if (!Validations.isMobileValid(mobile.getText().toString())) {
            mobileLayout.setError("Enter Valid Mobile Number");
        }else if(firmName.getText().toString().length()==0){
            firmNameLayout.setError("Enter Firm Name");
        } else if(password.getText().toString().length()==0){
            passwordLayout.setError("Enter Valid Password");
        } else if(confirmPassword.getText().toString().length()==0){
            confirmPasswordLayout.setError("Enter Valid Password");
        }else if(!(password.getText().toString()).equals(confirmPassword.getText().toString())){
            confirmPasswordLayout.setError("Password and Confirm Password not matching");
        }else if(disrict.getText().toString().length()==0){
            disrictLayout.setError("Enter District");
        }else if(mandal.getText().toString().length()==0){
            mandalLayout.setError("Enter Mandal");
        }else if(village.getText().toString().length()==0){
            villageLayout.setError("Enter Village");
        }else if(address.getText().toString().length()==0){
            addressLayout.setError("Enter Address");
        } else {
            checkInternet();
        }
        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                nameLayout.setError(null);
            }
        });
        mobile.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mobileLayout.setError(null);
            }
        });
        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                emailLayout.setError(null);
            }
        });
        firmName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                firmNameLayout.setError(null);
            }
        });
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                passwordLayout.setError(null);
            }
        });
        confirmPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                confirmPasswordLayout.setError(null);
            }
        });
        disrict.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                disrictLayout.setError(null);
            }
        });
        mandal.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mandalLayout.setError(null);
            }
        });
        village.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                villageLayout.setError(null);
            }
        });
        address.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                addressLayout.setError(null);
            }
        });
    }

    private void checkInternet() {
        if(networkDetector.isConnected()){
            progressDialog = ProgressDialog.show(this,"",getResources()
                    .getString(R.string.progress_dialog_text));
            sendDataToServer();

        }else {
            showInternetDialog();
        }
    }

    private void sendDataToServer() {
        Data data=new Data();
        data.setUserName(name.getText().toString());
        data.setPhoneNumber(Long.parseLong(mobile.getText().toString()));
        data.setEmailId(email.getText().toString());
        data.setFirmName(firmName.getText().toString());
        data.setPassword(password.getText().toString());
        data.setDistrictName(disrict.getText().toString());
        data.setMondalName(mandal.getText().toString());
        data.setVillageName(village.getText().toString());
        data.setAddress(address.getText().toString());
        data.setUserType("customer");

        final RegistrationParams registrationParams=new RegistrationParams();
        registrationParams.setData(data);
        APIInterface apiInterface= RestClient.getClient().create(APIInterface.class);
        Call<RegisterResponse> call=apiInterface.register("application/json",registrationParams);
        call.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Response<RegisterResponse> response) {
                closeProgressDialog();
                if(response.body().getStatus().equals(200)){
                    Validations.toast(Signup.this,response.body().getMessage());
                    startActivity(new Intent(Signup.this,Login.class));
                }else {
                    Validations.toast(Signup.this,response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Throwable t) {
                closeProgressDialog();
                Log.i(TAG, "onFailure: >>>"+t.toString());

            }
        });
    }

    private void showInternetDialog() {
        final TextView ok;
        final android.support.v7.app.AlertDialog.Builder addRecordDialog = new android.support.v7.app.AlertDialog.Builder(this);
        LayoutInflater factory = LayoutInflater.from(this);
        final View f = factory.inflate(R.layout.no_internet, null);

//        addRecordDialog.setTitle("Please Add The Record Here");
        addRecordDialog.setView(f);

        final android.support.v7.app.AlertDialog alert = addRecordDialog.create();

        alert.show();
        alert.setCancelable(false);
        alert.setCanceledOnTouchOutside(false);

        ok=(TextView)f.findViewById(R.id.ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alert.dismiss();
            }
        });
    }
    private void closeProgressDialog(){
        if(progressDialog!=null){
            if(progressDialog.isShowing()){
                progressDialog.dismiss();
                progressDialog=null;
            }
        }
    }
    }

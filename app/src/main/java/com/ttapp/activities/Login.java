package com.ttapp.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.ttapp.R;
import com.ttapp.utils.NetworkDetector;
import com.ttapp.utils.Validations;

public class Login extends AppCompatActivity implements View.OnClickListener {

    private Button login;
    private LinearLayout forgotPassword,signupLayout;
    private EditText mobile,password;
    private TextInputLayout mobileLayout,passwordLayout;
    private NetworkDetector networkDetector;
    private ProgressDialog loginDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

          /*to make the screen as full screen*/
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(getResources().getColor(R.color.light_orange));
        }

        initializeViews();
        initializeClickListeners();

    }


    private void initializeViews() {
        networkDetector=new NetworkDetector(this);
        login=(Button)findViewById(R.id.login_button);
        signupLayout=(LinearLayout)findViewById(R.id.login_signup_layout);
        forgotPassword=(LinearLayout)findViewById(R.id.login_forgot_layout);
        mobile=(EditText)findViewById(R.id.login_EtNumber);
        password=(EditText)findViewById(R.id.login_EtPassword);
        mobileLayout=(TextInputLayout)findViewById(R.id.login_tlNumber);
        passwordLayout=(TextInputLayout)findViewById(R.id.login_tlPassword);

    }

    private void initializeClickListeners() {
        login.setOnClickListener(this);
        forgotPassword.setOnClickListener(this);
        signupLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.login_button:
                checkValidation();
                break;
            case R.id.login_forgot_layout:
                startActivity(new Intent(this,ForgotPassword.class));
                this.finish();
                break;
            case R.id.login_signup_layout:
                startActivity(new Intent(this,Signup.class));
                break;
        }
    }

    private void checkValidation() {
        if (!Validations.isMobileValid(mobile.getText().toString())) {
            mobileLayout.setError("Enter Valid Mobile Number");
        }else if(password.getText().toString().length()==0){
            passwordLayout.setError("Enter Valid Password");
        } else {
            sendDataToServer();

        }
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
    }

    private void sendDataToServer() {
        if(networkDetector.isConnected()){
            loginDialog = ProgressDialog.show(this,"",getResources()
                    .getString(R.string.progress_dialog_text));
            startActivity(new Intent(this,Home.class));
            this.finish();
        }else {
            Toast.makeText(this,"No Network",Toast.LENGTH_SHORT).show();
        }

    }

    private void closeLoginDialog(){
        if(loginDialog!=null){
            if(loginDialog.isShowing()){
                loginDialog.dismiss();
                loginDialog=null;
            }
        }
    }
}

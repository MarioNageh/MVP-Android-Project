package com.marionageh.mvpdesignpatternloginapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.marionageh.mvpdesignpatternloginapp.Presenter.ILoginPresenter;
import com.marionageh.mvpdesignpatternloginapp.Presenter.LoginPresenter;
import com.marionageh.mvpdesignpatternloginapp.View.ILoginView;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity implements ILoginView {
EditText edt_email,edt_password;
Button btn_Login;

LoginPresenter loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    edt_email=findViewById(R.id.username);
    edt_password=findViewById(R.id.password);
    btn_Login=findViewById(R.id.login_btn);
        loginPresenter=new LoginPresenter(this);
    btn_Login.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            loginPresenter.onLogin(edt_email.getText().toString(),edt_password.getText().toString());
        }
    });



    }


    @Override
    public void OnLoginSuccess(String message) {
        Toasty.success(this,message).show();
    }

    @Override
    public void OnLoginFailed(String message) {
        Toasty.error(this,message).show();


    }
}

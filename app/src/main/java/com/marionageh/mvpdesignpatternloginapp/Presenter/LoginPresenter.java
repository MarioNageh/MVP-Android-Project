package com.marionageh.mvpdesignpatternloginapp.Presenter;

import com.marionageh.mvpdesignpatternloginapp.Model.User;
import com.marionageh.mvpdesignpatternloginapp.View.ILoginView;

public class LoginPresenter implements ILoginPresenter {
    ILoginView iLoginView;

    public LoginPresenter(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
    }

    @Override
    public void onLogin(String email, String password) {
        User user=new User(email,password);
        int isLoginSuccess=user.isValidtion();

        if(isLoginSuccess==0)
            iLoginView.OnLoginFailed("You Must Enter Your Email");
        else if(isLoginSuccess==1)
            iLoginView.OnLoginFailed("You Must Write a  vaild Email");
        else if(isLoginSuccess==2)
            iLoginView.OnLoginFailed("Password must be over 6 chars");
        else
            iLoginView.OnLoginSuccess("Succes Login");

    }
}

package com.marionageh.mvpdesignpatternloginapp.View;

public interface ILoginView {
    void OnLoginSuccess(String message);
    void OnLoginFailed(String message);
}

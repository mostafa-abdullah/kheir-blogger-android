package com.khierblogger.khierbloggerapp.Intefaces;

public interface UserAuthenticationCallback {
    void authenticationSuccessful();
    void authenticationFailed(String message);
}

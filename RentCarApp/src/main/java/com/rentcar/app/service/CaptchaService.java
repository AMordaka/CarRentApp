package com.rentcar.app.service;

public interface CaptchaService {

    String verifyRecaptcha(String ip, String recaptchaResponse);
}

package com.rentcar.app.service.impl;

import com.rentcar.app.service.CaptchaService;
import com.rentcar.app.util.RecaptchaUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CaptchaServiceImpl implements CaptchaService {

    @Value("${google.recaptcha.key.secret}")
    String recaptchaSecret;

    private static final String GOOGLE_RECAPTCHA_VERIFY_URL = "https://www.google.com/recaptcha/api/siteverify";


    @Autowired
    RestTemplate restTemplate;

    @Override
    public String verifyRecaptcha(String ip, String recaptchaResponse) {
        Map<String, String> body = new HashMap<>();
        body.put("secret", recaptchaSecret);
        body.put("response", recaptchaResponse);
        body.put("remoteip", ip);
        ResponseEntity<Map> recaptchaResponseEntity =
                restTemplate.postForEntity(GOOGLE_RECAPTCHA_VERIFY_URL +
                                "?secret={secret}&response={response}&remoteip={remoteip}",
                        body, Map.class, body);


        Map<String, Object> responseBody =
                recaptchaResponseEntity.getBody();

        boolean recaptchaSucess = (Boolean) responseBody.get("success");
        if (!recaptchaSucess) {
            List<String> errorCodes =
                    (List) responseBody.get("error-codes");

            String errorMessage = errorCodes.stream()
                    .map(s -> RecaptchaUtil.RECAPTCHA_ERROR_CODE.get(s))
                    .collect(Collectors.joining(", "));

            return errorMessage;
        } else {
            return StringUtils.EMPTY;
        }
    }
}

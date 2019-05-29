package com.spring.auth.config.prop;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("security")
public class SecurityProperties {

    private JWTProperties jwt;

    public JWTProperties getJWT() {
        return jwt;
    }

    public void setJWT(JWTProperties jwt) {
        this.jwt = jwt;
    }
}
package com.cooper.springbootsecurity;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author liaoshaojie
 * @creatdate 2019/2/18
 * @describe
 */
public class CustomPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());
    }
}

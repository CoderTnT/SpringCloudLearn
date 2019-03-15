package com.cooper.userservice.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author liaoshaojie
 * @creatdate 2019/3/11
 * @describe
 */
public class BPwdEncoderUtils {

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();


    //用 BCryptPasswordEncoder 加密
    public static String BCryptPassword(String password) {
        return encoder.encode(password);
    }

    /**
     *@describe
     *@params [rawPassword (原始密码), encodedPassword （加密后的密码）]
     *@return boolean
     *@author liaoshaojie
     *@createdate 2019/3/11
     *@others
     */
    public static boolean matches(CharSequence rawPassword, String encodedPassword) {
        return encoder.matches(rawPassword, encodedPassword);

    }


}

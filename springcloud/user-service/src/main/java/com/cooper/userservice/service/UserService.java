package com.cooper.userservice.service;

import com.cooper.common.dto.RespDTO;
import com.cooper.common.exception.CommonException;
import com.cooper.common.exception.ErrorCode;
import com.cooper.userservice.client.AuthServiceClient;
import com.cooper.userservice.dao.UserDao;
import com.cooper.userservice.dto.LoginDTO;
import com.cooper.userservice.entity.JWT;
import com.cooper.userservice.entity.User;
import com.cooper.userservice.util.BPwdEncoderUtils;
import com.sun.javaws.exceptions.ErrorCodeResponseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liaoshaojie
 * @creatdate 2019/2/22
 * @describe
 */
@Service
public class UserService {

    @Autowired
    UserDao userDao;


    @Autowired
    AuthServiceClient authServiceClient;

    public RespDTO login(String username, String password) {

        User user = userDao.findByUsername(username);

        if (null == user) {
            throw new CommonException(ErrorCode.USER_NOT_FOUND);
        }

        if (!BPwdEncoderUtils.matches(password, user.getPasssword())) {
            throw new CommonException(ErrorCode.USER_PASSWORD_ERROR);
        }

        JWT jwt = authServiceClient.getToken("", "", username, password);

        if (null == jwt) {
            throw new CommonException(ErrorCode.GET_TOKEN_FAIL);
        }

        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setUser(user);
        loginDTO.setToken(jwt.getAccess_token());
        return RespDTO.onSuc(loginDTO);

    }

}

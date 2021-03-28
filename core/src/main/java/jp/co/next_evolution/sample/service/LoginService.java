package jp.co.next_evolution.sample.service;

import jp.co.next_evolution.sample.common.ActionResult;
import jp.co.next_evolution.sample.common.MessageKey;
import jp.co.next_evolution.sample.config.AppConfig;
import jp.co.next_evolution.sample.dto.LoginUser;
import jp.co.next_evolution.sample.mapper.db01.UserMapper;
import jp.co.next_evolution.sample.request.LoginRequest;
import jp.co.next_evolution.sample.response.ApiResponse;
import jp.co.next_evolution.sample.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class LoginService extends ServiceBase {

    @Autowired
    AppConfig appConfig;

    @Autowired
    UserMapper userMapper;

    public ApiResponse<?> login(LoginRequest loginRequest) throws Exception {
        // validation
        List<String> errorMessageList = new ArrayList<>();
        if (!StringUtils.hasText(loginRequest.getEmailAddress())) {
            errorMessageList.add(appConfig.getMessage(MessageKey.VALIDATION_EMPTY, "emailAddress"));
        }
        if (!StringUtils.hasText(loginRequest.getLoginPassword())) {
            errorMessageList.add(appConfig.getMessage(MessageKey.VALIDATION_EMPTY, "loginPassword"));
        }
        if (!CollectionUtils.isEmpty(errorMessageList)) {
            return ApiResponse.builder()
                              .returnCode(ActionResult.Error.getValue())
                              .errorMessage(appConfig.getMessage(MessageKey.LOGIN_ERROR))
                              .body(errorMessageList)
                              .build();
        }

        // login
        LoginUser loginUser = userMapper.login(loginRequest.getEmailAddress(), loginRequest.getLoginPassword());
        if (ObjectUtils.isEmpty(loginUser)) {
            return ApiResponse.builder()
                              .returnCode(ActionResult.Error.getValue())
                              .errorMessage(appConfig.getMessage(MessageKey.LOGIN_ERROR))
                              .body(null)
                              .build();
        }

        loginUser.setAuthCode(getAesCryptString(String.format("%s%s", loginUser.getEmailAddress(), LocalDateTime.now().toString())));
        return ApiResponse.builder()
                          .returnCode(ActionResult.OK.getValue())
                          .errorMessage(null)
                          .body(LoginResponse.builder().loginUser(loginUser).build())
                          .build();
    }

}

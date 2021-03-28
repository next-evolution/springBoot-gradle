package jp.co.next_evolution.sample.api.controller;

import jp.co.next_evolution.sample.api.annotation.AuthExclude;
import jp.co.next_evolution.sample.common.ActionResult;
import jp.co.next_evolution.sample.dto.LoginUser;
import jp.co.next_evolution.sample.request.LoginRequest;
import jp.co.next_evolution.sample.response.ApiResponse;
import jp.co.next_evolution.sample.response.LoginResponse;
import jp.co.next_evolution.sample.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.Objects;

@RestController
@RequestMapping("/")
public class IndexController {

    @Autowired
    LoginService loginService;

//    @GetMapping("token")
//    @AuthExclude
//    public String token(HttpServletRequest request){
//        CsrfToken token = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
//        return token.getToken();
//    }

    @AuthExclude
    @PostMapping("login")
    public ApiResponse<?> login(@RequestBody LoginRequest loginRequest, HttpServletRequest httpServletRequest) throws Exception {
        ApiResponse<?> apiResponse = loginService.login(loginRequest);
        if (Objects.equals(ActionResult.OK.getValue(), apiResponse.getReturnCode())) {
            httpServletRequest.getSession().setAttribute(LoginUser.class.getName(), ((LoginResponse) apiResponse.getBody()).getLoginUser());
        }
        return apiResponse;
    }

    @AuthExclude
    @GetMapping("logout2")
    public ApiResponse<?> logout(HttpServletRequest httpServletRequest) {
        try {
            HttpSession httpSession = httpServletRequest.getSession();
            if (!ObjectUtils.isEmpty(httpSession)) {
                Enumeration<String> enum_session = httpSession.getAttributeNames();
                while (enum_session.hasMoreElements()) {
                    httpSession.removeAttribute(enum_session.nextElement());
                }
                httpSession.invalidate();
            }
            return ApiResponse.builder()
                              .returnCode(ActionResult.OK.getValue())
                              .errorMessage(null)
                              .body(null)
                              .build();
        } catch (Exception e) {
            throw e;
        }
    }

}

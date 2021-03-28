package jp.co.next_evolution.sample.api.controller;

import jp.co.next_evolution.sample.api.annotation.AuthExclude;
import jp.co.next_evolution.sample.common.ActionResult;
import jp.co.next_evolution.sample.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("error")
public class ErrorController {

    @RequestMapping("403")
    @AuthExclude
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    public ApiResponse<?> auth403(HttpServletRequest httpServletRequest) {
        return ApiResponse.builder()
                          .returnCode(ActionResult.Error.getValue())
                          .errorMessage("forbidden")
                          .body(null)
                          .build();
    }

    @RequestMapping("auth")
    @AuthExclude
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    public ApiResponse<?> authError(HttpServletRequest httpServletRequest) {
        return ApiResponse.builder()
                          .returnCode(ActionResult.Error.getValue())
                          .errorMessage("auth error")
                          .body(null)
                          .build();
    }
}

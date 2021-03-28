package jp.co.next_evolution.sample.api.controller;

import jp.co.next_evolution.sample.api.annotation.AuthExclude;
import jp.co.next_evolution.sample.common.ActionResult;
import jp.co.next_evolution.sample.dto.LoginUser;
import jp.co.next_evolution.sample.request.LoginRequest;
import jp.co.next_evolution.sample.response.ApiResponse;
import jp.co.next_evolution.sample.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/test")
public class TestController {


    @AuthExclude
    @RequestMapping("ok")
    public String ok(HttpServletRequest httpServletRequest){
        return "ok";
    }

    @RequestMapping("status403")
    public String status403(HttpServletRequest httpServletRequest){
        return "403";
    }

}

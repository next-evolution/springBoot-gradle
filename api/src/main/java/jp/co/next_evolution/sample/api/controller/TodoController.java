package jp.co.next_evolution.sample.api.controller;

import jp.co.next_evolution.sample.dto.LoginUser;
import jp.co.next_evolution.sample.dto.db02.Todo;
import jp.co.next_evolution.sample.response.ApiResponse;
import jp.co.next_evolution.sample.service.db02.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    TodoService todoService;

    @GetMapping
    public ApiResponse list(HttpServletRequest httpServletRequest) {
        LoginUser loginUser = (LoginUser) httpServletRequest.getSession().getAttribute(LoginUser.class.getName());
        return todoService.list(loginUser.getUserId());
    }

    @PostMapping("insert")
    public ApiResponse insert(Todo todo) {
        return todoService.insert(todo);
    }

    @PostMapping("update")
    public ApiResponse update(Todo todo) {
        return todoService.update(todo);
    }

    @PostMapping("delete")
    public ApiResponse delete(Todo todo) {
        return todoService.delete(todo);
    }

}

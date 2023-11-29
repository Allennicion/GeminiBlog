package com.gemini.geminiblog.controllers.backstage;


import com.gemini.geminiblog.model.json.LayuiTable;
import com.gemini.geminiblog.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户管理
 * @author zhangwj
 * @date 2022/10/19 9:42
 */
@Controller
@RequestMapping("/backstage/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/userIndex")
    public String userIndex() {
        return "/backstage/user/userIndex";
    }

    @PostMapping("/userList")
    @ResponseBody
    public LayuiTable userList() {
        return null;
    }
}

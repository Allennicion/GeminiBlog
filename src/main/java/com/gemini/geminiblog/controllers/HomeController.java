package com.gemini.geminiblog.controllers;

import com.gemini.geminiblog.model.json.LayuiTable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * 首页
 * @Author zhangWj
 * @Date 2022/9/26 13:57
 **/
@Controller
public class HomeController extends BaseController {



    @GetMapping(value = {"/index", "/"})
    public String index() {
        return "index";
    }

    @GetMapping("/home/console")
    public String console() {
        return "/home/console";
    }
}

package com.abc.monster.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/user")
public class SysUserController {

    private String prefix = "admin/user";

    @GetMapping()
    public String user() {
        return prefix+"/list";
    }


}

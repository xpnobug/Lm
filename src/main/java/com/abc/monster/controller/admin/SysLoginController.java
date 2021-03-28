package com.abc.monster.controller.admin;

import com.abc.monster.pojo.User;
import com.abc.monster.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class SysLoginController {

    @Autowired
    UserService userService;

    //登录页
    @GetMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response) {
        // 如果是Ajax请求，返回Json字符串。
        return "admin/login";
    }

    @PostMapping("/login")
    public String Login(String username, String password, HttpSession session) {
        User loginuser = userService.login(username, password);
        if (loginuser != null) {
            session.setMaxInactiveInterval(60);
            session.setAttribute("loginuser", loginuser);
            return "redirect:/admin";
        } else if (loginuser == null) {
            String msg = "用户信息已过期,请重新登陆";
            return "redirect:/login";
        } else {
            String msg = "账号或密码错误！";
            return "redirect:/login";
        }
    }

    //退出登录
    @RequestMapping("/loginout")
    public String loginout(HttpSession session) {
        session.removeAttribute("loginuser");
        return "redirect:/login";
    }
}
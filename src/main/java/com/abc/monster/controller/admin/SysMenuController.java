package com.abc.monster.controller.admin;


import com.abc.monster.pojo.Menu;
import com.abc.monster.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/admin/menu")
public class SysMenuController {

    private String prefix = "admin/menu";

    @Autowired
    private MenuService menuService;

    /*进入菜单管理*/
    @GetMapping()
    public String menu()
    {
        return prefix + "/menu";
    }

    /*@RequestMapping("/list")

    public String list(Menu menu , Model model) {
        //Long userId = ShiroUtils.getUserId();
        List<Menu> menuList = menuService.selectMenuAll();
        model.addAttribute("menu",menuList);
        return "admin/index";
    }*/

    @RequestMapping("/list")
    @ResponseBody
    public List<Menu> list(Menu menu , Model model) {
        //Long userId = ShiroUtils.getUserId();
        List<Menu> menuList = menuService.selectMenuAll();
        model.addAttribute("menu",menuList);
        return menuList;
    }
}

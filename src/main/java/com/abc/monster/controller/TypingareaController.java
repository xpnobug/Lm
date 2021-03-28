package com.abc.monster.controller;

import com.abc.monster.pojo.Typingarea;
import com.abc.monster.service.TypingareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/typing")
public class TypingareaController {

    @Autowired
    TypingareaService areaService;

    /*获取字动打字内容*/
    @RequestMapping("/list")
    @ResponseBody
    public List<Typingarea> typing(Model model){
        List<Typingarea> typing = areaService.selectTyping();

        return typing;
    }

}

package com.abc.monster.controller.admin;

import com.abc.monster.pojo.Channel;
import com.abc.monster.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/channel")
public class SysChannerController {
    private String prefix = "admin/channel";

    @Autowired
    ChannelService channelService;

    /*栏目管理*/
    @GetMapping()
    public String channel(){
        return prefix+"/list";
    }

    /*栏目列表*/
    @RequestMapping("/list")
    public String list(Model mmap) {
        List<Channel> channelList = channelService.selectChannel();
        mmap.addAttribute("channer", channelList);
        return "/admin/channel/list";
    }
}

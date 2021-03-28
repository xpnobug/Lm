package com.abc.monster.controller;

import com.abc.monster.pojo.Article;
import com.abc.monster.pojo.Channel;
import com.abc.monster.service.ArticleService;
import com.abc.monster.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ChannerController {

    @Autowired
    ChannelService channelService;

    /*笔记首页入口*/
    @RequestMapping("/index/bijifenlei")
    public String getlist( Model model){
        return "/biji/channel";
    }

    /*栏目列表*/
    @GetMapping("/biji")
    @ResponseBody
    public List<Channel> list(Model mmap) {
        List<Channel> channelList = channelService.selectChannel();
        mmap.addAttribute("channer", channelList);
        return channelList;
    }


}

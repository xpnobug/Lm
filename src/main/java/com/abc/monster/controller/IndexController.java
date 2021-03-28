package com.abc.monster.controller;

import com.abc.monster.pojo.Article;
import com.abc.monster.pojo.Channel;
import com.abc.monster.pojo.Projects;
import com.abc.monster.pojo.Typingarea;
import com.abc.monster.service.ArticleService;
import com.abc.monster.service.ChannelService;
import com.abc.monster.service.ProjectsService;
import com.abc.monster.service.TypingareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/index")
public class IndexController {

    @Autowired
    ChannelService channelService;

    /*
    * 进入前台页面
    * */
    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    /*笔记首页入口*/
    @RequestMapping("/biji")
    public String go(){
        return "biji";
    }



    /*
    * 进入文章页面
    * */
    @RequestMapping("/goArticle")
    public String goArticle(){
        return "article/goArticle";
    }

    /*
    * 进入作品文章页面
    * */
    @RequestMapping("/goProjects")
    public String goProjects(){
        return "article/goProjects";
    }

    /*
    * 进入评论页面
    * */
    @RequestMapping("/goComment")
    public String goComment(){
        return "comment/goComment";
    }

}

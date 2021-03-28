package com.abc.monster.controller;

import com.abc.monster.pojo.Article;

import com.abc.monster.service.ArticleService;
import com.abc.monster.service.ChannelService;
import com.abc.monster.util.MarkDownUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/art")
public class ArticleController {
    @Autowired
    ArticleService articleService;

    /*
     * 文章展示
     * */
    @RequestMapping("/postshow")
    @ResponseBody
    public List<Article> art(){
        List<Article> articles=articleService.selectArt();
        return articles;
    }

    /*
    * 获取文章单个对象
    * */
    @RequestMapping("/postinfo")
    public String artbyid(int id, Model model){
        Article article = articleService.selectArtById(id);
        String HTMLContent = MarkDownUtils.markdownToHtmlExtensitons(article.getContent());//MarkDown文本转成HTML文本
        article.setContent(HTMLContent);
        model.addAttribute("article",article);
        return "/article/goArticle";
    }




    /*根据id获取单个栏目笔记内容*/
    @GetMapping("/channel")
    @ResponseBody
    public List<Article> getlist(int channer, Model model){
        List<Article> articles=articleService.selchannel(channer);
        /*model.addAttribute("art",articles);*/
        /*List<Channel> channelList = channelService.selectChannel();
        model.addAttribute("channer", channelList);*/
        return articles;
    }
}

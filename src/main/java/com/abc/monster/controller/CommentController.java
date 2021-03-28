package com.abc.monster.controller;

import com.abc.monster.pojo.Comment;
import com.abc.monster.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;
import java.util.List;
import java.net.URL;
import java.net.URLConnection;
@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService commentService;

    /*
    * 获取评论
    * */
    @RequestMapping("/com")
    @ResponseBody
    public List<Comment> comments(){
        List<Comment> comments=commentService.selectCom();
        return comments;
    }

    /*
    * 添加
    * */
    @RequestMapping("/addCom")
    public String add(String author,String comment, String email,String img, String url) {
        Comment comments=new Comment(author,comment,email,url,img,new Date());
        comments.setImg("https://api.iyk0.com/qqimg?qq="+email);
        if (email != null){
            commentService.addCom(comments);
        }else {
            return "false";
        }
        return "comment/goComment";
    }
}

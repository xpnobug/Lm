package com.abc.monster.controller.admin;

import com.abc.monster.pojo.Article;
import com.abc.monster.pojo.Comment;
import com.abc.monster.service.CommentService;
import com.abc.monster.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/admin/comment")
public class SysCommentController {

    private String prefix = "admin/comment";

    @Autowired
    CommentService commentService;

    @GetMapping()
    public String index() {
        return prefix+"/list";
    }

    @GetMapping("/list")
    public List<Comment> list(ModelMap mmap){

        List<Comment> comlist= commentService.selectCom();
        mmap.put("comlist",comlist);
        return comlist;
    }
    /*留言分页展示*/
    @RequestMapping("/list")
    @ResponseBody
    public PageUtil<Comment> getPageAll(String pageindex, Model model){
        if (pageindex == null || "".equals(pageindex)){
            pageindex = "1";
        }
        if (Integer.parseInt(pageindex)<1){
            pageindex = "1";
        }
        PageUtil<Comment> pageUtil = new PageUtil<Comment>();
        pageUtil.setPageindex(Integer.parseInt(pageindex));
        pageUtil.setPagesize(5);
        commentService.getPageAll(pageUtil);
        model.addAttribute("pageUtil",pageUtil);
        return pageUtil;
    }


    @RequestMapping("/delCom")
    @ResponseBody
    public boolean delcom(int id){
        return commentService.delCom(id);
    }
}

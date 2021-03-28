package com.abc.monster.controller.admin;

import com.abc.monster.pojo.Article;
import com.abc.monster.pojo.Channel;
import com.abc.monster.service.ArticleService;
import com.abc.monster.service.ChannelService;
import com.abc.monster.util.Constants;
import com.abc.monster.util.PageSupport;
import com.abc.monster.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin/post")
public class SysArticleController {

    private String prefix = "admin/post";

    @Autowired
    ArticleService articleService;

    @Autowired
    ChannelService channelService;

    //post入口
    @GetMapping()
    public String post(){
        return prefix+"/list";
    }

    /*
     * 文章展示
     * */
    //@GetMapping("/list")
    public List<Article> art(ModelMap mmap){
        List<Article> posts=articleService.selectArt();
        mmap.put("posts",posts);
        return posts;
    }

    /*文章分页展示*/
    //@GetMapping("/list")
   // @ResponseBody
    public PageUtil<Article> getPageAll(String pageindex, Model model){
        if (pageindex == null || "".equals(pageindex)){
            pageindex = "1";
        }
        if (Integer.parseInt(pageindex)<1){
            pageindex = "1";
        }
        PageUtil<Article> pageUtil = new PageUtil<Article>();
        pageUtil.setPageindex(Integer.parseInt(pageindex));
        pageUtil.setPagesize(5);
        articleService.getPageAll(pageUtil);
        model.addAttribute("pageUtil",pageUtil);
        model.addAttribute("page",pageUtil.getCounts());
        return pageUtil;
    }

    @RequestMapping(value="/likepost")
    public String getArtList(Model model,
                              @RequestParam(value="queryTitle",required=false) String queryTitle,
                              @RequestParam(value="queryChanner",required=false) String queryChanner,
                              @RequestParam(value="pageIndex",required=false) String pageIndex) throws Exception {

        int _queryChanner = 0;
        List<Article> userList = null;
        //设置页面容量
        int pageSize = Constants.pageSize;
        //当前页码
        int currentPageNo = 1;

        if(queryTitle == null){
            queryTitle = "";
        }
        if(queryChanner != null && !queryChanner.equals("")){
            _queryChanner = Integer.parseInt(queryChanner);
        }

        if(pageIndex != null){
            try{
                currentPageNo = Integer.valueOf(pageIndex);
            }catch(NumberFormatException e){
                return "redirect:/user/syserror.html";
                //response.sendRedirect("syserror.jsp");
            }
        }
        //总数量（表）
        int totalCount	= articleService.getArtCount(queryTitle,_queryChanner);
        //总页数
        PageSupport pages=new PageSupport();
        pages.setCurrentPageNo(currentPageNo);
        pages.setPageSize(pageSize);
        pages.setTotalCount(totalCount);
        int totalPageCount = pages.getTotalPageCount();
        //控制首页和尾页
        if(currentPageNo < 1){
            currentPageNo = 1;
        }else if(currentPageNo > totalPageCount){
            currentPageNo = totalPageCount;
        }
        userList = articleService.getArtList(queryTitle,_queryChanner,currentPageNo,pageSize);
        model.addAttribute("userList", userList);
        List<Channel> chanList = null;
        chanList = channelService.selectChannel();
        model.addAttribute("channer", chanList);
        model.addAttribute("queryTitle", queryTitle);
        model.addAttribute("queryChanner", queryChanner);
        model.addAttribute("totalPageCount", totalPageCount);
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("currentPageNo", currentPageNo);
        return "admin/post/list";
    }

    /*
    * 添加页面显示栏目选择
    * */
    @GetMapping(value="/view")
    public String getChanner(Model model,
                             @RequestParam(value="queryTitle",required=false) String queryTitle,
                             @RequestParam(value="queryChanner",required=false) String queryChanner,
                             @RequestParam(value="pageIndex",required=false) String pageIndex) throws Exception {


        List<Channel> chanList = null;
        chanList = channelService.selectChannel();
        model.addAttribute("channer", chanList);
        model.addAttribute("queryChanner", queryChanner);

        return "admin/post/view";
    }


    /*
    * 获取文章单个对象
    * */
    @RequestMapping("/postinfo")
    public String artbyid(int id, Model model){
        Article article = articleService.selectArtById(id);
        model.addAttribute("article",article);
        return "/article/goArticle";
    }


    // 跳转到文章编辑方法
    @RequestMapping("/view")
    public String postview(){
        return "/admin/post/view";
    }
    //添加文章
    @RequestMapping("/artadd")
    public String add(String title, String present, String content, int queryChanner){
        Article article=new Article(title,present,content,queryChanner,new Date());
        articleService.addArticle(article);
        return "redirect:/admin/post/likepost";
    }


    /*
     * 修改页面显示栏目选择
     * */

    // 跳转到文章修改方法
    @RequestMapping("/selone")
    public String postupd(int a_id,Model model,@RequestParam(value="queryChanner",required=false) String queryChanner){
        List<Channel> chanList = null;
        chanList = channelService.selectChannel();
        model.addAttribute("channer", chanList);
        model.addAttribute("queryChanner", queryChanner);
        Article article = articleService.selectArtById(a_id);
        model.addAttribute("art",article);
        return "/admin/post/upd";
    }
    /*
     * 获取文章单个对象
     * *//*
    @RequestMapping("/selart")
    @ResponseBody
    public Article artselone(int id,ModelMap mmap){
        Article article = articleService.selectArtById(id);
        mmap.put("art",article);
        return article;
    }*/

    //修改
    @RequestMapping("/artupd")
    public String upd(int a_id,String title, String present, String content, int queryChanner){
        Article article=new Article(a_id,title,present,content,queryChanner,new Date());
        articleService.updArticle(article);
        return "redirect:/admin/post/likepost";//修改成功
    }

    /*//删除文章
    @RequestMapping("/del/{id}")
    @ResponseBody
    public boolean deleteArticle(@PathVariable int id){
        return articleService.delArticle(id);
    }*/

    //删除文章
    @RequestMapping("/del")
    @ResponseBody
    public boolean deleteArticle(int id){
        return articleService.delArticle(id);
    }
}

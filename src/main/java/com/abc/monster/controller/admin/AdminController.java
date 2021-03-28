/*
+--------------------------------------------------------------------------
|   Mblog [#RELEASE_VERSION#]
|   ========================================
|   Copyright (c) 2014, 2015 mtons. All Rights Reserved
|   http://www.mtons.com
|
+---------------------------------------------------------------------------
*/
package com.abc.monster.controller.admin;
import com.abc.monster.pojo.Article;
import com.abc.monster.pojo.Comment;
import com.abc.monster.pojo.Menu;
import com.abc.monster.service.ArticleService;
import com.abc.monster.service.CommentService;
import com.abc.monster.service.MenuService;
import com.abc.monster.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author langhsu
 *
 */
@Controller
public class AdminController {

	@Autowired
	ArticleService articleService;

	@Autowired
	CommentService commentService;

	@Autowired
	private MenuService menuService;

	//后台菜单列表
	@GetMapping("/admin")
	public String index(ModelMap mmap) {
		//获取菜单
		List<Menu> menus = menuService.selectMenuAll();
		mmap.put("menus", menus);

		return "/admin/index";
	}

	// 系统介绍
	/*模块列表总数*/
	@GetMapping("/system/main")
	public String getcount(Model model){
		PageUtil<Article> pageUtil = new PageUtil<Article>();
		PageUtil<Comment> comment = new PageUtil<Comment>();
		articleService.getPageAll(pageUtil);
		commentService.getPageAll(comment);

		model.addAttribute("page",pageUtil.getCounts());//笔记总数
		model.addAttribute("comment",comment.getCounts());//留言总数

		System.out.println("笔记总数:"+pageUtil.getCounts());
		System.out.println("留言总数:"+comment.getCounts());
		return "/admin/index-top";
	}

	// 切换主题
	@GetMapping("/system/switchSkin")
	public String switchSkin()
	{
		return "skin";
	}


}

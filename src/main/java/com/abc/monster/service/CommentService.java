package com.abc.monster.service;

import com.abc.monster.pojo.Article;
import com.abc.monster.pojo.Comment;
import com.abc.monster.util.PageUtil;

import java.util.List;

public interface CommentService {

    /*分页查询*/

    void getPageAll(PageUtil<Comment> pageUtil);

    /*
     * 显示所有评论
     * */
    List<Comment> selectCom();

    /*
     * 添加评论
     * */
    boolean addCom(Comment comment);

    /*
     * 删除评论
     * */
    boolean delCom(int id);

}

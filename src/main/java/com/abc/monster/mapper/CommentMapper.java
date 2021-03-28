package com.abc.monster.mapper;

import com.abc.monster.pojo.Article;
import com.abc.monster.pojo.Comment;
import com.abc.monster.util.PageUtil;

import java.util.List;

public interface CommentMapper {

    /*分页查询*/
    int getCount();
    List<Comment> getPageAll(PageUtil<Comment> pageUtil);

    /*
    * 显示所有评论
    * */
    List<Comment> selectCom();

    /*
    * 添加评论
    * */
    int addCom(Comment comment);

    /*
    * 删除评论
    * */
    int delCom(int id);

}

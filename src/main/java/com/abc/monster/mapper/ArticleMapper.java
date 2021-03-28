package com.abc.monster.mapper;

import com.abc.monster.pojo.Article;
import com.abc.monster.util.PageUtil;
import org.apache.ibatis.annotations.Param;

import java.sql.Connection;
import java.util.List;

public interface ArticleMapper {



    /*分页查询*/
    int getCount();
    List<Article> getPageAll(PageUtil<Article> pageUtil);

    /*
    * 获取文章列表
    * */
    List<Article> selectArt();

    /*根据id获取单个栏目内容*/
    List<Article> selchannel(int channer);

    /*
    * 根据id获取单个文章内容
    * */
    Article selectArtById(int id);

    /*
    * 添加文章
    * */
    int addArticle(Article article);

    /*
    * 修改
    * */
    int updArticle(Article article);

    /*
    * 删除
    * */
    int delArticle(int id);

    /*
    * 模糊查询
    * */
    List<Article> getArtList(Connection connection, @Param("title") String title, @Param("channer") int channer, @Param("currentPageNo")int currentPageNo, @Param("pageSize") int pageSize)throws Exception;

    int getArtCount(Connection connection,@Param("title") String title,@Param("channer") int channer)throws Exception;
}

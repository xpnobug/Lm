package com.abc.monster.service;

import com.abc.monster.pojo.Article;
import com.abc.monster.util.PageUtil;

import java.util.List;

public interface ArticleService
{


    /*分页查询*/

    void getPageAll(PageUtil<Article> pageUtil);


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
    boolean addArticle(Article article);

    /*
    * 修改
    * */

    boolean updArticle(Article article);

    /*
     * 删除
     * */
    boolean delArticle(int id);

    /*
    * 模糊查询
    * */
    List<Article> getArtList(String queryTitle,int queryChanner,int currentPageNo, int pageSize) throws Exception;
    int getArtCount(String queryTitle,int queryChanner) throws Exception;
}

package com.abc.monster.service.impl;

import com.abc.monster.mapper.ArticleMapper;
import com.abc.monster.pojo.Article;
import com.abc.monster.service.ArticleService;
import com.abc.monster.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService
{
    @Autowired
    ArticleMapper mapper;


    @Override
    public void getPageAll(PageUtil<Article> pageUtil) {
        int count=mapper.getCount();
        if (count>0){
            pageUtil.setCounts(count);
            if (pageUtil.getPageindex()>pageUtil.getPagecount()){
                pageUtil.setPageindex(pageUtil.getPagecount());
            }
            pageUtil.setList(mapper.getPageAll(pageUtil));
        }else {
            pageUtil.setList(new ArrayList<Article>());
        }
    }

    @Override
    public List<Article> selectArt() {
        return mapper.selectArt();
    }

    @Override
    public List<Article> selchannel(int channer) {
        return mapper.selchannel(channer);
    }

    @Override
    public Article selectArtById(int id) {
        return mapper.selectArtById(id);
    }

    @Override
    public boolean addArticle(Article article) {
       if (mapper.addArticle(article)>0){
           return true;
       }else {
           return false;
       }
    }

    @Override
    public boolean updArticle(Article article) {
        if (mapper.updArticle(article)>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean delArticle(int id) {
        if (mapper.delArticle(id) > 0){
            return true;
        }else {
            return false;
        }
    }

    /*模糊查询*/
    @Override
    public List<Article> getArtList(String queryTitle, int queryChanner, int currentPageNo, int pageSize) throws Exception {
        Connection connection = null;
        List<Article> userList = null;
        System.out.println("queryTitle ---- > " + queryTitle);
        System.out.println("queryChanner ---- > " + queryChanner);
        System.out.println("currentPageNo ---- > " + currentPageNo);
        System.out.println("pageSize ---- > " + pageSize);
        userList = mapper.getArtList(connection, queryTitle,queryChanner,currentPageNo,pageSize);
        return userList;
    }

    @Override
    public int getArtCount(String queryTitle, int queryChanner) throws Exception {
        Connection connection = null;
        int count = 0;
        System.out.println("queryTitle ---- > " + queryTitle);
        System.out.println("queryChanner ---- > " + queryChanner);
        count = mapper.getArtCount(connection, queryTitle,queryChanner);
        return count;
    }

}

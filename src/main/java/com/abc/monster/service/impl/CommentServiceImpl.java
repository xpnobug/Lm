package com.abc.monster.service.impl;

import com.abc.monster.mapper.CommentMapper;
import com.abc.monster.pojo.Article;
import com.abc.monster.pojo.Comment;
import com.abc.monster.service.CommentService;
import com.abc.monster.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper mapper;

    @Override
    public void getPageAll(PageUtil<Comment> pageUtil) {
        int count=mapper.getCount();
        if (count>0){
            pageUtil.setCounts(count);
            if (pageUtil.getPageindex()>pageUtil.getPagecount()){
                pageUtil.setPageindex(pageUtil.getPagecount());
            }
            pageUtil.setList(mapper.getPageAll(pageUtil));
        }else {
            pageUtil.setList(new ArrayList<Comment>());
        }
    }

    @Override
    public List<Comment> selectCom() {
        return mapper.selectCom();
    }

    @Override
    public boolean addCom(Comment comment) {
        if (mapper.addCom(comment) > 0) {
            return true;
        }
        return false;
    }


    @Override
    public boolean delCom(int id) {
        if (mapper.delCom(id) > 0) {
            return true;
        }
        return false;
    }
}

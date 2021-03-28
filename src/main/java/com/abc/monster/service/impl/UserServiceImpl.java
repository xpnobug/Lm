package com.abc.monster.service.impl;

import com.abc.monster.mapper.UserMapper;
import com.abc.monster.pojo.User;
import com.abc.monster.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper mapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public User login(String username, String password) {
        return mapper.login(username, password);
    }

  /*  @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public void getPageAll(PageUtil pageUtil) {
        int count=mapper.getCount();
        if (count>0){
            pageUtil.setCounts(count);
            if (pageUtil.getPageindex()>pageUtil.getPagecount()){
                pageUtil.setPageindex(pageUtil.getPagecount());
            }
            pageUtil.setList(mapper.getPageAll(pageUtil));
        }else {
            pageUtil.setList(new ArrayList<User>());
        }
    }

    @Override
    public boolean addUser(User user) {
        if (mapper.addUser(user)>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean delUser(int id) {
        if (mapper.delUser(id)>0){
            return true;
        }
        return false;
    }

    @Override
    public User selOne(int id) {
        return mapper.selOne(id);
    }

    @Override
    public boolean updUser(User user) {
        if (mapper.updUser(user)>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean updPwd(String password, int id) {
        if (mapper.updPwd(password, id)>0){
            return true;
        }
        return false;
    }*/
}

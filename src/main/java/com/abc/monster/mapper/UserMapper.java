package com.abc.monster.mapper;



import com.abc.monster.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    //登录
    User login(@Param("username") String username, @Param("password") String password);

    /*//分页
    int getCount();
    List<User> getPageAll(PageUtil pageUtil);

    //添加
    int addUser(User user);

    //删除
    int delUser(int id);

    //查找单个
    User selOne(int id);

    //修改
    int updUser(User user);


    //修改密码
    int updPwd(@Param("password") String password, @Param("id") int id);*/


}

package com.abc.monster.service;



import com.abc.monster.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserService {
    //登录
    User login(String username, String password);

  /*  //分页
    void getPageAll(PageUtil pageUtil);

    //添加
    boolean addUser(User user);

    //删除
    boolean delUser(int id);

    //查找单个
    User selOne(int id);

    //修改
    boolean updUser(User user);


    //修改密码
    boolean updPwd(String password, @Param("id") int id);*/


}

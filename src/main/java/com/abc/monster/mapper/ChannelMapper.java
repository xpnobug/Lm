package com.abc.monster.mapper;

import com.abc.monster.pojo.Channel;

import java.util.List;

public interface ChannelMapper {



    //获取栏目
    List<Channel> selectChannel();

    //添加栏目
    int addChanner(Channel channel);

    //修改
    int updChanner(Channel channel);

    //删除 (需要判断该栏目是否还有笔记)
    int delChanner(int id);

    //查单个
    Channel selChannerbyId(int id);
}

package com.abc.monster.service.impl;

import com.abc.monster.mapper.ChannelMapper;
import com.abc.monster.pojo.Channel;
import com.abc.monster.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelServiceImpl implements ChannelService {

    @Autowired
    ChannelMapper mapper;

    @Override
    public List<Channel> selectChannel() {
        return mapper.selectChannel();
    }
}

package com.abc.monster.service.impl;

import com.abc.monster.mapper.TypingareaMapper;
import com.abc.monster.pojo.Typingarea;
import com.abc.monster.service.TypingareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypingareaServiceImpl implements TypingareaService
{
    @Autowired
    TypingareaMapper typingareaMapper;


    @Override
    public Typingarea selectTyp() {
        return typingareaMapper.selectTyp();
    }

    @Override
    public List<Typingarea> selectTyping()
    {
        return typingareaMapper.selectTyping();
    }

    @Override
    public int updateTyping(Typingarea typingarea)
    {
        int num=typingareaMapper.updateTyping(typingarea);
        if (num > 0)
        {

        }
        return num;
    }
}

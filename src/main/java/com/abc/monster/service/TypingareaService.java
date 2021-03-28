package com.abc.monster.service;

import com.abc.monster.pojo.Typingarea;

import java.util.List;

public interface TypingareaService
{
    /**
     * 获取打字内容
     * @return
     */
    Typingarea selectTyp();

    List<Typingarea> selectTyping();

    /**
     * 修改打字内容
     */
    int updateTyping(Typingarea typingarea);
}

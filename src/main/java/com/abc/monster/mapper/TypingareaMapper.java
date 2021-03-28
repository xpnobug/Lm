package com.abc.monster.mapper;

import com.abc.monster.pojo.Typingarea;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TypingareaMapper
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

package com.abc.monster.service.impl;

import com.abc.monster.mapper.MenuMapper;
import com.abc.monster.pojo.Menu;
import com.abc.monster.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 菜单 业务层处理
 *
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> selectMenuAll() {
        return menuMapper.selectMenuAll();
    }
}

package com.abc.monster.service;

import com.abc.monster.pojo.Projects;

import java.util.List;

public interface ProjectsService {
    /**
     * 获取项目作品
     */
    Projects selectPro();

    /*
     * 获取项目集合
     * */
    List<Projects> selectPros();

    /*
     * 根据分类id
     * */
    Projects selectProById(int id);


    /*
    * 添加
    * */
    boolean addPro(Projects projects);

    /*
    * 修改
    * */
    boolean updPro(Projects projects);

}

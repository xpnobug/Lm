package com.abc.monster.service.impl;

import com.abc.monster.mapper.ProjectsMapper;
import com.abc.monster.pojo.Projects;
import com.abc.monster.service.ProjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectsServiceImpl implements ProjectsService {

    @Autowired
    ProjectsMapper mapper;

    @Override
    public Projects selectPro() {
        return mapper.selectPro();
    }

    @Override
    public List<Projects> selectPros() {
        return mapper.selectPros();
    }

    @Override
    public Projects selectProById(int id) {
        return mapper.selectProById(id);
    }

    @Override
    public boolean addPro(Projects projects) {
        if (mapper.addPro(projects)>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean updPro(Projects projects) {
        if (mapper.updPro(projects)>0){
            return true;
        }
        return false;
    }
}

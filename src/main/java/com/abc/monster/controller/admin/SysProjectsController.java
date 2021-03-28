package com.abc.monster.controller.admin;

import com.abc.monster.pojo.Projects;
import com.abc.monster.service.ProjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("admin/pro")
public class SysProjectsController {
    @Autowired
    ProjectsService proService;


    /*
     * 作品展示
     * */
    @RequestMapping("/proshow")
    @ResponseBody
    public List<Projects> pro(Model model){
        List<Projects> project=proService.selectPros();
        model.addAttribute("project",project);
        return project;
    }
    /*
     * 作品根据分类id展示
     * */
    @RequestMapping("/proid")
    public String pro(int t_id, Model model){
        Projects projects= (Projects) proService.selectProById(t_id);
        model.addAttribute("projects",projects);
        return "/article/goProjects";
    }
    /*
    * 添加
    * */

}

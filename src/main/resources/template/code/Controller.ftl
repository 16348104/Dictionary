package ${package}.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import ${package}.model.${model};
import ${package}.service.${model}Service;

@Controller
@RequestMapping("${model?lower_case}")
public class ${model}Controller extends BaseController {

    @Autowired
    private ${model}Service ${model?lower_case}Service;

    @RequestMapping("add")
    private String add(${model} ${model?lower_case}) {
        ${model?lower_case}Service.add(${model?lower_case});
        return "redirect:/${model?lower_case}/list";
    }

    @RequestMapping("remove/{id}")
    private String remove(@PathVariable("id") ${PK} id) {
        ${model?lower_case}Service.remove(id);
        return "redirect:/${model?lower_case}/list";
    }

    @RequestMapping("modify")
    private String modify(${model} ${model?lower_case}) {
        ${model?lower_case}Service.modify(${model?lower_case});
        return "redirect:/${model?lower_case}/list";
    }

    @RequestMapping("list")
    private String list() {
        getSession().setAttribute("list", ${model?lower_case}Service.list());
        return "redirect:/${model?lower_case}/list.jsp";
    }

    @RequestMapping("search/{id}")
    private String search(@PathVariable("id") ${PK} id) {
        getSession().setAttribute("${model?lower_case}", ${model?lower_case}Service.search(id));
        return "redirect:/${model?lower_case}/edit.jsp";
    }
}
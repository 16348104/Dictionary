package com.dict.util;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.StaticApplicationContext;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


/**
 * Created by Administrator on 2016/1/2.
 */
public class ComponentGenerator {

    private static final String ModelPath = "src/main/java/model/";
    private static final String SUFFIX = ".java";
    private static String modelname;
    private static Map<String,String> propertiesMap;

    public static void main(String[] args) throws IOException, TemplateException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        FreeMarkerConfigurer freeMarkerConfigurer = (FreeMarkerConfigurer) applicationContext.getBean("freemarker");
        Template template = freeMarkerConfigurer.getConfiguration().getTemplate("model.ftl");
        input();

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(ModelPath + modelname + SUFFIX));

        Map<String, Object> map = new HashMap<>();
        map.put("model", modelname);
        map.put("property", propertiesMap);
        template.process(map, bufferedWriter);
    }

    private static void input() {
        System.out.println("«Î ‰»Îmodelname£∫");
        modelname = new Scanner(System.in).nextLine();
        System.out.println("«Î ‰»Îproperties:");
        String[] properties = new Scanner(System.in).nextLine().split(", ");
        propertiesMap = new LinkedHashMap<>();
        for (String property : properties) {
            propertiesMap.put(property.split(" ")[0], property.split(" ")[1]);
        }


    }


}

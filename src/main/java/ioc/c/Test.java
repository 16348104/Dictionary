package ioc.c;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by xdx on 2015/12/19.
 */
public class Test {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    Business business = (Business) applicationContext.getBean("business");

}

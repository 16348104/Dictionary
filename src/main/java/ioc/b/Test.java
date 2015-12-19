package ioc.b;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by xdx on 2015/12/19.
 */
public class Test {
    public static void main(String[] args) {

        Business business = new Business(new FloppyWrite());
        business.write();
    }

}

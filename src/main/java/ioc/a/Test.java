package ioc.a;

/**
 * Created by xdx on 2015/12/19.
 */
public class Test {
    public static void main(String[] args) {
        Business business = new Business(new USB());
        business.write();
    }
}

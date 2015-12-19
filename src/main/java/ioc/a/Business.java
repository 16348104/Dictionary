package ioc.a;

/**
 * Created by xdx on 2015/12/19.
 * 高层应用类
 */
public class Business {
    private USB usb;

    public Business(USB usb) {
        this.usb = usb;
    }
    public void write(){
        usb.writetousd();
    }
}


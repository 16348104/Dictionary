package ioc.b;

/**
 * Created by xdx on 2015/12/19.
 */
public class UsbWrite implements DeviceWrite {
    @Override
    public void writetodevice() {
        System.out.println("save to usb......");

    }
}

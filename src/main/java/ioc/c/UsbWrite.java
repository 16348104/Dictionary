package ioc.c;

import ioc.c.DeviceWrite;

/**
 * Created by xdx on 2015/12/19.
 */
public class UsbWrite implements DeviceWrite {
    @Override
    public void writetodevice() {
        System.out.println("save to usb......");

    }
}

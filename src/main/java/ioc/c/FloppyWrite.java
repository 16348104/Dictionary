package ioc.c;

import ioc.c.DeviceWrite;

/**
 * Created by xdx on 2015/12/19.
 */
public class FloppyWrite implements DeviceWrite {
    @Override
    public void writetodevice() {
        System.out.println("save to floppy......");
    }
}

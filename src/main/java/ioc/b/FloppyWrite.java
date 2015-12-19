package ioc.b;

/**
 * Created by xdx on 2015/12/19.
 */
public class FloppyWrite implements DeviceWrite {
    @Override
    public void writetodevice() {
        System.out.println("save to floppy......");
    }
}

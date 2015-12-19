package ioc.b;

/**
 * Created by xdx on 2015/12/19.
 */
public class Business {
    private DeviceWrite deviceWrite;

    public Business(DeviceWrite deviceWrite) {
        this.deviceWrite = deviceWrite;
    }

    public void write() {
        deviceWrite.writetodevice();
    }
}

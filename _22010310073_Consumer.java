package _22010310073_BerkUyar_;

public class _22010310073_Consumer {
    private String name;
    private _22010310073_Kernel kernel;

    public _22010310073_Consumer(String name, _22010310073_Kernel kernel) {
        this.name = name;
        this.kernel = kernel;
    }
    

    public String getName() {
        return name;
    }

    public void read() {
        kernel.read(this);
    }
}

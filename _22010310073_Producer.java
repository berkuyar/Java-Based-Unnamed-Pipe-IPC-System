package _22010310073_BerkUyar_;

public class _22010310073_Producer {
    private String name;
    private _22010310073_Kernel kernel;

    public _22010310073_Producer(String name, _22010310073_Kernel kernel) {
        this.name = name;
        this.kernel = kernel;
    }

    public String getName() {
        return name;
    }
    

    public void write(String message) {
        kernel.write(this, message);
    }
}

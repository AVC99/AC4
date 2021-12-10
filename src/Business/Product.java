package Business;

public class Product {
    private String name;
    private int requiredWorkers;
    private long requiredWork;
    private long workDone;

    public Product(String name, int requiredWorkers, long requiredWork) {
        this.name = name;
        this.requiredWorkers = requiredWorkers;
        this.requiredWork = requiredWork;
        this.workDone=0;
    }

    public String getName() {
        return name;
    }

    public int getRequiredWorkers() {
        return requiredWorkers;
    }

    public void addWork(){
        workDone++;
    }

    public long getWorkDone() {
        return workDone;
    }

    public boolean isProductFinished(){
        return this.workDone >= this.requiredWork;
    }
    public long getRequiredWork() {
        return requiredWork;
    }
}

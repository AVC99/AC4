package Business;

import java.util.LinkedList;

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

    synchronized public void addWork(){
        workDone++;
    }

    public String showProgress(){
        double percentage;
        percentage=((float)workDone/requiredWork)*100;

        StringBuilder processlist= new StringBuilder();
        for (int i=0;i<20;i++){
            if (percentage>0){
                processlist.append("#");
            }else processlist.append("_");
            percentage-=5;
        }
        if(isProductFinished()) processlist.append(" (Done) ");

        return processlist.toString();
    }

    public boolean isProductFinished(){
        return requiredWork <= workDone;
    }
    public long getRequiredWork() {
        return requiredWork;
    }
}

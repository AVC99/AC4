package Business;

public class Product {
    private final String name;
    private final int requiredWorkers;
    private final long requiredWork;
    private long workDone;

    public Product(String name, int requiredWorkers, long requiredWork) {
        this.name = name;
        this.requiredWorkers = requiredWorkers;
        this.requiredWork = requiredWork;
        this.workDone=0;
    }

    /**
     * Getter of the product name
     * @return the product name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter of the required workers of the product
     * @return the required workers of the product
     */
    public int getRequiredWorkers() {
        return requiredWorkers;
    }

    /**
     * Function that adds work to the total work done and is synchronized
     */
    synchronized public void addWork(){
        workDone++;
    }

    /**
     * Function that builds a String of the product process
     * @return the built String of the product process
     */
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

    /**
     * Function that returns if the product has finished
     * @return if the product has finished or not
     */
    public boolean isProductFinished(){
        return requiredWork <= workDone;
    }

}

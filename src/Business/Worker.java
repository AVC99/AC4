package Business;



public class Worker implements Runnable {
    private Product product;
    private boolean continueWorking;

    public Worker(Product product) {
        this.product=product;
        this.continueWorking=true;
    }

    public Product getProduct() {
        return product;
    }

    private long getWork(){
       return this.product.getRequiredWork();

    }
    private long addWork(long actualWork){
        return actualWork+1;
    }

    public void stopWorking() {
        this.continueWorking = false;
    }

    @Override
   synchronized public void run() {
        while (!this.product.isProductFinished()&& continueWorking){
            this.product.addWork();
        }
    }
}

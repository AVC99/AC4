package Business;



public class Worker implements Runnable {
    private final Product product;
    private boolean continueWorking;

    public Worker(Product product) {
        this.product=product;
        this.continueWorking=true;
    }

    public void stopWorking() {
        this.continueWorking = false;
    }

    @Override
   synchronized public void run() {
        while (!this.product.isProductFinished() && continueWorking){
            this.product.addWork();
        }
    }
}

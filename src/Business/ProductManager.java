package Business;

import Persistance.ProductDAO;
import java.util.ArrayList;
import java.util.LinkedList;

public class ProductManager {
    private final ArrayList<Product> productList;
    private final LinkedList<Worker> workerLinkedList;

    public ProductManager(ProductDAO productDAO) {
        this.productList = productDAO.loadProducts();
        this.workerLinkedList=new LinkedList<>();
    }

    /**
     * Function that starts all the progress for the products by starting the workers
     */
    public void startProgress(){
        for (Product p: productList){
            for(int i=0; i<p.getRequiredWorkers(); i++){
              Worker worker = new Worker(p);
              workerLinkedList.add(worker);
                new Thread(worker).start();
            }
        }
    }

    /**
     * Function that stops all the workers
     */
    public void stopProgress(){
        for (Worker w: workerLinkedList){
            w.stopWorking();
        }
    }

    /**
     * Function that returns the list of products of the product manager
     * @return product list
     */
    public ArrayList<Product> getProductList() {
        return productList;
    }
}

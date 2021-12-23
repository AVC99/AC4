package Business;

import Persistance.ProductDAO;
import java.util.ArrayList;
import java.util.LinkedList;

public class ProductManager {
    private ArrayList<Product> productList;
    private LinkedList<Worker> workerLinkedList;

    public ProductManager(ProductDAO productDAO) {
        this.productList = productDAO.loadProducts();
        this.workerLinkedList=new LinkedList<>();
    }

    public void startProgress(){
        for (Product p: productList){
            //System.out.println(p.getName());
            for(int i=0; i<p.getRequiredWorkers(); i++){
              Worker worker = new Worker(p);
              workerLinkedList.add(worker);
                new Thread(worker).start();
            }
        }
    }
    public void stopProgress(){
        for (Worker w: workerLinkedList){
            w.stopWorking();
        }
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }
}

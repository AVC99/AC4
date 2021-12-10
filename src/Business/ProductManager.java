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

   synchronized public void calculateProgress(){
        for (Product p: productList){
            for(int i=0; i<p.getRequiredWorkers(); i++){
              Worker worker = new Worker(p);
              workerLinkedList.add(worker);
                new Thread(worker).start();
            }
        }
    }


}

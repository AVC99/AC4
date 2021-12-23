package Persistance;

import Business.Product;
import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private final Gson gson ;

    public ProductDAO(){
        this.gson= new Gson();
    }

    public ArrayList<Product> loadProducts(){
        Product[] products;
        ArrayList<Product> productList=new ArrayList<>();
        try{
            products=gson.fromJson(new FileReader("products.json"),Product[].class);
            productList.addAll(List.of(products));
        }catch (FileNotFoundException e){
            System.out.println("Error while loading the file");
            e.printStackTrace();
        }
        return productList;
    }

}

package Presentation;

import Business.Product;
import Business.ProductManager;


public class Controller {
    private final Menu menu;
    private  ProductManager productManager;

    public Controller(Menu menu, ProductManager productManager) {
        this.menu = menu;
        this.productManager = productManager;
    }

    synchronized public void run() {
        int option;
        System.out.println("hola");
        productManager.startProgress();
        do {
            menu.showMenu();
            option = menu.askForInteger("Enter an option: ");
            runOption(option);
        } while (option != 2);
    }

    private void runOption(int option){
        switch (option) {
            case 1 -> {
                 for (Product p: productManager.getProductList()){
                     this.menu.showTabulatedMessage(p.getName());
                     this.menu.showTabulatedMessage(p.showProgress());
                 }
            }
            case 2 -> exitMenu();
            default -> menu.showMessage("Wrong option. Enter a number from 1 to 2, both included");
        }
    }

    private void exitMenu() {
        menu.spacing();
        menu.showMessage("Stopping all workers... Bye!");
        productManager.stopProgress();

    }

}

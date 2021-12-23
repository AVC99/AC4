package Presentation;

import Business.Product;
import Business.ProductManager;


public class Controller {
    private final Menu menu;
    private final ProductManager productManager;

    public Controller(Menu menu, ProductManager productManager) {
        this.menu = menu;
        this.productManager = productManager;
    }

    /**
     * Function that starts the program and starts the worker threads
     */
    public void run() {
        int option;
        productManager.startProgress();
        do {
            menu.showMenu();
            option = menu.askForInteger("Enter an option: ");
            runOption(option);
        } while (option != 2);
    }

    /**
     * Function that runs the options that the user has chosen
     * @param option user election
     */
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

    /**
     * Function that ends the program and stops all the workers
     */
    private void exitMenu() {
        menu.spacing();
        menu.showMessage("Stopping all workers... Bye!");
        productManager.stopProgress();

    }

}

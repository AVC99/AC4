package Presentation;

import Business.ProductManager;


public class Controller {
    private final Menu menu;
    private  ProductManager productManager;

    public Controller(Menu menu, ProductManager productManager) {
        this.menu = menu;
        this.productManager = productManager;
    }

    public void run() {
        int option;
        do {
            menu.showMenu();
            option = menu.askForInteger("Enter an option: ");
            runOption(option);
        } while (option != 2);
    }

    private void runOption(int option){
        switch (option) {
            case 1 -> productManager.calculateProgress();
            case 2 -> exitMenu();
            default -> menu.showMessage("Wrong option. Enter a number from 1 to 4, both included");
        }
    }

    private void exitMenu() {
        menu.spacing();
        menu.showMessage("See you later, Faggot!");
    }

}

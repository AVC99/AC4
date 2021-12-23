import Business.ProductManager;
import Persistance.ProductDAO;
import Presentation.Controller;
import Presentation.Menu;

public class Main {
   synchronized public static void main(String[] args) {
        Menu menu = new Menu();
        ProductManager productManager = new ProductManager(new ProductDAO());

        Controller controller = new Controller(menu, productManager);
        controller.run();
    }
}
import Business.ProductManager;
import Persistance.ProductDAO;
import Presentation.Controller;
import Presentation.Menu;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        ProductManager pokeManager = new ProductManager(new ProductDAO());
        Controller controller = new Controller(menu, pokeManager);
        controller.run();
    }
}
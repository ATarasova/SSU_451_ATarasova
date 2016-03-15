import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by tarasovaAA on 01.03.2016.
 */

public class BasketMain implements Basket {
    ArrayList<String> products = new ArrayList<>();
    HashMap<String, Integer> hashMap = new HashMap<>();

    public void addProduct(String product, int quantity) {
        products.add(product);
        hashMap.put(product, quantity);
    }

    public void removeProduct(String product) {
        products.remove(products.indexOf(product));
        hashMap.remove(product);
    }

    public void updateProductQuantity(String product, int quantity) {
        hashMap.put(product, quantity);
    }

    public void clear() {
        products.clear();
        hashMap.clear();
    }

    public List<String> getProducts() {
        return products;
    }

    public int getProductQuantity(String product) {
        return hashMap.get(product);
    }
}
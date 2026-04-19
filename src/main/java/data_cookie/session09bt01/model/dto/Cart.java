package data_cookie.session09bt01.model.dto;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<String> products = new ArrayList<String>();

    public Cart() {
        this.products = products;
    }

    public List<String> getProducts() {
        return products;
    }

    public void setProducts(List<String> products) {
        this.products = products;
    }

    public void addProduct(String productId) {
        products.add(productId);
    }

    public int getSize() {
        return products.size();
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }
}

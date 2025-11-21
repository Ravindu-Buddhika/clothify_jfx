package service;

import javafx.collections.ObservableList;
import model.dto.ProductDTO;

public interface ProductService {
    public ObservableList<ProductDTO> getAllProducts();
    public void addproduct(ProductDTO productDTO);
    public void deleteProducts(String id);
    public void updateProducts(ProductDTO productDTO);
    public String getID();
}

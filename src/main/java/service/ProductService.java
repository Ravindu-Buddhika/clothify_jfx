package service;

import javafx.collections.ObservableList;
import model.dto.ProductDTO;
import model.entity.ProductEntity;

public interface ProductService {
    public ObservableList<ProductDTO> getAllProducts();
    public ProductEntity addproduct(ProductDTO productDTO);
}

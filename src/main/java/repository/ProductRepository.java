package repository;

import javafx.collections.ObservableList;
import model.dto.ProductDTO;
import model.entity.ProductEntity;

public interface ProductRepository {
    public ObservableList<ProductEntity> getAllProducts();
}

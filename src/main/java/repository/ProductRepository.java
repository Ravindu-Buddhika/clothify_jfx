package repository;

import javafx.collections.ObservableList;
import model.dto.ProductDTO;
import model.entity.ProductEntity;

import java.sql.SQLException;

public interface ProductRepository {
    public ObservableList<ProductEntity> getAllProducts();
    public int addproduct(ProductEntity productEntity) throws SQLException;
    public int deleteProduct(String id) throws SQLException;
    public int update(ProductEntity productEntity) throws SQLException;
    public String getLastOrder();
}

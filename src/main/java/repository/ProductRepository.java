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
    public ObservableList<ProductEntity> filterByTop() throws SQLException;
    public ObservableList<ProductEntity> filterByBottoms() throws SQLException;
    public ObservableList<ProductEntity> filterByFootware() throws SQLException;
    public ObservableList<ProductEntity> filterByAccsesories() throws SQLException;
    public ObservableList<ProductEntity> filterByMens() throws SQLException;
    public ObservableList<ProductEntity> filterByWomens() throws SQLException;
    public ObservableList<ProductEntity> filterByUnisexs() throws SQLException;
    ObservableList<ProductEntity> searchItems(String itemName) throws SQLException;
}

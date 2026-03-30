package service;

import javafx.collections.ObservableList;
import model.dto.ProductDTO;
import model.entity.ProductEntity;

import java.sql.SQLException;

public interface ProductService {
    public ObservableList<ProductDTO> getAllProducts();
    public void addproduct(ProductDTO productDTO);
    public void deleteProducts(String id);
    public void updateProducts(ProductDTO productDTO);
    public String getID();
    public ObservableList<ProductDTO> filterByTop();
    public ObservableList<ProductDTO> filterByBottoms();
    public ObservableList<ProductDTO> filterByFootware();
    public ObservableList<ProductDTO> filterByAccsesories();
    public ObservableList<ProductDTO> filterByMens();
    public ObservableList<ProductDTO> filterByWomens();
    public ObservableList<ProductDTO> filterByUnisex();
    ObservableList<ProductDTO> searchItems(String itemName);
}

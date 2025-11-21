package service.IMPL;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.dto.ProductDTO;
import model.entity.ProductEntity;
import repository.IMPL.ProductRepositoryIMPL;
import repository.ProductRepository;
import service.ProductService;

import java.sql.SQLException;

public class ProductServiceIMPL implements ProductService {
    ProductRepository repository;

    {
        try {
            repository = new ProductRepositoryIMPL();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ObservableList<ProductDTO> getAllProducts(){
        ObservableList<ProductEntity> allProducts=repository.getAllProducts();
        ObservableList<ProductDTO> products = FXCollections.observableArrayList();

        for (ProductEntity entity : allProducts) {
            ProductDTO dto = new ProductDTO(
                    entity.getCode(),
                    entity.getName(),
                    entity.getPrice(),
                    entity.getDis(),
                    entity.getCategory(),
                    entity.getGender(),
                    entity.getQtyOnHand(),
                    entity.getSupplierID()
            );
            products.add(dto);
        }


        return products;
    }
}

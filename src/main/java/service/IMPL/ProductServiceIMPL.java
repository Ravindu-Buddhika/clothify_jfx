package service.IMPL;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
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

    public void addproduct(ProductDTO productDTO){

        ProductEntity productEntity=new ProductEntity(
                productDTO.getCode(),
                productDTO.getName(),
                productDTO.getPrice(),
                productDTO.getDis(),
                productDTO.getCategory(),
                productDTO.getGender(),
                productDTO.getQtyOnHand(),
                productDTO.getSupplierID()
        );
        int status=repository.addproduct(productEntity);
        if(status==1){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Success");
            alert.setHeaderText("Product Added");
            alert.setContentText("Data inserted successfully!");

        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR); // or CONFIRMATION, WARNING, ERROR
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Failed to insert data. Please check the input and try again.");
            alert.showAndWait();
        }

    }
}

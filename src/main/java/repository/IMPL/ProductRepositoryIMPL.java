package repository.IMPL;

import database.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.dto.ProductDTO;
import model.entity.ProductEntity;
import repository.ProductRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRepositoryIMPL implements ProductRepository {
    ObservableList<ProductEntity> productList = FXCollections.observableArrayList();
    Connection connection= DBConnection.getInstance().getConnection();

    public ProductRepositoryIMPL() throws SQLException {
    }

    @Override
    public ObservableList<ProductEntity> getAllProducts() {
        PreparedStatement preparedStatement= null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM productentity");
            ResultSet resultSet=preparedStatement.executeQuery();

            while (resultSet.next()) {
                ProductEntity product = new ProductEntity();
                product.setCode(resultSet.getString("code"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getDouble("price"));
                product.setDis(resultSet.getInt("dis"));
                product.setCategory(resultSet.getString("category"));
                product.setGender(resultSet.getString("gender"));
                product.setQtyOnHand(resultSet.getInt("qtyOnHand"));
                product.setSupplierID(resultSet.getString("supplierID"));

                productList.add(product);
            }

            return productList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public int addproduct(ProductEntity productEntity) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO productentity (code, name, price, dis, category, gender, qtyOnHand, supplierID) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
            );

            preparedStatement.setString(1, productEntity.getCode());
            preparedStatement.setString(2, productEntity.getName());
            preparedStatement.setDouble(3, productEntity.getPrice());
            preparedStatement.setInt(4, productEntity.getDis());
            preparedStatement.setString(5, productEntity.getCategory());
            preparedStatement.setString(6, productEntity.getGender());
            preparedStatement.setInt(7, productEntity.getQtyOnHand());
            preparedStatement.setString(8, productEntity.getSupplierID());

            int status = preparedStatement.executeUpdate();
            return status;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

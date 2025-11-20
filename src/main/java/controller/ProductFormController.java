package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class ProductFormController {
    Stage stage=new Stage();

    @FXML
    private ToggleGroup catagoryGroups;

    @FXML
    private TableColumn<?, ?> colCatagory;

    @FXML
    private TableColumn<?, ?> colDiscount;

    @FXML
    private TableColumn<?, ?> colGender;

    @FXML
    private TableColumn<?, ?> colPrice;

    @FXML
    private TableColumn<?, ?> colProductCode;

    @FXML
    private TableColumn<?, ?> colProductName;

    @FXML
    private TableColumn<?, ?> colQuntityOnHand;

    @FXML
    private TableColumn<?, ?> colSupplier;

    @FXML
    private TableView<?> tblProduct;

    @FXML
    private ToggleGroup genderGroup;

    @FXML
    private RadioButton rbAccsesories;

    @FXML
    private RadioButton rbBottoms;

    @FXML
    private RadioButton rbFootware;

    @FXML
    private RadioButton rbMens;

    @FXML
    private RadioButton rbTops;

    @FXML
    private RadioButton rbUnisex;

    @FXML
    private RadioButton rbWomens;

    @FXML
    private TextField txtDiscount;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtProductCode;

    @FXML
    private TextField txtProductName;

    @FXML
    private TextField txtQuantity;

    @FXML
    private TextField txtSupplier;

    @FXML
    void OrdersClicked(MouseEvent event) {
        stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ordersForm.fxml"));
            Parent root = loader.load();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void TopsClicked(MouseEvent event) {

    }

    @FXML
    void accsesoriesClicked(MouseEvent event) {

    }

    @FXML
    void bottomsClicked(MouseEvent event) {

    }

    @FXML
    void btnClickedAdd(ActionEvent event) {

    }

    @FXML
    void btnClickedDelete(ActionEvent event) {

    }

    @FXML
    void btnClickedGenarateItemCode(ActionEvent event) {

    }

    @FXML
    void btnClickedUpdate(ActionEvent event) {

    }

    @FXML
    void clickedSingOut(ActionEvent event) {
        stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/loginform.fxml"));
            Parent root = loader.load();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void customersClicked(MouseEvent event) {
        stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/customersForm.fxml"));
            Parent root = loader.load();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void dashbodeClicked(MouseEvent event) {
        stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/adminDashbode.fxml"));
            Parent root = loader.load();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void footwearClicked(MouseEvent event) {

    }

    @FXML
    void inventoryClicked(MouseEvent event) {
        stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/productForm.fxml"));
            Parent root = loader.load();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void mensClicked(MouseEvent event) {

    }

    @FXML
    void orderClicked(MouseEvent event) {
        stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/PlaceOrderForm.fxml"));
            Parent root = loader.load();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void sherchByItemCode(KeyEvent event) {

    }

    @FXML
    void staffClicked(MouseEvent event) {
        stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/staffForm.fxml"));
            Parent root = loader.load();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void suppliesClicked(MouseEvent event) {
        stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/suppliersForm.fxml"));
            Parent root = loader.load();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void unisexClicked(MouseEvent event) {

    }

    @FXML
    void womensClicked(MouseEvent event) {

    }

}


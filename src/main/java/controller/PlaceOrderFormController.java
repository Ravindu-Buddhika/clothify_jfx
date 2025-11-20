package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class PlaceOrderFormController {
    Stage stage=new Stage();

    @FXML
    private TableView<?> tblCart;

    @FXML
    private TableView<?> tblProducts;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtContactNumber;

    @FXML
    private TextField txtCustomerID;

    @FXML
    private TextField txtCustomerName;

    @FXML
    private TextField txtDiscount;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtLoyaltyDis;

    @FXML
    private TextField txtLoyaltyPoints;

    @FXML
    private TextField txtNetTotal;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtProductID;

    @FXML
    private TextField txtProductName;

    @FXML
    private Spinner<?> txtQuantity;

    @FXML
    private TextField txtSearchbar;

    @FXML
    private TextField txtSearchbar1;

    @FXML
    void clickedBtnAdd(ActionEvent event) {

    }

    @FXML
    void clickedBtnCheckout(ActionEvent event) {

    }

    @FXML
    void clickedBtnClear(ActionEvent event) {

    }

    @FXML
    void clickedBtnDashbode(ActionEvent event) {
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
    void clickedBtnDelete(ActionEvent event) {

    }

    @FXML
    void searchCustomer(KeyEvent event) {

    }

    @FXML
    void searchcustomer(KeyEvent event) {

    }

}


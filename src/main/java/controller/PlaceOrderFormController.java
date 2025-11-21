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
import model.dto.AdminDTO;
import model.dto.CustomerDTO;
import model.dto.StaffDTO;
import service.CustomerService;
import service.IMPL.CustomerServiceIMPL;

import java.io.IOException;

public class PlaceOrderFormController {
    Stage stage=new Stage();
    AdminDTO adminDTO=null;
    StaffDTO staffDTO=null;
    CustomerService customerService=new CustomerServiceIMPL();

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
        if(adminDTO!=null){
            stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/adminDashbode.fxml"));
                Parent root = loader.load();
                stage.setScene(new Scene(root));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else {
            stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/staffDashbode.fxml"));
                Parent root = loader.load();
                stage.setScene(new Scene(root));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }



        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void clickedBtnDelete(ActionEvent event) {

    }

    @FXML
    void searchCustomer(KeyEvent event) {
        String number = txtContactNumber.getText();
        if (number.length() == 10) {
            CustomerDTO customer = customerService.searchCustomer(number);
            if (customer != null) {
                txtCustomerID.setText(customer.getId());
                txtCustomerName.setText(customer.getName());
                txtCity.setText(customer.getCity());
                txtEmail.setText(customer.getEmail());
                txtLoyaltyPoints.setText(String.valueOf(customer.getLoyalty()));
            }
        }

    }

    @FXML
    void searchItem(KeyEvent event) {

    }

    public void loadAdmin(AdminDTO admin){
        adminDTO=admin;
    }

    public void loadStaff(StaffDTO staff){
        staffDTO=staff;
    }

}


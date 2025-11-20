package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.dto.AdminDTO;

import java.io.IOException;

public class StaffFormController {
    Stage stage= new Stage();
    AdminDTO adminDTO=null;
    @FXML
    private ToggleGroup checkType;

    @FXML
    private RadioButton checkedAdmin;

    @FXML
    private RadioButton checkedStaff;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colID;

    @FXML
    private TableColumn<?, ?> colMobileNumber;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colUserID;

    @FXML
    private TableView<?> tblStaff;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtMobileNumber;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtStaff;

    @FXML
    private TextField txtUserName;

    @FXML
    void OrdersClicked(MouseEvent event) {
        stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/adminOrdersForm.fxml"));
            Parent root = loader.load();

            OrdersFormController ordersFormController=loader.getController();
            ordersFormController.loadAdmin(adminDTO);

            stage.setScene(new Scene(root));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void btnClickedAdd(ActionEvent event) {

    }

    @FXML
    void btnClickedDelete(ActionEvent event) {

    }

    @FXML
    void btnClickedGenarateICustomerCode(ActionEvent event) {

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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/adminCustomersForm.fxml"));
            Parent root = loader.load();

            CustomerFormController customerFormController=loader.getController();
            customerFormController.loadAdmin(adminDTO);

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

            AdminDashbodeController adminDashbodeController=loader.getController();
            adminDashbodeController.loadUser(adminDTO);

            stage.setScene(new Scene(root));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void inventoryClicked(MouseEvent event) {
        stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/adminProductForm.fxml"));
            Parent root = loader.load();

            ProductFormController productFormController=loader.getController();
            productFormController.loadAdmin(adminDTO);

            stage.setScene(new Scene(root));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void orderClicked(MouseEvent event) {
        stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/PlaceOrderForm.fxml"));
            Parent root = loader.load();

            PlaceOrderFormController placeOrderFormController=loader.getController();
            placeOrderFormController.loadAdmin(adminDTO);

            stage.setScene(new Scene(root));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void sherchByUserID(KeyEvent event) {

    }

    @FXML
    void staffClicked(MouseEvent event) {
        stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/adminStaffForm.fxml"));
            Parent root = loader.load();

            StaffFormController staffFormController=loader.getController();
            staffFormController.loadAdmin(adminDTO);

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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/AdminSuppliersForm.fxml"));
            Parent root = loader.load();

            SuppliersFormController suppliersFormController=loader.getController();
            suppliersFormController.loadAdmin(adminDTO);

            stage.setScene(new Scene(root));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setResizable(false);
        stage.show();
    }

    public void loadAdmin(AdminDTO admin){
        adminDTO=admin;
    }

}


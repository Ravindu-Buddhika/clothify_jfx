package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.dto.AdminDTO;
import model.dto.StaffDTO;

import java.io.IOException;

public class OrdersFormController {
    Stage stage=new Stage();
    AdminDTO adminDTO=null;
    StaffDTO staffDTO=null;

    @FXML
    private TableColumn<?, ?> colCustomerCity;

    @FXML
    private TableColumn<?, ?> colCustomerEmail;

    @FXML
    private TableColumn<?, ?> colCustomerID;

    @FXML
    private TableColumn<?, ?> colCustomerLoyalty;

    @FXML
    private TableColumn<?, ?> colCustomerMobile;

    @FXML
    private TableColumn<?, ?> colCustomerName;

    @FXML
    private TableColumn<?, ?> colDetailsDiscount;

    @FXML
    private TableColumn<?, ?> colDetailsPrice;

    @FXML
    private TableColumn<?, ?> colDetailsProductCode;

    @FXML
    private TableColumn<?, ?> colOrderCustomer;

    @FXML
    private TableColumn<?, ?> colOrderDate;

    @FXML
    private TableColumn<?, ?> colOrderId;

    @FXML
    private TableColumn<?, ?> colOrderTotal;

    @FXML
    private TableColumn<?, ?> coldDetailsQty;

    @FXML
    private TableView<?> tblCustomer;

    @FXML
    private TableView<?> tblOrder;

    @FXML
    private TableView<?> tblorderDetails;

    @FXML
    void OrdersClicked(MouseEvent event) {
        if(adminDTO!=null){
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
        }else {
            stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/staffOrdersForm.fxml"));
                Parent root = loader.load();

                OrdersFormController ordersFormController=loader.getController();
                ordersFormController.loadStaff(staffDTO);

                stage.setScene(new Scene(root));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        stage.setResizable(false);
        stage.show();
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
        if(adminDTO!=null){
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
        }else {
            stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/staffCustomersForm.fxml"));
                Parent root = loader.load();

                CustomerFormController customerFormController=loader.getController();
                customerFormController.loadStaff(staffDTO);

                stage.setScene(new Scene(root));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void dashbodeClicked(MouseEvent event) {
        if(adminDTO!=null){
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
        }else {
            stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/staffDashbode.fxml"));
                Parent root = loader.load();

                StaffDashbodeController staffDashbodeController=loader.getController();
                staffDashbodeController.loadUser(staffDTO);

                stage.setScene(new Scene(root));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void inventoryClicked(MouseEvent event) {
        if(adminDTO!=null){
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
        }else {
            stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/staffProductForm.fxml"));
                Parent root = loader.load();

                ProductFormController productFormController=loader.getController();
                productFormController.loadStaff(staffDTO);

                stage.setScene(new Scene(root));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
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
    void sherchBYOrderID(KeyEvent event) {

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

    public void loadStaff(StaffDTO staff){
        staffDTO=staff;
    }

}

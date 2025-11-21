package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.dto.AdminDTO;
import model.dto.CustomerDTO;
import model.dto.StaffDTO;
import service.CustomerService;
import service.IMPL.CustomerServiceIMPL;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CustomerFormController implements Initializable {
    Stage stage=new Stage();
    AdminDTO adminDTO=null;
    StaffDTO staffDTO=null;
    ObservableList<CustomerDTO> customers = FXCollections.observableArrayList();
    CustomerService service=new CustomerServiceIMPL();

    @FXML
    private TableColumn<?, ?> colCity;

    @FXML
    private TableColumn<?, ?> colCustomerCode;

    @FXML
    private TableColumn<?, ?> colCustomerName;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colLoyalty;

    @FXML
    private TableColumn<?, ?> colMobileNumber;

    @FXML
    private TableView<CustomerDTO> tblCustomer;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtCustomerID;

    @FXML
    private TextField txtCustomerName;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtLoyaltyPoints;

    @FXML
    private TextField txtMobileNumber;

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
    void btnClickedAdd(ActionEvent event) {
        service.addCustomer(new CustomerDTO(
                txtCustomerID.getText(),
                txtCustomerName.getText(),
                txtMobileNumber.getText(),
                txtEmail.getText(),
                txtCity.getText(),
                Integer.parseInt(txtLoyaltyPoints.getText())
        ));
        loadCustomers();
        clearFields();

    }

    @FXML
    void btnClickedDelete(ActionEvent event) {
        service.deleteCustomer(txtCustomerID.getText());
        loadCustomers();
        clearFields();
    }

    @FXML
    void btnClickedGenarateICustomerCode(ActionEvent event) {
        txtCustomerID.setText(service.getID());
    }

    @FXML
    void btnClickedUpdate(ActionEvent event) {
        service.updateCustomer(new CustomerDTO(
                txtCustomerID.getText(),
                txtCustomerName.getText(),
                txtMobileNumber.getText(),
                txtEmail.getText(),
                txtCity.getText(),
                Integer.parseInt(txtLoyaltyPoints.getText())
        ));
        loadCustomers();
        clearFields();
    }

    private void clearFields() {
        txtLoyaltyPoints.clear();
        txtMobileNumber.clear();
        txtCustomerID.clear();
        txtCity.clear();
        txtEmail.clear();
        txtCustomerName.clear();
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
    void sherchByItemCode(KeyEvent event) {

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colCustomerCode.setCellValueFactory(new PropertyValueFactory<>("id"));
        colCustomerName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colMobileNumber.setCellValueFactory(new PropertyValueFactory<>("mobileNumber"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        colLoyalty.setCellValueFactory(new PropertyValueFactory<>("loyalty"));

        loadCustomers();

        tblCustomer.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                txtCustomerID.setText(newVal.getId());
                txtCustomerName.setText(newVal.getName());
                txtMobileNumber.setText(newVal.getMobileNumber());
                txtEmail.setText(newVal.getEmail());
                txtCity.setText(newVal.getCity());
                txtLoyaltyPoints.setText(String.valueOf(newVal.getLoyalty()));
            }
        });

    }

    private void loadCustomers() {
        customers.clear();
        customers=service.getAllProducts();
        tblCustomer.setItems(customers);
    }
}

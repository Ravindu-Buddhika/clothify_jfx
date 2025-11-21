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
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import model.dto.AdminDTO;
import model.dto.CustomerDTO;
import model.dto.ProductDTO;
import model.dto.StaffDTO;
import service.CustomerService;
import service.IMPL.CustomerServiceIMPL;
import service.IMPL.ProductServiceIMPL;
import service.ProductService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PlaceOrderFormController implements Initializable {
    Stage stage=new Stage();
    AdminDTO adminDTO=null;
    StaffDTO staffDTO=null;
    CustomerService customerService=new CustomerServiceIMPL();
    ProductService productService=new ProductServiceIMPL();
    ObservableList<ProductDTO> items= FXCollections.observableArrayList();

    @FXML
    private TableColumn<?, ?> colCartDiscount;

    @FXML
    private TableColumn<?, ?> colItemCatagory;

    @FXML
    private TableColumn<?, ?> colCartName;

    @FXML
    private TableColumn<?, ?> colCartPrice;

    @FXML
    private TableColumn<?, ?> colCartQty;

    @FXML
    private TableColumn<?, ?> colItemCode;

    @FXML
    private TableColumn<?, ?> colItemDiscount;

    @FXML
    private TableColumn<?, ?> colItemName;

    @FXML
    private TableColumn<?, ?> colItemPrice;

    @FXML
    private TableColumn<?, ?> colqQtyOnHand;

    @FXML
    private TableView<?> tblCart;

    @FXML
    private TableView<ProductDTO> tblProducts;

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
        String itemName = txtSearchbar.getText();
        items.clear();

        items=productService.searchItems(itemName);
        tblProducts.setItems(items);
    }

    public void loadAdmin(AdminDTO admin){
        adminDTO=admin;
    }

    public void loadStaff(StaffDTO staff){
        staffDTO=staff;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colItemCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        colItemName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colItemCatagory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colqQtyOnHand.setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));
        colItemPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

//        tblItem.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
//            if (newVal != null) {
//                txtItemID.setText(newVal.getId());
//                txtItemName.setText(newVal.getName());
//                txtItemPrice.setText(String.valueOf(newVal.getPrice()));
//                Qty= newVal.getStock();
//            }
//        });

    }
}


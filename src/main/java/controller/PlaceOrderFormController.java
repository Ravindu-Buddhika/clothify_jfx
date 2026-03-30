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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import model.dto.*;
import service.*;
import service.IMPL.*;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class PlaceOrderFormController implements Initializable {
    Stage stage=new Stage();
    AdminDTO adminDTO=null;
    StaffDTO staffDTO=null;
    CustomerService customerService=new CustomerServiceIMPL();
    ProductService productService=new ProductServiceIMPL();
    OrderDetailsService orderDetailsService=new OrderDetailsServiceIMPL();
    OrderService orderService=new OrdersServiceIMPL();
    ObservableList<ProductDTO> items= FXCollections.observableArrayList();
    ObservableList<CartItemDTO> cartItems=FXCollections.observableArrayList();
    PlaceOrderService placeOrderService=new PlaceOrderServiceIMPL();

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
    private TableView<CartItemDTO> tblCart;

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
    private Spinner<Integer> txtQuantity;

    @FXML
    private TextField txtSearchbar;

    @FXML
    private TextField txtSearchbar1;

    @FXML
    void clickedBtnAdd(ActionEvent event) {
        LocalDate date = LocalDate.now();
        String formattedDate = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        if (txtSearchbar1.getText().isEmpty() ||
                txtProductID.getText().isEmpty() ||
                txtProductName.getText().isEmpty() ||
                txtDiscount.getText().isEmpty() ||
                txtPrice.getText().isEmpty() ||
                txtCustomerID.getText().isEmpty() ||
                txtQuantity.getValue() == null) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Incomplete Data");
            alert.setHeaderText("Missing Fields");
            alert.setContentText("Please fill all fields before adding to cart.");
            alert.showAndWait();
            return;
        }else{
            cartItems.add(new CartItemDTO(
                    orderDetailsService.getID(),
                    txtSearchbar1.getText(),
                    txtProductID.getText(),
                    txtProductName.getText(),
                    Integer.parseInt(txtDiscount.getText()),
                    getUnitPrice(txtPrice.getText(),txtQuantity.getValue()),
                    txtQuantity.getValue(),
                    formattedDate,
                    getTotal(),
                    txtCustomerID.getText()
            ));
            tblCart.setItems(cartItems);
            getTotal();
            clearFields();
        }
    }

    private Double getUnitPrice(String priceText, int qty) {
        try {
            double price = Double.parseDouble(priceText);
            int discount = Integer.parseInt(txtDiscount.getText());
            double total = price * qty;
            double discountAmount = total * discount / 100.0;
            return total - discountAmount;
        } catch (NumberFormatException e) {
            // Handle invalid number input
            return 0.0;
        }


    }

    private Double getTotal() {
        double netTotal=0.0;
        for (CartItemDTO cartItemDTO:cartItems){
            netTotal+=cartItemDTO.getPrice();
        }
        txtNetTotal.setText(String.valueOf(netTotal));
        return netTotal;
    }

    @FXML
    void clickedBtnCheckout(ActionEvent event) {
        placeOrderService.placeOrder(cartItems);
        cartItems.clear();
        clearFields();
    }

    @FXML
    void clickedBtnClear(ActionEvent event) {
        clearFields();
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
        cartItems.clear();
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

        tblProducts.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                txtProductID.setText(newVal.getCode());
                txtProductName.setText(newVal.getName());
                txtPrice.setText(String.valueOf(newVal.getPrice()));
                txtDiscount.setText(String.valueOf(newVal.getDis()));
            }
        });

        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);
        txtQuantity.setValueFactory(valueFactory);

        colCartName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        colCartQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colCartDiscount.setCellValueFactory(new PropertyValueFactory<>("dis"));
        colCartPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        txtSearchbar1.setText(orderService.getID());
    }

    public void clearFields() {
        txtPrice.clear();
        txtProductName.clear();
        txtProductID.clear();
        txtDiscount.clear();
        txtNetTotal.clear();
    }
}


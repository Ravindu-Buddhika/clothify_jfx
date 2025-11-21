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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.dto.AdminDTO;
import model.dto.ProductDTO;
import model.dto.StaffDTO;
import service.IMPL.ProductServiceIMPL;
import service.ProductService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProductFormController implements Initializable {
    Stage stage=new Stage();
    AdminDTO adminDTO=null;
    StaffDTO staffDTO=null;
    ObservableList<ProductDTO> item = FXCollections.observableArrayList();
    ProductService productService=new ProductServiceIMPL();

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
    private TableView<ProductDTO> tblProduct;

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

        String selectedGender = ((RadioButton) genderGroup.getSelectedToggle()).getText();
        String selectedCategory = ((RadioButton) catagoryGroups.getSelectedToggle()).getText();

        ProductDTO productDTO = new ProductDTO(
                txtProductCode.getText(),
                txtProductName.getText(),
                Double.parseDouble(txtPrice.getText()),
                Integer.parseInt(txtDiscount.getText()),
                selectedCategory,
                selectedGender,
                Integer.parseInt(txtQuantity.getText()),
                txtSupplier.getText()
        );

        productService.addproduct(productDTO);
        loadProducts();
        clearFields();
    }

    @FXML
    void btnClickedDelete(ActionEvent event) {
        productService.deleteProducts(txtProductCode.getText());
        loadProducts();
        clearFields();
    }

    @FXML
    void btnClickedGenarateItemCode(ActionEvent event) {
        txtProductCode.setText(productService.getID());
    }

    @FXML
    void btnClickedUpdate(ActionEvent event) {
        String selectedGender = ((RadioButton) genderGroup.getSelectedToggle()).getText();
        String selectedCategory = ((RadioButton) catagoryGroups.getSelectedToggle()).getText();
        ProductDTO productDTO = new ProductDTO(
                txtProductCode.getText(),
                txtProductName.getText(),
                Double.parseDouble(txtPrice.getText()),
                Integer.parseInt(txtDiscount.getText()),
                selectedCategory,
                selectedGender,
                Integer.parseInt(txtQuantity.getText()),
                txtSupplier.getText()
        );
        productService.updateProducts(productDTO);
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
    void footwearClicked(MouseEvent event) {

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
    void mensClicked(MouseEvent event) {

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

    @FXML
    void unisexClicked(MouseEvent event) {

    }

    @FXML
    void womensClicked(MouseEvent event) {

    }

    public void loadAdmin(AdminDTO admin){
        adminDTO=admin;
    }

    public void loadStaff(StaffDTO staff){
        staffDTO=staff;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colProductCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        colProductName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colDiscount.setCellValueFactory(new PropertyValueFactory<>("dis"));
        colCatagory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        colQuntityOnHand.setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));
        colSupplier.setCellValueFactory(new PropertyValueFactory<>("supplierID"));
        
        loadProducts();

        tblProduct.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                txtProductCode.setText(newVal.getCode());
                txtProductName.setText(newVal.getName());
                txtDiscount.setText(String.valueOf(newVal.getDis()));
                txtSupplier.setText(newVal.getSupplierID());
                txtQuantity.setText(String.valueOf(newVal.getQtyOnHand()));
                txtPrice.setText(String.valueOf(newVal.getPrice()));

                switch (newVal.getGender().toLowerCase()) {
                    case "men": rbMens.setSelected(true); break;
                    case "women": rbWomens.setSelected(true);break;
                    case "unisex": rbUnisex.setSelected(true); break;
                }
                switch (newVal.getCategory().toLowerCase()) {
                    case "Tops": rbTops.setSelected(true); break;
                    case "Bottoms": rbBottoms.setSelected(true); break;
                    case "Footware": rbFootware.setSelected(true); break;
                    case "Accsesories": rbAccsesories.setSelected(true); break;
                }

            }
        });
    }

    private void loadProducts() {
        item.clear();
        item=productService.getAllProducts();
        tblProduct.getItems().clear();
        tblProduct.setItems(item);
    }

    public void clearFields() {
        txtProductCode.clear();
        txtProductName.clear();
        txtDiscount.clear();
        txtSupplier.clear();
        txtQuantity.clear();
        txtPrice.clear();
        genderGroup.selectToggle(null);
        catagoryGroups.selectToggle(null);

    }
}


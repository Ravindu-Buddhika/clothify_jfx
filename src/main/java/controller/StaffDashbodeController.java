package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.dto.StaffDTO;
import service.DashbodeService;
import service.IMPL.DashbodeServiceIMPL;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StaffDashbodeController implements Initializable {
    StaffDTO staff=null;
    DashbodeService dashbodeService=new DashbodeServiceIMPL();
    Stage stage=new Stage();

    @FXML
    private Label countCustomers;

    @FXML
    private Label countItems;

    @FXML
    private Label countSells;

    @FXML
    private Label countStaff;

    @FXML
    private Label countSuppliers;

    @FXML
    void OrdersClicked(MouseEvent event) {
        stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/staffOrdersForm.fxml"));
            Parent root = loader.load();

            OrdersFormController ordersFormController=loader.getController();
            ordersFormController.loadStaff(staff);

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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/staffCustomersForm.fxml"));
            Parent root = loader.load();

            CustomerFormController customerFormController=loader.getController();
            customerFormController.loadStaff(staff);

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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/staffDashbode.fxml"));
            Parent root = loader.load();

            StaffDashbodeController staffDashbodeController=loader.getController();
            staffDashbodeController.loadUser(staff);

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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/staffProductForm.fxml"));
            Parent root = loader.load();

            ProductFormController productFormController=loader.getController();
            productFormController.loadStaff(staff);

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
            placeOrderFormController.loadStaff(staff);

            stage.setScene(new Scene(root));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setResizable(false);
        stage.show();
    }

    public void loadUser(StaffDTO staffDTO){
        staff=staffDTO;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        countCustomers.setText(String.valueOf(dashbodeService.countOfCustomers()));
        countItems.setText(String.valueOf(dashbodeService.countOfItems()));
        countSells.setText(String.valueOf(dashbodeService.countOfSells()));
        countStaff.setText(String.valueOf(dashbodeService.countOfStaff()));
        countSuppliers.setText(String.valueOf(dashbodeService.countOfSuppliers()));
    }
}


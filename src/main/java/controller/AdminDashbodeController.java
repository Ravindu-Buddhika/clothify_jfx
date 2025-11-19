package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import model.dto.AdminDTO;
import service.DashbodeService;
import service.IMPL.DashbodeServiceIMPL;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminDashbodeController implements Initializable {
    AdminDTO admin=null;
    DashbodeService dashbodeService=new DashbodeServiceIMPL();

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

    }

    @FXML
    void customersClicked(MouseEvent event) {

    }

    @FXML
    void dashbodeClicked(MouseEvent event) {

    }

    @FXML
    void inventoryClicked(MouseEvent event) {

    }

    @FXML
    void orderClicked(MouseEvent event) {

    }

    @FXML
    void staffClicked(MouseEvent event) {

    }

    @FXML
    void suppliesClicked(MouseEvent event) {

    }

    public void loadUser(AdminDTO adminDTO){
        admin=adminDTO;
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


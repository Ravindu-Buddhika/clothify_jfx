package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import model.dto.AdminDTO;
import model.dto.StaffDTO;
import service.DashbodeService;
import service.IMPL.DashbodeServiceIMPL;

import java.net.URL;
import java.util.ResourceBundle;

public class StaffDashbodeController implements Initializable {
    StaffDTO staff=null;
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


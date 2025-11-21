package service.IMPL;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import model.dto.CustomerDTO;
import model.entity.CustomerEntity;
import repository.CustomerRepository;
import repository.IMPL.CustomerRepositoryIMPL;
import service.CustomerService;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerServiceIMPL implements CustomerService {
    CustomerRepository customerRepository;

    {
        try {
            customerRepository = new CustomerRepositoryIMPL();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ObservableList<CustomerDTO> getAllProducts() {
        ObservableList<CustomerEntity> allCustomers = null;
        try {
            allCustomers = customerRepository.getAllCustomers();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ObservableList<CustomerDTO> customers = FXCollections.observableArrayList();

        for (CustomerEntity entity : allCustomers) {
            CustomerDTO dto = new CustomerDTO(
                    entity.getId(),
                    entity.getName(),
                    entity.getMobileNumber(),
                    entity.getEmail(),
                    entity.getCity(),
                    entity.getLoyalty()
            );
            customers.add(dto);
        }

        return customers;

    }

    @Override
    public void addCustomer(CustomerDTO customerDTO) {
        CustomerEntity customerEntity = new CustomerEntity(
                customerDTO.getId(),
                customerDTO.getName(),
                customerDTO.getMobileNumber(),
                customerDTO.getEmail(),
                customerDTO.getCity(),
                customerDTO.getLoyalty()
        );

        int status = 0;
        try {
            status = customerRepository.addCustomer(customerEntity);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (status == 1) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Success");
            alert.setHeaderText("Customer Added");
            alert.setContentText("Customer data inserted successfully!");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Insertion Failed");
            alert.setContentText("Failed to insert customer data. Please check the input and try again.");
            alert.showAndWait();
        }


    }

    @Override
    public void deleteCustomer(String id) {
        int status= 0;
        try {
            status = customerRepository.deleteCustomer(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if(status==1){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Success");
            alert.setHeaderText("Product Deleted");
            alert.setContentText("Deleted Successfully!");

        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR); // or CONFIRMATION, WARNING, ERROR
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Failed to delete data. Please check the input and try again.");
            alert.showAndWait();
        }
    }

    @Override
    public void updateCustomer(CustomerDTO customerDTO) {
        CustomerEntity customerEntity = new CustomerEntity(
                customerDTO.getId(),
                customerDTO.getName(),
                customerDTO.getMobileNumber(),
                customerDTO.getEmail(),
                customerDTO.getCity(),
                customerDTO.getLoyalty()
        );

        int status = 0;
        try {
            status = customerRepository.updateCustomer(customerEntity); // Ensure this method is defined
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (status == 1) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Success");
            alert.setHeaderText("Customer Updated");
            alert.setContentText("Customer data updated successfully!");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Update Failed");
            alert.setContentText("Failed to update customer data. Please check the input and try again.");
            alert.showAndWait();
        }

    }

    @Override
    public String getID() {
        String lastOrderId = null;
        try {
            lastOrderId = customerRepository.getLastOrder();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(lastOrderId);
        if (lastOrderId != null && lastOrderId.length() > 1) {
            String numericPart = lastOrderId.substring(1);
            int number = Integer.parseInt(numericPart);
            number++;
            String newOrderId = "C" + String.format("%03d", number);
            return newOrderId;
        } else {
            // First order case or error fallback
            return "P001";
        }
    }

    @Override
    public CustomerDTO searchCustomer(String name) {
        CustomerDTO customer = null;
        ResultSet resultSet = null;
        try {
            resultSet = customerRepository.searchCustomer(name);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            if (resultSet.next()) {
                customer = new CustomerDTO(
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getString("mobileNumber"),
                        resultSet.getString("email"),
                        resultSet.getString("city"),
                        resultSet.getInt("loyalty")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customer;
    }
}

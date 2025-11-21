package service;

import javafx.collections.ObservableList;
import model.dto.CustomerDTO;

public interface CustomerService {
    public ObservableList<CustomerDTO> getAllProducts();
    public void addCustomer(CustomerDTO customerDTO);
    public void deleteCustomer(String id);
    public void updateCustomer(CustomerDTO customerDTO);
    public String getID();
    public CustomerDTO searchCustomer(String name);

}

package peaksoft.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import peaksoft.model.Customer;
import peaksoft.services.CustomerServices;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CustomerServicesImpl implements CustomerServices {
    @Override
    public void saveCustomer(Customer customer) {

    }

    @Override
    public List<Customer> getAllCustomers(String word) {
        return null;
    }

    @Override
    public Customer getCustomerById(Long id) {
        return null;
    }

    @Override
    public void updateCustomerById(Long id, Customer customer) {

    }

    @Override
    public void deleteCustomerById(Long id) {

    }

    @Override
    public List<Customer> searchCustomer(String word) {
        return null;
    }
}

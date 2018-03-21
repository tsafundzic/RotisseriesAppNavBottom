package com.tsafundzic.rotisseriesappnavbottom.data;

import com.tsafundzic.rotisseriesappnavbottom.model.Customer;
import com.tsafundzic.rotisseriesappnavbottom.model.Product;
import com.tsafundzic.rotisseriesappnavbottom.model.ProductAmount;
import com.tsafundzic.rotisseriesappnavbottom.model.Worker;

import java.util.ArrayList;
import java.util.List;

import static com.tsafundzic.rotisseriesappnavbottom.data.Data.createCustomers;
import static com.tsafundzic.rotisseriesappnavbottom.data.Data.createProducts;
import static com.tsafundzic.rotisseriesappnavbottom.data.Data.createWorkers;

/**
 * Created by cobe on 16/03/2018.
 */

public class DataHolder {


    private static final DataHolder instance = new DataHolder();

    private DataHolder() {
    }

    private static final List<Product> products = createProducts();
    private static final List<Worker> workers = createWorkers();
    private static final List<Customer> customers = createCustomers();
    private static final List<ProductAmount> productAmounts = new ArrayList<>();

    public static DataHolder getInstance() {
        return instance;
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public List<ProductAmount> getProductAmounts(){
        return productAmounts;
    }

    public void addNewCustomer(Customer customer) {
        customers.add(customer);
    }

    public Customer getCustomerBasedOnCustomerID(int customerID) {
        Customer loggedCustomer = null;
        for (Customer customer : customers) {
            if (customer.getId() == customerID) {
                loggedCustomer = customer;
            }
        }
        return loggedCustomer;
    }

    public int getLastProductID() {
        Product product = products.get(getProductSize() - 1);
        return product.getProductID();
    }

    public double returnCurrentCustomerBalance(Customer customer) {
        return customer.getBalance();
    }

    public void setCustomerBalance(Customer customer, double customerBalance){
        customer.setBalance(customerBalance);
    }


    public void addProduct(Product product) {
        products.add(product);
    }

    public void addNewWorker(Worker newWorker) {
        workers.add(newWorker);
    }

    public int getCustomersSize() {
        return customers.size();
    }

    public int getWorkerSize() {
        return workers.size();
    }

    public int getProductSize() {
        return products.size();
    }

}

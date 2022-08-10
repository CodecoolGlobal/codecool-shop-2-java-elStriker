package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.OrderDao;
import com.codecool.shop.model.Product;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;
import com.codecool.shop.model.dto.CheckOutDto;
import com.codecool.shop.model.dto.PaymentDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class OrderDaoMem implements OrderDao {

    private List<Product> data = new ArrayList<>();

    private CheckOutDto checkOutData;

    private PaymentDto paymentData;

    private static OrderDaoMem instance = null;

    /* A private Constructor prevents any other class from instantiating.
     */
    private OrderDaoMem() {
    }

    public static OrderDaoMem getInstance() {
        if (instance == null) {
            instance = new OrderDaoMem();
        }
        return instance;
    }

    @Override
    public CheckOutDto getCheckOutData() {return this.checkOutData;}

    @Override
    public PaymentDto getPaymentData() {return this.paymentData;}

    @Override
    public void setCheckOutData(CheckOutDto checkOutData) {
        this.checkOutData = checkOutData;
    }

    @Override
    public void setPaymentData(PaymentDto paymentData) {
        this.paymentData = paymentData;
    }

    @Override
    public int getNumberOfProducts(Product product) {
        int numberOfProducts = data.stream().filter(p -> p.equals(product)).collect(Collectors.toList()).size();
        return numberOfProducts;
    }

    public double getTotalPrice() {
        double totalPrice = data.stream().map(p -> p.getDefaultPrice()).mapToDouble(p -> p.doubleValue()).sum();
        return totalPrice;
    }

    @Override
    public void add(Product product) {
        data.add(product);
    }

    @Override
    public Product find(int id) {
        return data.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void remove(int id) {
        data.remove(find(id));
    }

    @Override
    public void removeAll(Product product) {
        data = data.stream().filter(t -> t.getId() != product.getId()).collect(Collectors.toList());
    }

    @Override
    public List<Product> getAll() {
        return data;
    }

    @Override
    public List<Product> getBy(Supplier supplier) {
        return data.stream().filter(t -> t.getSupplier().equals(supplier)).collect(Collectors.toList());
    }

    @Override
    public List<Product> getBy(ProductCategory productCategory) {
        return data.stream().filter(t -> t.getProductCategory().equals(productCategory)).collect(Collectors.toList());
    }

}

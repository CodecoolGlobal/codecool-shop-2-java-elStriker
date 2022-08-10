package com.codecool.shop.dao;

import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;
import com.codecool.shop.model.dto.CheckOutDto;
import com.codecool.shop.model.dto.PaymentDto;

import java.util.List;

public interface OrderDao {

    void setCheckOutData(CheckOutDto checkOutData);

    void setPaymentData(PaymentDto paymentData);

    int getNumberOfProducts(Product product);

    double getTotalPrice();
    void add(Product product);
    Product find(int id);
    void remove(int id);

    void removeAll(Product product);

    List<Product> getAll();
    List<Product> getBy(Supplier supplier);
    List<Product> getBy(ProductCategory productCategory);


}

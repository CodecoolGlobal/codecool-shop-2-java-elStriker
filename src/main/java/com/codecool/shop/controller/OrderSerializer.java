package com.codecool.shop.controller;


import com.codecool.shop.dao.implementation.OrderDaoMem;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;
import com.google.gson.*;

import java.lang.reflect.Type;


public class OrderSerializer implements JsonSerializer<OrderDaoMem> {
    @Override
    public JsonElement serialize(OrderDaoMem cart, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonOrder = new JsonObject();

        GsonBuilder gsonBuilder = new GsonBuilder();

        gsonBuilder.registerTypeAdapter(ProductCategory.class, new ProductCategorySerializer());
        gsonBuilder.registerTypeAdapter(Supplier.class, new SupplierSerializer());

        Gson gson = gsonBuilder.create();

        jsonOrder.addProperty("products", gson.toJson(cart.getAll()));
        jsonOrder.addProperty("customer", gson.toJson(cart.getCheckOutData()));
        jsonOrder.addProperty("payment", gson.toJson(cart.getPaymentData()));


        return jsonOrder;

    }
}

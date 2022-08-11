package com.codecool.shop.controller;

import com.codecool.shop.dao.implementation.OrderDaoMem;
import com.codecool.shop.model.ProductCategory;
import com.google.gson.*;

import java.lang.reflect.Type;

public class ProductCategorySerializer implements JsonSerializer<ProductCategory> {
    @Override
    public JsonElement serialize(ProductCategory productCategory, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonProductCategory = new JsonObject();
        jsonProductCategory.addProperty("department", productCategory.getDepartment());
        jsonProductCategory.addProperty("id", productCategory.getId());

        return jsonProductCategory;

    }

}

package com.codecool.shop.controller;

import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class SupplierSerializer implements JsonSerializer<Supplier> {
    @Override
    public JsonElement serialize(Supplier supplier, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonSupplier = new JsonObject();
        jsonSupplier.addProperty("name", supplier.getName());
        jsonSupplier.addProperty("id", supplier.getId());

        return jsonSupplier;

    }
}

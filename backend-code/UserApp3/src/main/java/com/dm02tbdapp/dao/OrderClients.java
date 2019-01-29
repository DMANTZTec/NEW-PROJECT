package com.dm02tbdapp.dao;


import org.json.simple.JSONObject;


public interface OrderClients {
public JSONObject showCatalog();
public JSONObject order();
public JSONObject updateOrder();
public JSONObject cancelOrder();
public double priceOfOrder();
public JSONObject viewOrder();
}

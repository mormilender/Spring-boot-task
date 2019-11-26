package com.myapp.inventory.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.myapp.inventory.entity.Item;


//interface for database related actions
public interface InventoryService{

    public List<Item> retrieveItems(); //get list of all items from database

    public Item getItem(Long ItemId); //get requested item from database

    public Item addItem(Item item);  //add new item to database

    public void deleteItem(Long itemId); //deletes item from database

    public void withdrawalFromItem(HttpServletResponse response, Item item,Integer amount); //withdraw amount from item and update in database

    public void depositToItem(HttpServletResponse response,Item item,Integer amount); //deposit amount to item and update in database
}
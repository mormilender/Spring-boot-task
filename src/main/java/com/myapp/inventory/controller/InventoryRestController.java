package com.myapp.inventory.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.inventory.service.InventoryService;
import com.myapp.inventory.entity.Item;

//requests mapping
@RestController
public class InventoryRestController {

	@Autowired
	private InventoryService inventoryService;

	public void setInventoryService(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}
	
	@GetMapping("/api/items")
	 public List<Item> getItems() {
	  List<Item> items = inventoryService.retrieveItems();
	  return items;
	 }
	  
	 @GetMapping("/api/item/{itemId}")
	 public Item getItem(@PathVariable(name="itemId")Long itemId) {
	  return inventoryService.getItem(itemId);
	 }
	  
	  
	 @PostMapping("/api/item")
	 public Item saveItem(@RequestBody Item item){
		 return inventoryService.addItem(item);
	 }
	  
	 @DeleteMapping("/api/items/{itemId}")
	 public void deleteItem(@PathVariable(name="itemId")Long itemId){
		 inventoryService.deleteItem(itemId);;
	  System.out.println("Item Deleted Successfully");
	 }
	  
	 @PutMapping("/api/items/deposit/{itemId}")
	 public void depositItem( HttpServletResponse response,@RequestParam(name="amount")Integer amount,
	   @PathVariable(name="itemId")Long itemId){
		Item itm = inventoryService.getItem(itemId);
	  if(itm != null){
		  inventoryService.depositToItem(response,itm,amount);
	  }

	 }
	 
	 @PutMapping("/api/items/withdrawal/{itemId}")
	 public void withdrawalItem( HttpServletResponse response,@RequestParam(name="amount")Integer amount,
	   @PathVariable(name="itemId")Long itemId){
		Item itm = inventoryService.getItem(itemId);
	  if(itm != null){
		  inventoryService.withdrawalFromItem(response,itm, amount);
	  }
	   
	 }

}
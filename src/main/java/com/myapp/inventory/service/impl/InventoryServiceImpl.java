package com.myapp.inventory.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.inventory.entity.Item;
import com.myapp.inventory.repository.ItemRepository;
import com.myapp.inventory.service.InventoryService;

//implementation of InventoryService
//communication with database using JPA methods
@Service
public class InventoryServiceImpl implements InventoryService{
	
	@Autowired
	private ItemRepository itemRepository;

	public void setItemRepositery(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	@Override
	public List<Item> retrieveItems() {
		List<Item> items = itemRepository.findAll();
		return items;
	}

	@Override
	public Item getItem(Long ItemId) {
		Optional<Item> optItem = itemRepository.findById(ItemId);
		return optItem.get();
	}

	@Override
	public Item addItem(Item item) {
		return itemRepository.save(item);
	}

	@Override
	public void deleteItem(Long itemId) {
		itemRepository.deleteById(itemId);
	}


	@Override
	public void depositToItem(HttpServletResponse response,Item item,Integer amount) {
		//if value is legal
		if(amount>0)
		{
			item.setAmount(item.getAmount()+amount);
			itemRepository.save(item);
		} else //Illegal value
		{
			//return error 
			try {
				response.sendError(HttpServletResponse.SC_BAD_REQUEST ,"amount should be positive");
			} catch (IOException e) {
				System.out.println("error with response");
			}
		}
		
		
	}

	@Override
	public void withdrawalFromItem(HttpServletResponse response, Item item, Integer amount) {
		
		//if value is legal - can't withdraw more than the available amount
		if(item.getAmount()-amount>=0)
		{
			item.setAmount(item.getAmount()-amount);
			itemRepository.save(item);
		} else //Illegal value
		{
			//return error 
			try {
				response.sendError(HttpServletResponse.SC_BAD_REQUEST ,"withdrawal amount is bigger than available amount");
			} catch (IOException e) {
				System.out.println("error with response");
			}
		}
		
	}


}
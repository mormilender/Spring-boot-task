package com.myapp.inventory.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//item entity definition
@Entity
@Table(name="Inventory")
public class Item {

	@Column(name="Item_NO")
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long item_no;

    @Column(name="NAME")
    private String name;

    @Column(name="AMOUNT")
    private Integer amount;

    @Column(name="INVENTORY_CODE")
    private String inventory_code;

    public Long getItem_no() {
        return item_no;
    }

    public void setItem_no(Long item_no) {
        this.item_no = item_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getInventory_code() {
        return inventory_code;
    }

    public void setInventory_code(String inventory_code) {
        this.inventory_code = inventory_code;
    }
}
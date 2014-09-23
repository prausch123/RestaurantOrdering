/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author peter
 */
public class MenuItem {
    private String itemName;
    private Double itemPrice;
    private ItemType itemType;
    
    private static String ERR_NEW_ITEM = "One of the fields in the item creation was null or equal to nothing";

    public MenuItem(String itemName, Double itemPrice, ItemType itemType) throws IllegalArgumentException {
        if(itemName.equalsIgnoreCase("") || itemPrice < 0 || itemType == null) {
            throw new IllegalArgumentException(ERR_NEW_ITEM);
        } else {
            this.itemName = itemName;
            this.itemPrice = itemPrice;
            this.itemType = itemType;
        }
    }
    
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }
    
    
}

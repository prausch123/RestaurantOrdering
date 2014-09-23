/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.ArrayList;

/**
 *
 * @author peter
 */
public class FakeDB implements IMenuStrategy{
    private ArrayList<MenuItem> items = new ArrayList<MenuItem>();
    
    private static String ERR_ADD_ITEM = "The item you tried to add to the database, was null";
    private static String ERR_REMOVE_ITEM = "The item you tried to remove from the database, was null";
    
    public FakeDB() {
        // DRINKS
        addItem(new MenuItem("Miller High Life", 5.00, ItemType.DRINK));
        addItem(new MenuItem("Miller Lite", 5.00, ItemType.DRINK));
        addItem(new MenuItem("Coors Light", 5.00, ItemType.DRINK));
        addItem(new MenuItem("Milk", 2.00, ItemType.DRINK));
        addItem(new MenuItem("Juice", 2.00, ItemType.DRINK));
        
        // Appetizers
        addItem(new MenuItem("Nachos", 5.00, ItemType.APPETIZER));
        addItem(new MenuItem("Sliders", 7.00, ItemType.APPETIZER));
        addItem(new MenuItem("Combo Platter", 12.00, ItemType.APPETIZER));
        
        // ENTREES
        addItem(new MenuItem("Hamburger", 6.00, ItemType.ENTREE));
        addItem(new MenuItem("Cheeseburger", 6.50, ItemType.ENTREE));
        addItem(new MenuItem("New York Strip", 15.00, ItemType.ENTREE));
        addItem(new MenuItem("Buffalo Wings", 8.00, ItemType.ENTREE));
        addItem(new MenuItem("BLT Sandwitch", 10.00, ItemType.ENTREE));
        addItem(new MenuItem("House Salad", 9.75, ItemType.ENTREE));
        
    }
    
    @Override
    public ArrayList<MenuItem> getMenuItems(ItemType it) {
        ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
        if(it == ItemType.DRINK) {
            for(int i = 0; i < items.size(); i++) {
                if(items.get(i).getItemType() == ItemType.DRINK) {
                    menuItems.add(items.get(i));
                }
            }
        } else if(it == ItemType.APPETIZER) {
            for(int i = 0; i < items.size(); i++) {
                if(items.get(i).getItemType() == ItemType.APPETIZER) {
                    menuItems.add(items.get(i));
                }
            }
        } else if(it == ItemType.ENTREE) {
            for(int i = 0; i < items.size(); i++) {
                if(items.get(i).getItemType() == ItemType.ENTREE) {
                    menuItems.add(items.get(i));
                }
            }
        }
        
        return menuItems;
    }

    @Override
    public void addItem(MenuItem item) throws IllegalArgumentException {
        if(item == null) {
            throw new IllegalArgumentException(ERR_ADD_ITEM);
        } else {
            items.add(item);
        }
    }

    @Override
    public void removeItem(MenuItem item) throws IllegalArgumentException {
        if(item == null) {
            throw new IllegalArgumentException(ERR_REMOVE_ITEM);
        } else {
            items.remove(item);
        }
    }
    
    @Override
    public MenuItem getItemByString(String s) {
        MenuItem item = null;
        
        for(int i = 0; i < items.size(); i++) {
            if(items.get(i).getItemName().equals(s)) {
                item = items.get(i);
            }
        }
        return item;
    }
    
}

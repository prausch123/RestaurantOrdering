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
public interface IMenuStrategy {
    
    public ArrayList<MenuItem> getMenuItems(ItemType it);
    
    public void addItem(MenuItem item);
    
    public void removeItem(MenuItem item);
    
    public MenuItem getItemByString(String s);
}

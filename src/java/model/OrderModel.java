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
public class OrderModel {
    private static String ERR_NOT_ITEM = "The item you tried to find was null";
    
    public ArrayList<MenuItem> getItems(IMenuStrategy ims, String[] s) {
        ArrayList<MenuItem> items = new ArrayList<MenuItem>();

        
        for(String st : s) {
            String stripped = st.substring(0, st.length() - 2);
            
            if(ims.getItemByString(stripped) == null) {
                throw new IllegalArgumentException(ERR_NOT_ITEM);
            } else {
                items.add(ims.getItemByString(stripped));
            }
        }
        
        return items;
    }
}

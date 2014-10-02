/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author peter
 */
public class MySQL_DB implements IMenuStrategy{
    private ArrayList<MenuItem> items = new ArrayList<MenuItem>();
    private Connection conn;
    
    public MySQL_DB(String url, String user, String pass) {
        user = (user == null) ? "" : user;
        pass = (pass == null) ? "" : pass;
        if(url == null) {
            throw new IllegalArgumentException("A field was null when initializing MySQL_DB");
        }
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pass);
            
            Statement state = null;
            ResultSet rs = null;
            
            state = conn.createStatement();
            rs = state.executeQuery("SELECT * FROM menu_item;");
            
            while(rs.next()) {
                MenuItem item = null;
                System.out.println(rs.getString("name"));
                if(rs.getString("type").equalsIgnoreCase("ENTREE")) {
                    item = new MenuItem(rs.getString("name"), rs.getDouble("price"), ItemType.ENTREE);
                } else if(rs.getString("type").equalsIgnoreCase("DRINK")) {
                    item = new MenuItem(rs.getString("name"), rs.getDouble("price"), ItemType.DRINK);
                } else if(rs.getString("type").equalsIgnoreCase("APPETIZER")) {
                    item = new MenuItem(rs.getString("name"), rs.getDouble("price"), ItemType.APPETIZER);
                } else {
                    throw new IllegalArgumentException("A item in your database does not have a correct Item Type");
                }
                this.addItem(item);
            }
            
            conn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQL_DB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MySQL_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    public void addItem(MenuItem item) {
        items.add(item);
    }

    @Override
    public void removeItem(MenuItem item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

<%-- 
    Document   : index.jsp
    Created on : Sep 14, 2014, 5:59:01 PM
    Author     : peter
--%>

<%@page import="java.text.NumberFormat"%>
<%@page import="model.ItemType"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.MenuItem"%>
<%@page import="model.IMenuStrategy"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <title>Restaurant Ordering System</title>
    </head>
    <body>
        <%
            HttpSession s = request.getSession();
            Object dbStrat = s.getAttribute("database");
            IMenuStrategy ims = null;
           
            if(dbStrat == null) {
                out.println("There was an error");
            } else {
                ims = (IMenuStrategy) dbStrat;
                request.setAttribute("database", ims);
            }
        %>
        <form method="post" action="OrderController" name="orderForm">
            <div class="contentHolder topHeader">
                Order Here!
            </div>
            <div class="contentHolder">
                <span class="header">Drinks</span>
                <hr>
                <%
                    ArrayList<MenuItem> drinks = new ArrayList<MenuItem>();
                    
                    NumberFormat f = NumberFormat.getCurrencyInstance();
                    drinks = ims.getMenuItems(ItemType.DRINK);
                    
                    for(MenuItem i : drinks) {
                        
                    
                %>
                <input type="checkbox" name="drink" value="<% out.println(i.getItemName()); %>"> <% out.println(i.getItemName() + " - " + f.format(i.getItemPrice())); %><br>
                <%
                    }    
                %>
            </div>
            <div class="contentHolder">
                <span class="header">Appetizers</span>
                <hr>
                <%
                    ArrayList<MenuItem> apps = new ArrayList<MenuItem>();
                    apps = ims.getMenuItems(ItemType.APPETIZER);
                    
                    for(MenuItem i : apps) {
                        
                    
                %>
                <input type="checkbox" name="appetizer" value="<% out.println(i.getItemName()); %>"> <% out.println(i.getItemName() + " - " + f.format(i.getItemPrice())); %><br>
                <%
                    }    
                %>
            </div>
            <div class="contentHolder">
                <span class="header">Entrées</span>
                <hr>
                <%
                    ArrayList<MenuItem> entrees = new ArrayList<MenuItem>();
                    entrees = ims.getMenuItems(ItemType.ENTREE);
                    
                    for(MenuItem i : entrees) {
                        
                    
                %>
                <input type="checkbox" name="entree" value="<% out.println(i.getItemName()); %>"> <% out.println(i.getItemName() + " - " + f.format(i.getItemPrice())); %><br>
                <%
                    }    
                %>
            </div>
            <div class="contentHolder" style="text-align:center;">
                <input type="submit" value="Complete Order" name="submit">
            </div>
        </form>
    </body>
</html>

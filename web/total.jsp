<%-- 
    Document   : total
    Created on : Sep 15, 2014, 6:23:58 PM
    Author     : peter
--%>

<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.MenuItem"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <title>Total</title>
    </head>
        <body>
            <%
                NumberFormat f = NumberFormat.getCurrencyInstance();
                
                ArrayList<MenuItem> drinks = (ArrayList<MenuItem>) request.getAttribute("drinks");
                ArrayList<MenuItem> appetizers = (ArrayList<MenuItem>) request.getAttribute("appetizers");
                ArrayList<MenuItem> entrees = (ArrayList<MenuItem>) request.getAttribute("entrees");
            %>
            <div class="contentHolder topHeader">
                Your Total
            </div>
            <div class="contentHolder">
                <span class="header">Drinks</span>
                <hr>
                <center>
                    <%
                        for(MenuItem i : drinks) {
                            out.println(i.getItemName() + " - " + f.format(i.getItemPrice()) + "<br>");
                        }
                    %>
                </center>
            </div>
            <div class="contentHolder">
                <span class="header">Appetizers</span>
                <hr>
                <center>
                    <%
                        for(MenuItem i : appetizers) {
                            out.println(i.getItemName() + " - " + f.format(i.getItemPrice()) + "<br>");
                        }
                    %>
                </center>
            </div>
            <div class="contentHolder">
                <span class="header">Entrées</span>
                <hr>
                <center>
                    <%
                        for(MenuItem i : entrees) {
                            out.println(i.getItemName() + " - " + f.format(i.getItemPrice()) + "<br>");
                        }
                    %>
                </center>
            </div>
            <div class="contentHolder">
                <span class="header">Total</span>
                <hr>
                <center>
                    <%
                            double total = 0;
                            for(MenuItem i : drinks) {
                                total += i.getItemPrice();
                            }
                            for(MenuItem i : appetizers) {
                                total += i.getItemPrice();
                            }
                            for(MenuItem i : entrees) {
                                total += i.getItemPrice();
                            }
                            out.println(f.format(total));
                    %>
                </center>
            </div>
        </body>
</html>

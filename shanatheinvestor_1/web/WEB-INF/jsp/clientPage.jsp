<%-- 
    Document   : client
    Created on : Jan 16, 2017, 5:38:47 PM
    Author     : Shana
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Client Page</title>
    </head>
    <body>
           <h1> List of Opportunities </h1>

        <table border="2" width="70%" cellpadding="2">
            <tr>
                <th>Customer Name</th>
                <th>Customer Phone</th>
                <th>Address</th>
                <th>State</th>
                <th>Postal Code</th>
                <th>Property Address</th>
                <th>Property State</th>
                <th>Property Postal Code</th>
                <th>Sales Stage</th>
                <th>Amount</th>
                <th>Date</th>
                <th>Comments</th>
               
            </tr>
            <c:forEach items="${dealList}" var="deal">
                <tr>
                    <th><c:out value="${deal.customer_name}"/></th>
                    <th><c:out value="${deal.customer_phone}"/></th>
                    <th><c:out value="${deal.customer_address}"/></th>
                    <th><c:out value="${deal.customer_state}"/></th>
                    <th><c:out value="${deal.postal_code}"/></th>
                    <th><c:out value="${deal.property_address}"/></th>
                    <th><c:out value="${deal.property_state}"/></th>
                    <th><c:out value="${deal.property_postal_code}"/></th>
                    <th><c:out value="${deal.sales_stage}"/></th>
                    <th><c:out value="${deal.close_date}"/></th>
                    <th><c:out value="${deal.amount}"/></th>
                    <th><c:out value="${deal.comment}"/></th>
                    <th><a href="editUser.htm?user_id=<c:out value='${deal.deal_id}'/>">Edit</a></th>
                    <th><a href="deleteUser.htm?user_id=<c:out value='${deal.deal_id}'/>">Delete</a></th>
                    //change sales stage drop down
                </tr>
            </c:forEach>
        </table>        
        <br>
        <a href="editDeal.htm?deal_id=0">Create Deal</a>
        <br>
       
        <a href="goTowholesaleCalculatorFromClient.htm">Wholesale Calculator</a>
        <br>
        <a href="downloadDashboard.htm">Dashboard Download</a>
    </body>
</html>
<%-- 
    Document   : client
    Created on : Jan 16, 2017, 5:38:47 PM
    Author     : Shana
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Client Page</title>
        <link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <style>html,body,h1,h2,h3,h4,h5 {font-family: "Raleway", sans-serif}</style>
        <style>
        table {
           border-collapse: collapse;
           width: 100%;
       }

       th, td {
           text-align: left;
           padding: 8px;
       }

       tr:nth-child(even){background-color: #f2f2f2}

       th {
           background-color: #000000;
           color: white;
       }           
        </style>
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
                <th>Close Date</th>
                <th>Amount</th>
                <th>Comments</th>
                <th>Edit</th>
                <th>Delete</th>
                
               
            </tr>
            <c:forEach items="${dealList}" var="deal">
                <tr>
                    <td><c:out value="${deal.customer_name}"/></td>
                    <td><c:out value="${deal.customer_phone}"/></td>
                    <td><c:out value="${deal.address}"/></td>
                    <td><c:out value="${deal.state}"/></td>
                    <td><c:out value="${deal.postal_code}"/></td>
                    <td><c:out value="${deal.property_address}"/></td>
                    <td><c:out value="${deal.property_state}"/></td>
                    <td><c:out value="${deal.property_postal_code}"/></td>
                    <td><select>
                            <option value ="0"> <a href="updateDeal.htm?deal_id=<c:out value='${deal.deal_id}'/>">Lead</a> </option>
                            <option value ="1"> Stage 1 </option>
                            <option value ="2"> Stage 2 </option>
                            <option value ="3"> Stage 3 </option>
                            <option value ="4"> Won </option>
                        </select>
                    </td>
                    <td><c:out value="${deal.close_date}"/></td>
                    <td><c:out value="${deal.amount}"/></td>
                    <td><c:out value="${deal.comment}"/></td>
                    <td><a href="editDeal.htm?deal_id=<c:out value='${deal.deal_id}'/>">Edit</a></td>
                    <td><a href="deleteDeal.htm?deal_id=<c:out value='${deal.deal_id}'/>">Delete</a></td>
                    
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

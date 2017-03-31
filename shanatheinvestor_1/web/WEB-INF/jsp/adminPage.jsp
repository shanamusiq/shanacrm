<%-- 
    Document   : admin
    Created on : Jan 16, 2017, 5:37:29 PM
    Author     : Shana
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Administrator Page</title>
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
        <c:if test = "${mainuser.level == 1}">

            <h1> List of Users </h1>
            <p>Levels: Admin = 1, User = 2, Prospect =3, Client = 4</p>
            <table border = "1" width="70%" cellpadding="2">
                <tr>
                    <th>User Id</th>
                    <th>UserName</th>
                    <th>Password</th>
                    <th>Level</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                <c:forEach items="${userList}" var="user">
                    <tr>
                        <td><c:out value="${user.user_id}"/></td>
                        <td><c:out value="${user.user_name}"/></td>
                        <td><c:out value="${user.password}"/></td>
                        <td><c:out value="${user.level}"/></td> 
                        <td><a href="editUser.htm?user_id=<c:out value='${user.user_id}'/>">Edit</a></td>
                        <td><a href="deleteUser.htm?user_id=<c:out value='${user.user_id}'/>">Delete</a></td>                          
                    </tr>
                </c:forEach>
            </table>        
            <br>

            <a href="editUser.htm?user_id=0">Create User</a>
        </c:if>
        <h1> List of Prospects </h1>

        <table border="2" width="70%" cellpadding="2">
            <tr>
                <th>Prospect ID</th>
                <th>User ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Address</th>
                <th>City</th>
                <th>State</th>
                <th>Postal Code</th>
                <th>Credit Card</th>
                <th>Pin</th>
                <th>Expiration Date</th>
                <th>Edit</th>
                <th>Delete</th>
                <th>Upgrade</th>
            </tr>
            <c:forEach items="${prospectList}" var="prospect">
                <tr>
                    <td><c:out value="${prospect.prospect_id}"/></td>
                    <td><c:out value="${prospect.user_id}"/></td>
                    <td><c:out value="${prospect.first_name}"/></td>
                    <td><c:out value="${prospect.last_name}"/></td>
                    <td><c:out value="${prospect.address}"/></td>
                    <td><c:out value="${prospect.city}"/></td>
                    <td><c:out value="${prospect.state}"/></td>
                    <td><c:out value="${prospect.postal_code}"/></td>
                    <td><c:out value="${prospect.credit_card}"/></td>
                    <td><c:out value="${prospect.credit_card_pin}"/></td>
                    <td><c:out value="${prospect.credit_card_exp}"/></td>
                    <td><a href="editProspect.htm?prospect_id=<c:out value='${prospect.prospect_id}'/>">Edit</a></td>
                    <td><a href="deleteProspect.htm?prospect_id=<c:out value='${prospect.prospect_id}'/>">Delete</a></td>
                    <td><a href="upgradeProspect.htm?prospect_id=<c:out value='${prospect.prospect_id}'/>">Upgrade</a></td>
                </tr>
            </c:forEach>
        </table>        
        <br>
        <a href="editProspect.htm?prospect_id=0">Add Prospect</a>

        <h1> List of Clients </h1>

        <table border="2" width="70%" cellpadding="2">
            <tr>
                <th>Client ID</th>
                <th>User ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Phone</th>
                <th>Address</th>
                <th>City</th>
                <th>State</th>
                <th>Postal Code</th>
                <th>Credit Card</th>
                <th>Pin</th>
                <th>Expiration Date</th>
                <th>Edit</th>
                <th>Delete</th>
                <th>Downgrade</th>
            </tr>
            <c:forEach items="${clientList}" var="client">
                <tr>
                    <td><c:out value="${client.client_id}"/></td>
                    <td><c:out value="${client.user_id}"/></td>
                    <td><c:out value="${client.first_name}"/></td>
                    <td><c:out value="${client.last_name}"/></td>
                    <td><c:out value="${client.phone}"/></td>
                    <td><c:out value="${client.address}"/></td>
                    <td><c:out value="${client.city}"/></td>
                    <td><c:out value="${client.state}"/></td>
                    <td><c:out value="${client.postal_code}"/></td>
                    <td><c:out value="${client.credit_card}"/></td>
                    <td><c:out value="${client.credit_card_pin}"/></td>
                    <td><c:out value="${client.credit_card_exp}"/></td>
                    <td><a href="editClient.htm?client_id=<c:out value='${client.client_id}'/>">Edit</a></td>
                    <td><a href="deleteClient.htm?client_id=<c:out value='${client.client_id}'/>">Delete</a></td>  
                    <td><a href="downgradeClient.htm?client_id=<c:out value='${client.client_id}'/>">Downgrade</a></td> 
                </tr>
            </c:forEach>
        </table>        
        <br>
        <a href="editClient.htm?client_id=0">Add Client</a>
        <br>
        <a href="GoToInteractionPage.htm">Interactions Page</a>
        <br>
        <a href="ToLoginFromAdmin.htm">Back</a>
</html>
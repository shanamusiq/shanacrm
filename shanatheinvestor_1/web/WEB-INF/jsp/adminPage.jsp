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
    </head>
    <body>
        <h1> List of Users </h1>

        <table border="2" width="70%" cellpadding="2">
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
                    <th><c:out value="${user.user_id}"/></th>
                    <th><c:out value="${user.user_name}"/></th>
                    <th><c:out value="${user.password}"/></th>
                    <th><c:out value="${user.level}"/></th> 
                    <th><a href="editUser.htm?user_id=<c:out value='${user.user_id}'/>">Edit</a></th>
                    <th><a href="deleteUser.htm?user_id=<c:out value='${user.user_id}'/>">Delete</a></th>                          
                </tr>
            </c:forEach>
        </table>        
        <br>
        <a href="editUser.htm?user_id=0">Create User</a>
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
                    <th><c:out value="${prospect.prospect_id}"/></th>
                    <th><c:out value="${prospect.user_id}"/></th>
                    <th><c:out value="${prospect.first_name}"/></th>
                    <th><c:out value="${prospect.last_name}"/></th>
                    <th><c:out value="${prospect.address}"/></th>
                    <th><c:out value="${prospect.city}"/></th>
                    <th><c:out value="${prospect.state}"/></th>
                    <th><c:out value="${prospect.postal_code}"/></th>
                    <th><c:out value="${prospect.credit_card}"/></th>
                    <th><c:out value="${prospect.credit_card_pin}"/></th>
                    <th><c:out value="${prospect.credit_card_exp}"/></th>
                    <th><a href="editProspect.htm?prospect_id=<c:out value='${prospect.prospect_id}'/>">Edit</a></th>
                    <th><a href="deleteProspect.htm?prospect_id=<c:out value='${prospect.prospect_id}'/>">Delete</a></th>
                    <th><a href="upgradeProspect.htm?prospect_id=<c:out value='${prospect.prospect_id}'/>">Upgrade</a></th>
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
                    <th><c:out value="${client.client_id}"/></th>
                    <th><c:out value="${client.user_id}"/></th>
                    <th><c:out value="${client.first_name}"/></th>
                    <th><c:out value="${client.last_name}"/></th>
                    <th><c:out value="${client.phone}"/></th>
                    <th><c:out value="${client.address}"/></th>
                    <th><c:out value="${client.city}"/></th>
                    <th><c:out value="${client.state}"/></th>
                    <th><c:out value="${client.postal_code}"/></th>
                    <th><c:out value="${client.credit_card}"/></th>
                    <th><c:out value="${client.credit_card_pin}"/></th>
                    <th><c:out value="${client.credit_card_exp}"/></th>
                    <th><a href="editClient.htm?client_id=<c:out value='${client.client_id}'/>">Edit</a></th>
                    <th><a href="deleteClient.htm?client_id=<c:out value='${client.client_id}'/>">Delete</a></th>  
                    <th><a href="downgradeClient.htm?client_id=<c:out value='${client.client_id}'/>">Downgrade</a></th> 
                </tr>
            </c:forEach>
        </table>        
        <br>
        <a href="editClient.htm?client_id=0">Add Client</a>
    </body>
</html>
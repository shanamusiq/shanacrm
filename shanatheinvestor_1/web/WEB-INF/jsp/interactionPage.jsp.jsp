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
        <title>Interaction Page</title>
    </head>
    <body>
           <h1> List of Interactions </h1>

        <table border="2" width="70%" cellpadding="2">
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Phone</th>
                <th>User ID</th>
                <th>Prospect ID</th>
                <th>Client ID</th>
                <th>Comments</th>

               
            </tr>
            <c:forEach items="${interactionList}" var="deal">
                <tr>
                    <th><c:out value="${interaction.name}"/></th>
                    <th><c:out value="${interaction.email}"/></th>
                    <th><c:out value="${interaction.phone}"/></th>
                    <th><c:out value="${interaction.user_id}"/></th>
                    <th><c:out value="${interaction.prospect_id}"/></th>
                    <th><c:out value="${interaction.client_id}"/></th>
                    <th><c:out value="${interaction.comments}"/></th>

                    <th><a href="editUser.htm?user_id=<c:out value='${interaction.interaction_id}'/>">Edit</a></th>
                    <th><a href="deleteUser.htm?user_id=<c:out value='${interaction.interaction_id}'/>">Delete</a></th>
                   
                </tr>
            </c:forEach>
        </table>        
        <br>
        <a href="editDeal.htm?deal_id=0">Log Interaction</a>

    </body>
</html>

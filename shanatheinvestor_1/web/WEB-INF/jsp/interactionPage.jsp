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
        <title>Interaction Page</title>
        <link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <style>html,body,h1,h2,h3,h4,h5 {font-family: "Raleway", sans-serif}</style>
    </head>
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
    <body>
           <h1> List of Interactions </h1>

        <table border="2" width="70%" cellpadding="2">
            <tr>
                <th>Name (Customer)</th>
                <th>Email(Customer)</th>
                <th>Phone(Customer)</th>
                <th>Comments</th>
                <th>Edit</th>
                <th>Delete</th>
               
            </tr>
            <c:forEach items="${interactionList}" var="interaction">
                <tr>
                    <td><c:out value="${interaction.name}"/></td>
                    <td><c:out value="${interaction.email}"/></td>
                    <td><c:out value="${interaction.phone}"/></td>
                    <td><c:out value="${interaction.comments}"/></td>

                    <td><a href="editInteraction.htm?interaction_id=<c:out value='${interaction.interaction_id}'/>">Edit</a></td>
                    <td><a href="deleteInteraction.htm?interaction_id=<c:out value='${interaction.interaction_id}'/>">Delete</a></td>
                   
                </tr>
            </c:forEach>
        </table>        
        <br>
        <a href="editInteraction.htm?interaction_id=0">Log Interaction</a>
        <br>
        <a href="ToAdminFromInteraction.htm">Back</a>
    </body>
</html>

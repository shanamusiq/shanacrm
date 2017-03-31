<%-- 
    Document   : editUserPager
    Created on : Jan 28, 2017, 11:30:37 AM
    Author     : Shana
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>User Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <style>html,body,h1,h2,h3,h4,h5 {font-family: "Raleway", sans-serif}</style>
    </head>
    <body>
          <div class="w3-modal-content w3-animate-opacity" style="max-width: 600px;">
          <div class="w3-center">
          </div>
        <form:form method="POST" commandName="user" action="submitEditUserPage.htm">
            <br>
            <br>
            <br>
            <table>
                <tr>
                    <td>User ID :</td>
                    <td><form:input path="user_id" /></td>
                </tr>
                <tr>
                    <td>User Name (email) :</td>
                    <td><form:input path="user_name" /></td>
                </tr>
                <tr>
                    <td>Password :</td>
                    <td><form:input path="password" /></td>
                </tr>
                <tr>
                    <td>User Role :</td>
                    <td><form:input path="level" /></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit"></td>
                </tr>
            </table>
        </form:form>

    </body>
</html>



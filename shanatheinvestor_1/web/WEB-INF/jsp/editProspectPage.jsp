<%-- 
    Document   : editProspectPage
    Created on : Jan 28, 2017, 11:31:22 AM
    Author     : Shana
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Prospect Page</title>
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
        <form:form method="POST" commandName="prospect" action="submitEditProspectPage.htm">
            <br>
            <br>
            <br>
            <table>
                <tr>
                    <td>First Name :</td>
                    <td><form:input path="first_name" /></td>
                </tr>
                <tr>
                    <td>Last Name :</td>
                    <td><form:input path="last_name" /></td>
                </tr>
                <tr>
                    <td>Phone :</td>
                    <td><form:input path="phone" /></td>
                </tr>
                <tr>
                    <td>Address :</td>
                    <td><form:input path="address" /></td>
                </tr>
                <tr>
                    <td>State :</td>
                    <td><form:input path="state" /></td>
                </tr>
                <tr>
                    <td>Postal Code :</td>
                    <td><form:input path="postal_code" /></td>
                </tr>
                 <tr>
                    <td>Credit Card Number :</td>
                    <td><form:input path="credit_card" /></td>
                </tr>
                 <tr>
                    <td>Credit Card Pin :</td>
                    <td><form:input path="credit_card_pin" /></td>
                </tr>
                 <tr>
                    <td>Credit Card Exp :</td>
                    <td><form:input path="credit_card_exp" /></td>
                </tr>
                 <tr>
                    <td>Email :</td>
                    <td><form:input path="email" /></td>
                </tr>
                <tr>
                    <td>City :</td>
                    <td><form:input path="city" /></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit"></td>
                </tr>
            </table>
        </form:form>

    </body>
</html>
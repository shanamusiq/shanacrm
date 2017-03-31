<%-- 
    Document   : editDealsPage
    Created on : Jan 28, 2017, 11:31:49 AM
    Author     : Shana
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Deals Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <style>html,body,h1,h2,h3,h4,h5 {font-family: "Raleway", sans-serif}</style>

    </head>
    <body>
        <div class="w3-modal-content w3-animate-opacity" style="max-width: 600px;">
        <form:form method="POST" commandName="deal" action="submitEditDealPage.htm">
            <br>
            <br>
            <br>
            <form:hidden path = "client_id"/>
            <table>
                <tr>
                    <td>Customer Name :</td>
                    <td><form:input path="customer_name" /></td>
                </tr>
                <tr>
                    <td>Customer Phone :</td>
                    <td><form:input path="customer_phone" /></td>
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
                    <td>Property Postal Code :</td>
                    <td><form:input path="property_postal_code" /></td>
                </tr>
                <tr>
                    <td>Property Address :</td>
                    <td><form:input path="property_address" /></td>
                </tr>
                <tr>
                    <td>Property State :</td>
                    <td><form:input path="property_state" /></td>
                </tr>
                <tr>
                    <td>Postal Code :</td>
                    <td><form:input path="postal_code" /></td>
                </tr>
                <tr>
                    <td>Sales Stage :</td>
                    <td><form:input path="sales_stage" /></td>
                </tr>
                <tr>
                    <td>Amount :</td>
                    <td><form:input path="amount" /></td>
                </tr>
                <tr>
                    <td>Close Date :</td>
                    <td><form:input path="close_date" /></td>
                </tr>
                <tr>
                    <td>Comments :</td>
                    <td><form:input path="comment" /></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit"></td>
                </tr>
            </table>
        </form:form>
        </div>
    </body>
</html>

<%-- 
    Document   : RegisterPage
    Created on : Jan 12, 2017, 8:27:37 PM
    Author     : Shana
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Register Page</title>
    </head>
    <body>

        <form:form method="POST" commandName="registrant" action="submitRegisterPage.htm">
            <table>
                <tr>
                    <td>User Name (email address) :</td>
                    <td><form:input path="user_name" /></td>
                </tr>
                <tr>
                    <td>Password :</td>
                    <td><form:password path="password" /></td>
                </tr>
                <tr>
                    <td>First Name :</td>
                    <td><form:input path="first_name" /></td>
                </tr>
                <tr>
                    <td>Last Name :</td>
                    <td><form:input path="last_name" /></td>
                </tr>
                <tr>
                    <td>Street Address :</td>
                    <td><form:input path="address" /></td>
                </tr>
                <tr>
                    <td>State :</td>
                    <td><form:input path="state" /></td>
                </tr>
                <tr>
                    <td>City :</td>
                    <td><form:input path="city" /></td>
                </tr>    
                <tr>
                    <td>Postal Code :</td>
                    <td><form:input path="postal_code" /></td>
                </tr>
                <tr>
                    <td>Phone # :</td>
                    <td><form:input path="phone" /></td>
                </tr>
                <tr>
                    <td>Credit Card # :</td>
                    <td><form:input path="credit_card" /></td>
                </tr>
                <tr>
                    <td>Credit Card Pin # :</td>
                    <td><form:input path="credit_card_pin" /></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="register"></td>
                </tr>
                
            </table>
        </form:form>

    </body>
 </html>
 
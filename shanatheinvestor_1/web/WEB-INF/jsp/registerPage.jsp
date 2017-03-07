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
       <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <style>html,body,h1,h2,h3,h4,h5 {font-family: "Raleway", sans-serif}</style>
         
    </head>
    <body>
        <br/>
        <br/>
     <div style="max-width: 600px; margin-left:auto;margin-right:auto">

          <div class="w3-center">
            <img class="w3-circle w3-margin-right" style="width: 30%;" alt="Avatar" src="/ChinookSpring/media/img/avatar.png">
          </div>
        <form:form method="POST" commandName="registrant" action="submitRegisterPage.htm">
            <table>
                <tr>
                    <td> <label><b>User Name (email address) :</b></label></td>
                    <td><form:input class="w3-input w3-border w3-margin-bottom"  path="user_name" placeholder="Enter User Name"/></td>
                </tr>
                <tr>
                    <td>Password :</td>
                    <td><form:password class="w3-input w3-border w3-margin-bottom"  path="password" placeholder="Enter Password"/></td>
                </tr>
                <tr>
                    <td>First Name :</td>
                    <td><form:input class="w3-input w3-border w3-margin-bottom" path="first_name" placeholder="Enter First Name"/></td>
                </tr>
                <tr>
                    <td>Last Name :</td>
                    <td><form:input class="w3-input w3-border w3-margin-bottom" path="last_name" placeholder="Enter Last Name"/></td>
                </tr>
                <tr>
                    <td>Street Address :</td>
                    <td><form:input class="w3-input w3-border w3-margin-bottom" path="address" placeholder="Enter Address"/></td>
                </tr>
                <tr>
                    <td>State :</td>
                    <td><form:input class="w3-input w3-border w3-margin-bottom" path="state" placeholder="Enter State"/></td>
                </tr>
                <tr>
                    <td>City :</td>
                    <td><form:input class="w3-input w3-border w3-margin-bottom" path="city" placeholder="Enter City" /></td>
                </tr>    
                <tr>
                    <td>Postal Code :</td>
                    <td><form:input class="w3-input w3-border w3-margin-bottom" path="postal_code" placeholder="Enter Postal Code"/></td>
                </tr>
                <tr>
                    <td>Phone # :</td>
                    <td><form:input class="w3-input w3-border w3-margin-bottom" path="phone" placeholder="Enter Phone Number"/></td>
                </tr>
                <tr>
                    <td>Credit Card # :</td>
                    <td><form:input class="w3-input w3-border w3-margin-bottom" path="credit_card" placeholder="Enter Credit Card Number"/></td>
                </tr>
                <tr>
                    <td>Credit Card Pin # :</td>
                    <td><form:input class="w3-input w3-border w3-margin-bottom" path="credit_card_pin" placeholder="Enter Credit Card Pin"/></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="register"></td>
                </tr>
                
            </table>
        </form:form>
     </div>

    </body>
 </html>
 
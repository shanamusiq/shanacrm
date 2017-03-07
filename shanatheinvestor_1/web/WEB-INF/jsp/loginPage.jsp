<%-- 
    Document   : loginPage
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
        <title>Login Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <style>html,body,h1,h2,h3,h4,h5 {font-family: "Raleway", sans-serif}</style>
    </head>
    <body>
        <br/>
        <br/>
     <div class="w3-modal-content w3-card-8 w3-animate-zoom" style="max-width: 600px;">

          <div class="w3-center">
            <img class="w3-circle w3-margin-top" style="width: 30%;" alt="Avatar" src="/ChinookSpring/media/img/avatar.png">
          </div>

           <form:form method="POST" class="w3-container" commandName="user" action="frontPage.htm">
            <input name="_csrf" type="hidden" value="f3e8b8b3-c64d-481c-90ab-15da4dc536fb">
            <div class="w3-section">
              
              
              
              <label><b>Username</b></label>
              <form:input path="user_name" class="w3-input w3-border w3-margin-bottom" required="" type="text" placeholder="Enter Username"/>
              <label><b>Password</b></label>
              <form:password path="password" class="w3-input w3-border" required="" placeholder="Enter Password" />
              <button class="w3-btn-block w3-green w3-section w3-padding" type="submit">Login</button>
              <a href="register.htm">Register</a>
            </div>
          </form:form>

   </div>       
        
        
        
        
     <!--   
        
        <form:form method="POST" commandName="user" action="frontPage.htm">
            <table>
                <tr>
                    <td>User Name :</td>
                    <td><form:input path="user_name" /></td>
                </tr>
                <tr>
                    <td>Password :</td>
                    <td><form:password path="password" /></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit"></td>
                </tr>
                <tr>
                    <td colspan="2"> <a href="register.htm">Register</a></td>
                </tr>
            </table>
        </form:form>
-->

    </body>
</html>


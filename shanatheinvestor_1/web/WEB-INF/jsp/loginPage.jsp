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
    </head>
    <body>

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

    </body>
</html>


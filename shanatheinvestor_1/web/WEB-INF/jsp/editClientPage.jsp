<%-- 
    Document   : editClientPage
    Created on : Jan 28, 2017, 11:30:55 AM
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
    </head>
    <body>

        <form:form method="POST" commandName="user" action="submitEditUserPage.htm">
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
                    <td><form:password path="password" /></td>
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
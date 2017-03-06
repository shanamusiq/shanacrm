<%-- 
    Document   : wholesaleCalculator
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
        <title>Wholesale Calculator</title>
    </head>
    <body>

        <form:form method="POST" commandName="wholesaleCalculator" action="wholesaleCalculatorPage.htm">
            <table>
                <tr>
                    <td>After Repair Value (ARV) :</td>
                    <td><form:input path="arv" /></td>
                </tr>
                <tr>
                    <td>Net Investor Profit @20% :</td>
                    <td><form:input path="net_profit" /></td>
                </tr>
                <tr>
                    <td>Estimated Repair Cost :</td>
                    <td><form:input path="repair_cost" /></td>
                </tr>
                <tr>
                    <td>Assignment Fee :</td>
                    <td><form:input path="assignment_fee" /></td>
                </tr>
                <tr>
                    <td>Maximum Offer:</td>
                    <td><form:input path="max_offer" /></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit"></td>
                </tr>
            </table>
        </form:form>

    </body>
</html>


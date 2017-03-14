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
        <link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <style>html,body,h1,h2,h3,h4,h5 {font-family: "Raleway", sans-serif}</style>    
    </head>
    <body>
    <div class="w3-modal-content w3-card-8 w3-animate-zoom" style="max-width: 500px;">
        <br/>
        
        <h2 style="margin-left: 50px"> Wholesale Calculator</h2>
        <br/>
        <br/>
        <form:form method="POST" class="w3-container" style="margin-left: 50px"  commandName="wholesaleCalculator" action="wholesaleCalculatorPage.htm">
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
                    <td colspan="2"><input class="w3-btn-block w3-black w3-section w3-padding" type="submit"></td>
                </tr>
            </table>
        </form:form>
        <br/>
    </div>
        <br/>
        <br/>
        <br/>
 
        <p class="w3-modal-content"> </p>
    </body>
</html>


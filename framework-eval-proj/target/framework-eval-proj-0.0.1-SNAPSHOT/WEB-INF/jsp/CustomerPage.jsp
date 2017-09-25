<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
     <%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Page</title>
</head>
<body>
<h3 style="color:grey">${error}</h3>
<h1>Customer Page</h1>
<form:form action="CustomerAdd" method="POST" modelAttribute="customer">
<h4>Add a Customer</h4>
<table>
<tr><td>List of Banks
<select name="BankName">
<c:forEach items="${Banks}" var="bank">
<option value="${bank.bankName}">${bank.bankName}</option>
</c:forEach>
</select>
</td></tr>
<tr><td>
<form:label path="accountNumber">Account Number:</form:label>
<form:input path="accountNumber"/>
</td></tr>
<tr><td>
<form:label path="name" >Customer Name:</form:label>
<form:input path="name"/>

</td></tr>
<tr><td>

<form:label path="accountType">Account Type:</form:label>
<form:select path="accountType">
<form:option value="savings">Savings</form:option>
<form:option value="fixed">Fixed</form:option>
</form:select>
</td></tr>
<tr><td>
<form:label path="amount">Amount:</form:label>
<form:input path="amount"/>

</td></tr>
<tr><td>
<form:label path="date">Date:</form:label>
<form:input path="date"/>

</td></tr>
<tr><td>
<form:label path="tenure">Tenure:</form:label>
<form:input path="tenure"/>
<td>***Not applicable for Savings Account type***</td>
</tr>
<tr><td><input type="submit" value="submit"></td></tr>
</table>
<table>
<tr><td><h4>Display Customers</h4></td></tr>
<tr><td>Customer Names:</td></tr>
<c:forEach items="${Customers}" var="customer">
<tr><td>${customer.accountNumber}</td>
				<td>${customer.name}</td>
                <td>${customer.accountType}</td>
                <td>${customer.amount}</td>
                <td>${customer.date}</td>
                <td>${customer.tenure}</td>
				<td>${customer.FinalAmount}</td>
				</tr>
</c:forEach>
</table>
</form:form>

</body>
</html>
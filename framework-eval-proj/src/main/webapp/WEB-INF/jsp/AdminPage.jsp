<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
     <%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Page</title>
</head>
<body>
<h3 style="color:grey">${error}</h3>
<h1>Admin Page</h1>
<form:form action="bankNamesAdd" method="POST" modelAttribute="bank">
<h4>Add a bank</h4>
<table>
<tr><td><form:input path="bankName"/>
<form:label path="bankName"/>
</td>
</tr>
<tr><td><input type="submit" value="submit"></td></tr>
</table>
<table>
<tr><td><h4>Display Bank</h4></td></tr>
<tr><td>Bank Names:</td></tr>
<c:forEach items="${Banks}" var="bank">
<tr><td><input type="text" name="${bank.bankName}" value="${bank.bankName}"></td></tr>
</c:forEach>
</table>
</form:form>
<form action="bankNamesEdit" method="post">
<table>
<tr><td><h4>Edit Bank</h4></td></tr>
<tr><td>Bank Names:</td></tr>
<tr><td>
<select name="BankName" >
<c:forEach items="${Banks}" var="bank">
<option value="${bank.bankName}">${bank.bankName}</option>
</c:forEach>
</select>
</td><td><input type="submit" value="delete" name="deleteBank"/></td></tr>
<tr><td><input type="text" name="newname" ></td></tr>
<tr><td><input type="submit" value="submit" name="modifyBank"></td>
</tr>
<tr><td><a href="CustomerPage">Customer Page...</a></td></tr>
</table>
</form>
</body>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Input Employee Data</title>
</head>
<body>
	<h3>
		<font size="6" color="green" face="Century">Input Your Employee
			Data</font>
	</h3>
	<form action="Controller" method="POST">
		<table>
			<tbody>
				<tr>
					<td><code>Employee ID:</code></td>
					<td><input type="text" name="employeeid"
						value="Enter your ID (number)..." onclick="this.value=''"
						style="width: 360px" /></td>
				</tr>
				<tr>
					<td><code>Name:</code></td>
					<td><input type="text" name="name" value="Enter your name..."
						onclick="this.value=''" style="width: 360px" /></td>
				</tr>
				<tr>
					<td><code>Category:</code></td>
					<td>
					<select name="category">
							<c:forEach items="${salary}" var="sal">
								<option value="${sal.grade}"><c:out value="${sal.grade} = ${sal.monthlySalary}"/></option>
							</c:forEach>
					</select> <br></td>
				</tr>
			</tbody>
		</table>
		<input type="submit" value="Input Data" />
	</form>
</body>
</html>
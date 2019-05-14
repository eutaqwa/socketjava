<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Input Salary Form</title>
</head>
<body>
	<h3>
		<font size="6" color="green" face="Century"> Input Employee
			Salary by Grade </font>
	</h3>
	<form action="SalaryController" method="POST">
		<table>
			<tbody>
				<tr>
					<td><code>Grade:</code></td>
					<td><input type="text" name="grade" value="Grade..."
						onclick="this.value=''" style="width: 360px" /></td>
				</tr>
				<tr>
					<td><code>Salary:</code></td>
					<td><input type="text" name="salary" value="Salary..."
						onclick="this.value=''" style="width: 360px" /></td>
				</tr>
			</tbody>
		</table>
		<input type="submit" value="Save" />
	</form>

</body>
</html>
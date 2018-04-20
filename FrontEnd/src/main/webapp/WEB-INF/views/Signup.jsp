
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@include file="Header.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Signup</title>
</head>
<body>
	<h3>Signup</h3>
	<form:form modelAttribute="userdetail" action="InsertUser" method="post">
		<table align="center"></table>
		<table>
			<tr bgcolor="olive">
				<td colspan="2"><center>Sign up</center></td>
			</tr>
			<tr>
				<td>UserName</td>
				<td><form:input path="userName" /></td>
			</tr>
			<tr>
				<td>password</td>
				<td><form:input path="password" /></td>
			</tr>
			<tr>
				<td>role</td>
				<td><form:input path="role" /></td>
			</tr>
			<tr>
				<td>Email Id</td>
				<td><form:input path="emailId" /></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><form:input path="address" /></td>
			</tr>
			<tr>
				<td colspan="2"><center>
						<input type="submit" value="SUBMIT" />
					</center></td>
			</tr>
		</table>
	</form:form>

</body>
</html>
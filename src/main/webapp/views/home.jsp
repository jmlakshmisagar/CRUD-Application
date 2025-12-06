<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	request.getAttribute("result");
	%>
</body>
</html><%@ page import="java.sql.ResultSet"%>

<body>

	<%
	ResultSet rs = (ResultSet) request.getAttribute("result");

	if (rs == null) {
	%>
	<p>No data received.</p>
	<%
	} else {
	%>

	<table border="1" cellpadding="10">
		<tr>
			<th>Emp ID</th>
			<th>Name</th>
			<th>Gender</th>
			<th>Age</th>
			<th>Department</th>
			<th>Salary</th>
			<th>City</th>
			<th>Phone</th>
		</tr>

		<%
		while (rs.next()) {
		%>

		<tr>
			<td><%=rs.getInt("emp_id")%></td>
			<td><%=rs.getString("emp_name")%></td>
			<td><%=rs.getString("gender")%></td>
			<td><%=rs.getInt("age")%></td>
			<td><%=rs.getString("department")%></td>
			<td><%=rs.getDouble("salary")%></td>
			<td><%=rs.getString("city")%></td>
			<td><%=rs.getString("phone")%></td>
		</tr>

		<%
		} // end while
		} // end else
		%>

	</table>

</body>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Employee</title>
</head>
<body>

<h2>Add New Employee</h2>

<form action="../addEmployee" method="post">

    <label>Employee Name:</label><br>
    <input type="text" name="emp_name" required><br><br>

    <label>Gender:</label><br>
    <select name="gender" required>
        <option value="">Select</option>
        <option value="Male">Male</option>
        <option value="Female">Female</option>
        <option value="Other">Other</option>
    </select><br><br>

    <label>Age:</label><br>
    <input type="number" name="age" required><br><br>

    <label>Department:</label><br>
    <input type="text" name="department" required><br><br>

    <label>Salary:</label><br>
    <input type="number" step="0.01" name="salary" required><br><br>

    <label>City:</label><br>
    <input type="text" name="city" required><br><br>

    <label>Phone:</label><br>
    <input type="text" name="phone" required><br><br>

    <button type="submit">Add Employee</button>
</form>

</body>
</html>

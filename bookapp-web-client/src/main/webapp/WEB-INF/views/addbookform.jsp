<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="addbook" method="post">
		<table>
			<tr>
				<td>Enter Title</td>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<td>Enter Author</td>
				<td><input type="text" name="author"></td>
			</tr>
			<tr>
				<td>Enter Price</td>
				<td><input type="text" name="price"></td>
			</tr>
			<tr>
				<td>Enter Category</td>
				<td><input type="text" name="category"></td>
			</tr>
			<tr>
			<tr>
				<td colspan = 2><input type=submit value="Add Book" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
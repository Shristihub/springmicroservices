<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form>
 <div>
  Title:  ${book.title}<br>
  Author: ${book.author}<br>
  Price: ${book.price}<br>
  Category: ${book.category}<br>
  <input type=submit value="Order Now" formaction="order/${book.bookId }"/>
  

</div>
</form>
 

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create music genre</title>
</head>
<body>

<%
String genrename = "";
String genredescription = "";
if(request.getParameter("genrename")!=null && request.getParameter("genredescription")!=null){
String genreName = request.getParameter("genrename");
String genreDescr = request.getParameter("genredescription");
}
%>

</body>
</html>
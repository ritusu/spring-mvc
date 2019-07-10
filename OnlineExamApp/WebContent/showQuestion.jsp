<%@page import="java.util.List"%>
<%@page import="com.lti.training.exam.model.Option"%>
<%@page import="com.lti.training.exam.model.Question"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="CalculateScoreServlet">
<%
Question q=(Question)session.getAttribute("currentQs");
%>
<h1>Q <%= q.getQuestion() %></h1>
<% 
int opNo=0;
List<Option> ops=q.getOptions();
for(Option opt :ops) {%>
<input type="radio" name="op" value="<%=opNo++%>"/><%=opt.getOption() %><br/>
<%} %>

<input type="submit" value="Continue"/>

</form>
</body>
</html>
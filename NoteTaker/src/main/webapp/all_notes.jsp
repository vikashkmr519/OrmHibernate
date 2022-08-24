<%@page import="com.entity.Note"%>
<%@page import="org.hibernate.Query"%>
<%@page import="java.util.List"%>
<%@page import="com.helper.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="all_js_css.jsp"%>
</head>
<body>
	<div class="container">
		<%@include file="navbar.jsp"%>
		<br>
		<h1>All Notes:</h1>
		<%
		Session s = FactoryProvider.getFactory().openSession();
		Query q = s.createQuery("from Note");
		List<Note> list = q.list();
		for (Note note : list) {
		%>
		
		<div class="card mt-5">
		<img class="card-img-top m-4" style="max-width:100px;"src="img/pencil.png" alt="card image cap"/>
		<div class="card-body">
		<h5 class="card-title"><%= note.getTitle() %></h5>
		<p class="card-text">
			<%= note.getContent() %>
		</p>
		<a href="DeleteServlet?node_id=<%= note.getId() %>" class="btn btn-danger">Delete</a>
		<a href="" class="btn btn-primary">Edit</a>
		</div>
		</div>
		
		<%
		}
		s.close();
		%>
	</div>

</body>
</html>
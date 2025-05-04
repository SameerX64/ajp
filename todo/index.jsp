<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>To-Do-List</title>
</head>
<body>
	<div class = "container">
		<h1>To-Do List</h1>
		<form action = "ToDoServlet" method = "post">
			<input type = "text" name = "task" required placeholder = "Enter the new task">
			<button type = "submit">Add the task</button>
		</form>
		
		<h2>Tasks:</h2>
		<ul>
			<%
				java.util.List<String> tasks = (java.util.List<String>)session.getAttribute("tasks");
				if(tasks != null){
					for(String t : tasks){
			%>
			<li>
				<span><%=t%></span>
				<a href="ToDoServlet?task=<%=t%>&action=delete">Delete</a>
			</li>
			<% 
				}
			}
			%>
		</ul>
	</div>
</body>
</html>
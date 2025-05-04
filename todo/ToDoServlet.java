package com.todo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;

/**
 * Servlet implementation class ToDoServlet
 */
//@WebServlet("/ToDoServlet")
public class ToDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToDoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String taskDelete = request.getParameter("task");
		String action = request.getParameter("action");
		
		HttpSession ses = request.getSession();
		List<String> tasks = (List<String>) ses.getAttribute("tasks");
		
		if("delete".equals(action) && taskDelete != null && tasks != null) {
			tasks.remove(taskDelete);
		}
		
		response.sendRedirect("index.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String task = request.getParameter("task");
		HttpSession ses = request.getSession();
		List<String> tasks = (List<String>) ses.getAttribute("tasks");
		if(tasks == null) {
			tasks= new ArrayList<>();
			ses.setAttribute("tasks", tasks);
		}
		
		if (task != null && !task.trim().isEmpty()) {
		    tasks.add(task.trim());
		}

		
		response.sendRedirect("index.jsp");
		
	}

}

// 3. CalculatorServlet.java
package com.calculator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CalculatorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Getting input values
        double num1 = Double.parseDouble(request.getParameter("num1"));
        double num2 = Double.parseDouble(request.getParameter("num2"));
        String operation = request.getParameter("operation");
        double result = 0;

        // Performing operation
        switch (operation) {
            case "add": result = num1 + num2; break;
            case "subtract": result = num1 - num2; break;
            case "multiply": result = num1 * num2; break;
            case "divide":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    out.println("<h3 style='color:red;'>Error: Division by zero is not allowed!</h3>");
                    return;
                }
                break;
        }

        // Sending response back
        out.println("<html><head><title>Result</title></head><body>");
        out.println("<h2>Calculation Result:</h2>");
        out.println("<h3>" + num1 + " " + getOperator(operation) + " " + num2 + " = " + result + "</h3>");
        out.println("<a href='index.html'>Go Back</a>");
        out.println("</body></html>");
    }

    private String getOperator(String operation) {
        switch (operation) {
            case "add": return "+";
            case "subtract": return "-";
            case "multiply": return "×";
            case "divide": return "÷";
            default: return "";
        }
    }
}

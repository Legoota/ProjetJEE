package controllers;

import dataservice.AdminDataService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/* Servlet implementation class ServletTest
 */
@WebServlet("/admin")

public class ServletAdmin extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private AdminDataService ads;

    /* @see HttpServlet#HttpServlet()
     */
    public ServletAdmin() {
        super();
    }

    /* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean res = ads.initializeDatabase();
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Admin</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Database " + (res ? "initialized" : "failed initializing") + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    /* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

package controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/* Servlet implementation class ServletTest
 */
@WebServlet("/cookie")

public class ServletCookie extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /* @see HttpServlet#HttpServlet()
     */
    public ServletCookie() {
        super();
    }

    /* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher vue  = request.getRequestDispatcher("/WEB-INF/cookie.jsp");
        vue.forward(request, response);
    }

    /* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        Cookie cookie = new Cookie("nom",nom);

        cookie.setMaxAge(60*60); //1h
        response.addCookie(cookie);
        response.sendRedirect("/Projet_war/cookie");
    }
}
package controllers;

import model.Hello;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ejb.EJB;
import java.io.IOException;

/* Servlet implementation class ServletTest
 */
@WebServlet("/session")

/**
 *
 */
public class ServletSession extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private Hello myHello;

    /* @see HttpServlet#HttpServlet()
     */
    public ServletSession() {
        super();
    }





    /* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher vue  = request.getRequestDispatcher("/WEB-INF/session.jsp");
        vue.forward(request, response);
    }

    /* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession maSession = request.getSession();
        maSession.setAttribute("nom",myHello.toUpperCase(request.getParameter(("nom"))));

        System.out.println("Variable nom de la session: " + maSession.getAttribute("nom"));
        response.sendRedirect("/Projet-1.0/session");
    }
}
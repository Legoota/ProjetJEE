package controllers;

import dataservice.UserDataService;
import model.User;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Arrays;

/**
 * Classe servlet pour la gestion du login de l'utilisateur
 */
@WebServlet("/login/*")
public class ServletLogin extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private UserDataService uds;

    public ServletLogin() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getPathInfo() == null || req.getPathInfo().length()<1){
            RequestDispatcher loginVue  = req.getRequestDispatcher("/WEB-INF/login.jsp");
            loginVue.forward(req, resp);
        }
        else{
            String route = req.getPathInfo().substring(1);
            switch (route){
                case "login":
                    RequestDispatcher loginVue  = req.getRequestDispatcher("/WEB-INF/login.jsp");
                    loginVue.forward(req, resp);
                    break;
                case "logout":
                    Cookie userCookie = new Cookie("pseudo","");
                    userCookie.setPath("/");
                    userCookie.setMaxAge(0);
                    resp.addCookie(userCookie);
                    HttpSession session = req.getSession();
                    session.invalidate();
                    RequestDispatcher logoutVue  = req.getRequestDispatcher("/WEB-INF/logout.jsp");
                    logoutVue.forward(req, resp);
                    break;
                case "signup":
                    RequestDispatcher signupVue  = req.getRequestDispatcher("/WEB-INF/signup.jsp");
                    signupVue.forward(req, resp);
                    break;
                default:
                    RequestDispatcher defaultVue  = req.getRequestDispatcher("/WEB-INF/login.jsp");
                    defaultVue.forward(req, resp);
                    break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String route = req.getPathInfo().substring(1);
        HttpSession loginSession = req.getSession();
        loginSession.setAttribute("login",null);
        switch (route){
            case "login":
                User user = uds.loginUser(req.getParameter("pseudo"),req.getParameter("password"));
                if(user != null) {
                    loginSession.setAttribute("login",null);
                    Cookie userCookie = new Cookie("pseudo",user.getPseudo());
                    HttpSession session = req.getSession();
                    session.setAttribute("uds",uds);
                    userCookie.setMaxAge(60*60); //1h
                    userCookie.setPath("/");
                    resp.addCookie(userCookie);
                    RequestDispatcher userHome  = req.getRequestDispatcher("/WEB-INF/userHome.jsp");
                    userHome.forward(req, resp);
                }
                else {
                    loginSession.setAttribute("login", false);
                    RequestDispatcher loginVue  = req.getRequestDispatcher("/WEB-INF/login.jsp");
                    loginVue.forward(req, resp);
                }
                break;
            case "logout":
                RequestDispatcher logoutVue  = req.getRequestDispatcher("/WEB-INF/login.jsp");
                logoutVue.forward(req, resp);
                break;
            case "signup":
                loginSession.setAttribute("login", null);
                boolean isUserCreated = uds.createUser(req.getParameter("prenom"), req.getParameter("nom"), req.getParameter("pseudo"), req.getParameter("password"));
                if(isUserCreated){
                    RequestDispatcher validateAccountVue  = req.getRequestDispatcher("/WEB-INF/signupsuccess.jsp");
                    validateAccountVue.forward(req, resp);
                }else{
                    RequestDispatcher deniedAccountVue  = req.getRequestDispatcher("/WEB-INF/signup.jsp");
                    deniedAccountVue.forward(req, resp);
                }
                break;
            default:
                RequestDispatcher defaultVue  = req.getRequestDispatcher("/WEB-INF/login.jsp");
                defaultVue.forward(req, resp);
                break;
        }
    }
}

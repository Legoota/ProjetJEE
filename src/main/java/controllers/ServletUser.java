package controllers;

import dataservice.UserDataService;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login/*")
public class ServletUser extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private UserDataService uds;

    public ServletUser() {
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
        switch (route){
            case "login":
                RequestDispatcher loginVue  = req.getRequestDispatcher("/WEB-INF/login.jsp");
                loginVue.forward(req, resp);
                break;
            case "logout":
                RequestDispatcher logoutVue  = req.getRequestDispatcher("/WEB-INF/logout.jsp");
                logoutVue.forward(req, resp);
                break;
            case "signup":
                boolean isUSerCreated = uds.createUser(req.getParameter("prenom"), req.getParameter("nom"), req.getParameter("pseudo"), req.getParameter("password"));
                if(isUSerCreated){
                    RequestDispatcher validateAccountVue  = req.getRequestDispatcher("/WEB-INF/login.jsp");
                    validateAccountVue.forward(req, resp);
                }else{
                    RequestDispatcher deniedAccounVue  = req.getRequestDispatcher("/WEB-INF/signup.jsp");
                    deniedAccounVue.forward(req, resp);
                }
                break;
            default:
                RequestDispatcher defaultVue  = req.getRequestDispatcher("/WEB-INF/login.jsp");
                defaultVue.forward(req, resp);
                break;
        }
    }
}

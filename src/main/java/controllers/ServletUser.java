package controllers;

import dataservice.UserDataService;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/*")
public class ServletUser extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private UserDataService uds;

    public ServletUser() { super(); }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getPathInfo() == null || req.getPathInfo().length()<1){
            RequestDispatcher userHome  = req.getRequestDispatcher("/WEB-INF/userHome.jsp");
            userHome.forward(req, resp);
        }
        else {
            Cookie[] cookies = req.getCookies();
            for(Cookie c: cookies) {
                System.out.println(c.getName() + " : " + c.getValue() + " => " + c.getMaxAge());
            }
            String route = req.getPathInfo().substring(1);
            switch (route) {
                case "userHome":
                    RequestDispatcher userHome  = req.getRequestDispatcher("/WEB-INF/userHome.jsp");
                    userHome.forward(req, resp);
                    break;
                default:
                    RequestDispatcher defautHome  = req.getRequestDispatcher("/WEB-INF/userHome.jsp");
                    defautHome.forward(req, resp);
                    break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

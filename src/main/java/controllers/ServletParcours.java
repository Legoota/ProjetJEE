package controllers;

import dataservice.ParcoursDataService;
import dataservice.PolymonDataService;
import dataservice.UserDataService;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/parcours/*")
public class ServletParcours extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private UserDataService uds;
    @EJB
    private ParcoursDataService pds;
    @EJB
    private PolymonDataService plds;

    public ServletParcours() { super(); }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getPathInfo() == null || req.getPathInfo().length()<1){
            RequestDispatcher userHome  = req.getRequestDispatcher("/WEB-INF/userHome.jsp");
            userHome.forward(req, resp);
        }
        else {
            String route = req.getPathInfo().substring(1);
            Cookie[] cookies = req.getCookies();
            String pseudo = null;
            for(Cookie c : cookies){
                if(c.getName().equals("pseudo")){
                    pseudo = c.getValue();
                }
            }
            switch (route) {
                case "nouveau":
                    HttpSession session = req.getSession();
                    session.setAttribute("plds",plds);
                    RequestDispatcher nouveauParcours  = req.getRequestDispatcher("/WEB-INF/nouveauParcours.jsp");
                    nouveauParcours.forward(req, resp);
                    break;
                case "starter/carapuce":
                    uds.addPolymonToUSer(pseudo,"Polymon_3");
                    break;
                case "starter/salameche":
                    uds.addPolymonToUSer(pseudo,"Polymon_2");
                    break;
                case "starter/bulbizarre":
                    uds.addPolymonToUSer(pseudo,"Polymon_1");
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

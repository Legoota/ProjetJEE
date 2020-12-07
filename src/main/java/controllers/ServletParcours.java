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
            HttpSession session = req.getSession();
            session.setAttribute("pds", pds);
            switch (route) {
                case "nouveau":
                    session.setAttribute("plds",plds);
                    RequestDispatcher nouveauParcours  = req.getRequestDispatcher("/WEB-INF/choixPolymon.jsp");
                    nouveauParcours.forward(req, resp);
                    break;
                case "starter/carapuce":
                    uds.addPolymonToUser(pseudo,"Polymon_3");
                    session.setAttribute("polymon","Polymon_3");
                    resp.sendRedirect("/Projet-1.0/parcours/choixparcours");
                    break;
                case "starter/salameche":
                    uds.addPolymonToUser(pseudo,"Polymon_2");
                    session.setAttribute("polymon","Polymon_2");
                    resp.sendRedirect("/Projet-1.0/parcours/choixparcours");
                    break;
                case "starter/bulbizarre":
                    uds.addPolymonToUser(pseudo,"Polymon_1");
                    session.setAttribute("polymon","Polymon_1");
                    resp.sendRedirect("/Projet-1.0/parcours/choixparcours");
                    break;
                case "choixparcours":
                    RequestDispatcher choixParcours = req.getRequestDispatcher("/WEB-INF/choixParcours.jsp");
                    choixParcours.forward(req, resp);
                case "aventure/Kanto":
                    uds.addParcoursToUser(pseudo, "Parcours_1");
                    System.out.println(uds.getCurrentStep(pseudo).getPolymons());
                    /*
                    RequestDispatcher userParcours = req.getRequestDispatcher("/WEB-INF/userParcours.jsp");
                    userParcours.forward(req,resp);*/
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

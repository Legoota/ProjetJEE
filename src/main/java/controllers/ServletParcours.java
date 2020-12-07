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
            session.setAttribute("uds",uds);
            session.setAttribute("plds",plds);
            switch (route) {
                case "nouveau":
                    RequestDispatcher nouveauParcours  = req.getRequestDispatcher("/WEB-INF/choixPolymon.jsp");
                    nouveauParcours.forward(req, resp);
                    break;
                case "starter/carapuce":
                    uds.addPolymonToUser(pseudo,plds.getPolymonByNom("Carapuce"));
                    session.setAttribute("polymon","Polymon_3");
                    resp.sendRedirect("/Projet-1.0/parcours/choixparcours");
                    break;
                case "starter/salameche":
                    uds.addPolymonToUser(pseudo,plds.getPolymonByNom("Salameche"));
                    session.setAttribute("polymon","Polymon_2");
                    resp.sendRedirect("/Projet-1.0/parcours/choixparcours");
                    break;
                case "starter/bulbizarre":
                    uds.addPolymonToUser(pseudo,plds.getPolymonByNom("Bulbizarre"));
                    session.setAttribute("polymon","Polymon_1");
                    resp.sendRedirect("/Projet-1.0/parcours/choixparcours");
                    break;
                case "choixparcours":
                    RequestDispatcher choixParcours = req.getRequestDispatcher("/WEB-INF/choixParcours.jsp");
                    choixParcours.forward(req, resp);
                    break;
                case "aventure/Kanto":
                    uds.addParcoursToUser(pseudo, "Parcours_1");
                    RequestDispatcher userParcours = req.getRequestDispatcher("/WEB-INF/userParcours.jsp");
                    userParcours.forward(req,resp);
                    break;
                case "step/new":
                    uds.getPolymonAdverseFromUser(pseudo);
                    RequestDispatcher userStepNew = req.getRequestDispatcher("/WEB-INF/userStepPath.jsp");
                    userStepNew.forward(req,resp);
                    break;
                case "step/attaque/0":
                    uds.hitPolymonAdverseFromUser(pseudo,plds.getAttaquesByNom(uds.getPolymonFromUser(pseudo).getNom()).get(0).getDegats());
                    resp.sendRedirect("/Projet-1.0/parcours/step/new");
                    break;
                case "step/attaque/1":
                    uds.hitPolymonAdverseFromUser(pseudo,plds.getAttaquesByNom(uds.getPolymonFromUser(pseudo).getNom()).get(1).getDegats());
                    resp.sendRedirect("/Projet-1.0/parcours/step/new");
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

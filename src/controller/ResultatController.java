package controller;

import model.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/resultats")
public class ResultatController extends HttpServlet {
    private static final String RESULTATS_PAGE_JSP = "/WEB-INF/jsp/resultats.jsp";
    private static final String CONNEXION_PAGE_JSP = "/connexion";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        LoginBean model = new LoginBean();
        HttpSession session = request.getSession();
        if(model.isConnected(request) && (int) session.getAttribute("quest") >= 3){
            request.setAttribute("vict", session.getAttribute("vict"));
            request.setAttribute("quest", session.getAttribute("quest"));
            request.getRequestDispatcher(RESULTATS_PAGE_JSP).forward(request, response);
        }else {
            response.sendRedirect(request.getContextPath() + CONNEXION_PAGE_JSP);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
}
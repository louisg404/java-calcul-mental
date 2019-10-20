package controller;

import bo.User;
import model.LoginBean;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet( name = "homeController", urlPatterns = {"/scores"}, loadOnStartup = 1 )
public class HomeController extends HttpServlet {

    private static final String PAGE_LIST_JSP = "/WEB-INF/jsp/home.jsp";

    public HomeController() {}

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        HttpSession session = request.getSession();
        LoginBean model = new LoginBean();
        User user = new User();

        if(model.isConnected(request)){
            request.getRequestDispatcher(PAGE_LIST_JSP).forward(request, response);
            request.setAttribute("user", user.getPseudo());
            //Remise à zéro au retour sur la home
            session.setAttribute("quest",0);
            session.setAttribute("vict",0);
        }
    }
}

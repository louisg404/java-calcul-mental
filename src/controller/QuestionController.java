package controller;

import bo.Question;
import model.LoginBean;
import model.QuestionBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet( name = "questionController", urlPatterns = {"/questions"}, loadOnStartup = 1 )
public class QuestionController extends HttpServlet {

    private static final String PAGE_JEU_JSP = "/WEB-INF/jsp/jeu.jsp";
    private static final String RESULTATS_PAGE_JSP = "/resultats";

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
        Question expression = new Question();

        if(model.isConnected(request)){
            //Nombre de questions disponibles
            if((int) session.getAttribute("quest") >= 10){
                response.sendRedirect(request.getContextPath() + RESULTATS_PAGE_JSP);
            }
            else {
                //Niveau de difficulté
                expression.construction(1);
                request.setAttribute("expression", expression);
                session.setAttribute("pile", expression.getPile());
                request.getRequestDispatcher(PAGE_JEU_JSP).forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        QuestionBean model = new QuestionBean();
        model.verifReponse(request);
        try {
            model.verifScore(request);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("answer", model);
        doGet(request, response);
    }
}

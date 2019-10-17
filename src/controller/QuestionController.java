package controller;

import bo.Question;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet( name = "questionController", urlPatterns = {"/questions"}, loadOnStartup = 1 )
public class QuestionController extends HttpServlet {

    private static final String PAGE_JEU_JSP = "/WEB-INF/jsp/jeu.jsp";

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

        HttpSession session = request.getSession( );
        List<Question> dataSession = ( List<Question> ) session.getAttribute( "questions" );

        if ( null == dataSession ) {
            dataSession = new ArrayList<>();

            for (int i = 0; i<10; i++) {
                dataSession.add(new Question((int) (Math.random() * (50)), (int) (Math.random() * (50))));
            }

            session.setAttribute( "questions", dataSession );
        }
        request.getRequestDispatcher( PAGE_JEU_JSP ).forward( request, response );
    }
}

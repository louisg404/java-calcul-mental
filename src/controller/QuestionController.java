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

@WebServlet( name = "questionController", urlPatterns = {"/questions"} )
public class QuestionController extends HttpServlet {

    private static final String PAGE_JEU_JSP = "/WEB-INF/jsp/jeu.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        HttpSession session = request.getSession( true );


        List<Question> dataSession = ( List<Question> ) session.getAttribute( "questions" );

        if ( null == dataSession ) {
            dataSession = new ArrayList<>();
            //10 questions
            dataSession.add(new Question(15, 12));
            dataSession.add(new Question(15, 12));
            dataSession.add(new Question(15, 12));
            dataSession.add(new Question(15, 12));
            dataSession.add(new Question(15, 12));
            session.setAttribute( "questions", dataSession );
        }

        String action = request.getParameter( "action" );
        if ( null == action ) {
            request.getRequestDispatcher( PAGE_JEU_JSP ).forward( request, response );
        } else {
            int id;
            try {
                id = Integer.parseInt( request.getParameter( "id" ) );
            } catch ( Exception e ) {
                id = -1;
            }
        }
    }
}

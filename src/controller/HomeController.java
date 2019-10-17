package controller;

import bo.Score;

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

@WebServlet( name = "homeController", urlPatterns = {"/scores"}, loadOnStartup = 1 )
public class HomeController extends HttpServlet {

    private static final String PAGE_LIST_JSP = "/WEB-INF/jsp/home.jsp";
    private static final String PAGE_EDIT_JSP = "/questions";
    private static final Logger LOGGER = Logger.getLogger( HomeController.class.getName() );
    private int counter;

    public HomeController() {
        LOGGER.log( Level.INFO, "Je suis dans le constructeur !" );
    }

    @Override
    public void init() throws ServletException {
        LOGGER.log( Level.INFO, "Je suis dans le init !" );
        super.init();
    }

    @Override
    public void destroy() {
        LOGGER.log( Level.INFO, "Je suis dans le destroy !" );
        super.destroy();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {


        LOGGER.log( Level.INFO, "Je suis dans le GET !" );

        HttpSession session = request.getSession( );


        List<Score> dataSession = ( List<Score> ) session.getAttribute( "scores" );

        if ( null == dataSession ) {
            dataSession = new ArrayList<>();
            dataSession.add( new Score( 5, 1 ) );
            dataSession.add( new Score( 7, 1 ) );
            session.setAttribute( "scores", dataSession );
        }

        String action = request.getParameter( "action" );
        if ( null == action ) {
            request.getRequestDispatcher( PAGE_LIST_JSP ).forward( request, response );
        } else {
            int id;
            try {
                id = Integer.parseInt( request.getParameter( "id" ) );
            } catch ( Exception e ) {
                id = -1;
            }
            switch ( action ) {
                case "jeu":
                    request.getRequestDispatcher( PAGE_EDIT_JSP ).forward( request, response );
                    break;
                default:
                    response.sendRedirect( request.getContextPath() + "/scores" );
            }
        }
    }
}

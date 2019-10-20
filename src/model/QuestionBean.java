package model;

import bo.User;
import dal.DAOFactory;
import dal.UserDAOJDBC;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.Stack;

public class QuestionBean {

    private Double reponse;

    public QuestionBean() {}

    public void verifReponse(HttpServletRequest request){

        //On récupère le name de l'input du form : reponse
        reponse = Double.valueOf(request.getParameter("reponse"));
        HttpSession session = request.getSession();
        Stack<Double> reponseTrue = (Stack<Double>) session.getAttribute("pile");
        //On check si le résultat est proche au centième près
        if (Math.abs(reponse - reponseTrue.pop()) < 0.01){
            session.setAttribute("vict", (int) session.getAttribute("vict") + 1);
        }
        session.setAttribute("quest", (int) session.getAttribute("quest") + 1);
    }

    public void verifScore(HttpServletRequest request) throws SQLException {

        HttpSession session = request.getSession();
        UserDAOJDBC dao = (UserDAOJDBC) DAOFactory.getUserDAO();
        User user = (User) session.getAttribute("isConnected");

        //Méthode UPDATE pas finie
//        if(user.getBest() < ???????)){
//            dao.update(user);
//        }
    }
}

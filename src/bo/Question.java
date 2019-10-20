package bo;

import java.util.Random;
import java.util.Stack;
import java.util.concurrent.ThreadLocalRandom;

public class Question {

    private Stack<Double> pile;
    private String expression;
    private boolean bool;

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public Stack<Double> getPile() {
        return pile;
    }

    public void setPile(Stack<Double> pile) {

        this.pile = pile;
    }

    public Question() {

        pile = new Stack<>();
        expression = "";
        bool = true;
    }

    //Premier random avec des INT
    public int random(int min, int max) {

        Random r = new Random();
        return r.nextInt(max - min) + min;
    }

    //Second random avec des DOUBLE
    public Double random(Double min, Double max) {

        return ThreadLocalRandom.current().nextDouble(min, max);
    }

    public void randomPush(){

        Double rand = random(0.0, 100.0);
        rand = Math.floor(rand * 100) / 100;

        //On ajoute à la pile
        pile.push(rand);

        //Si c'est la première fois alors...
        if(bool){
            expression = rand + "";
            bool = false;
        }
    }

    //On construit une expression
    public void construction(int length) {

        randomPush();
        //Boucle qui permet un niveau de difficulté
        for (int i = 0; i < length; i++) {
            if (pile.size() == 1) {
                randomPush();
            } else if (pile.size() >= 2) {
                signe();
                randomPush();
            }
            signe();
        }
    }

    //Génération d'un signe opérateur aléatoire
    public void signe(){

        Double nb1 = pile.pop();
        Double nb2 = pile.pop();
        int randomSigne = random(0,3);

        switch (randomSigne)
        {
            case 0:
                expression = expression + " + " + nb1;
                nb1 = nb2 + nb1;
                break;
            case 1:
                expression = expression + " - " + nb1;
                nb1 = nb2 - nb1;
                break;
            case 2:
                expression = expression + " * " + nb1;
                nb1 = nb2 * nb1;
                break;
            case 3:
                expression = expression + " / " + nb1;
                nb1 = nb2 / nb1;
                break;
        }
        pile.push(nb1);
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author Utilisateur
 */
public class Rectangle {

    /**
     * abcisse du coin supérieur gauche du rectangle
     */
    public float x1;
    /**
     * ordonee du coin supérieur gauche du rectangle
     */
    public float y1;
    /**
     * abcisse du coin inferieur droit du rectangle
     */
    public float x2;
    /**
     * ordonee du coin inferieur droit du rectangle
     */
    public float y2;
    
    /**
     * booleen qui permet d activer ou de desactiver les interactions avec ce rectangle
     */
    public boolean isEnabled = true;

    /**
     * constructeur
     * @param x1 abcisse du coin supérieur gauche du rectangle
     * @param y1 ordonee du coin supérieur gauche du rectangle
     * @param x2 abcisse du coin inferieur droit du rectangle
     * @param y2 ordonee du coin inferieur droit du rectangle
     */
    public Rectangle(float x1, float y1, float x2, float y2) {
        // On définit la zone de clic 
        if (x1 < x2) {
            this.x1 = x1;
            this.x2 = x2;
        } else {
            this.x1 = x2;
            this.x2 = x1;
        }
        if (y1 < y2) {
            this.y1 = y1;
            this.y2 = y2;
        } else {
            this.y1 = y2;
            this.y2 = y1;
        }

    }

    /**
     * fonction qui prend en parametre les coordonees carthesiennes d un point et qui renvoie true ou false suivant si ce point est dans le rectangle ou non
     * @param x abcisse du point
     * @param y ordonee du point
     * @return true ou false suivant si le point est dans le rectangle ou non
     */
    public boolean Check(double x, double y) {
        if(!isEnabled)return false;
        return x1 <= x && x <= x2 && y1 <= y && y <= y2;

    }

}

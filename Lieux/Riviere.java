/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lieux;

import Main.Jeu;
import Main.Rectangle;


/**
 *
 * @author romai
 */
public class Riviere extends Lieu {

    /**
     * r1 correspond au rectangle permettant d aller dans le lieu stand
     */
    Rectangle r1 = new Rectangle(0, 643, 344, 797);
    /**
     * r2 correspond au rectangle permettant d aller dans le lieu radeau
     */
    Rectangle r2 = new Rectangle(0, 146, 80, 252);
    /**
     * r3 correspond au rectangle permettant d aller dans le lieu serre
     */
    Rectangle r3 = new Rectangle(1026, 486, 1197, 696);
    
    /**
     * Constructeur de la riviere
     * @param className nom du lieu
     * @param jeu instance du jeu
     */
    public Riviere(String className, Jeu jeu) {
        super(className, jeu);
        //on ajoles rectangles a la liste des rectangles du lieu
        listeRectangle.add(r1);
        listeRectangle.add(r2);
        listeRectangle.add(r3);

    }

    /**
     * fonction qui execute une action en fonction du rectangle sur lequel le joueur clique
     * @param i indice du rectangle
     */
    @Override
    public void Action(int i) {
        if (i == 0) {
            this.jeu.changerLieu(4); //stand
        }
        if (i == 1) {
            this.jeu.changerLieu(8); //radeau
        }
        if (i == 2) {
            this.jeu.changerLieu(6); //serre
        }

    }
}

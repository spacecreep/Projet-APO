/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lieux;

import Main.Jeu;
import Main.Rectangle;
import Personnages.Kaki;

/**
 *
 * @author romai
 */
public class Stand extends Lieu {

    /**
     * r1 correspond au rectangle permettant d aller dans le lieu place
     */
    Rectangle r1 = new Rectangle(0, 614, 381, 798);
    /**
     * r2 correspond au rectangle permettant d aller dans le lieu riviere
     */
    Rectangle r2 = new Rectangle(421, 386, 522, 491);
    /**
     * r3 correspond au rectangle permettant de parler a kaki
     */
    Rectangle r3 = new Rectangle(594, 242, 1172, 656);

    /**
     * l'instance du personnage present dans ce lieu
     */
    public Kaki kaki = new Kaki(this.jeu);
    
    /**
     * Constructeur du stand
     * @param className nom du lieu
     * @param jeu instance du jeu
     */
    public Stand(String className, Jeu jeu) {
        super(className, jeu);
        //on ajoute les rectangles a la liste des rectangles du lieu
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
            this.jeu.changerLieu(1); //place
        }
        if (i == 1) {
            this.jeu.changerLieu(5);} //riviere
        if (i == 2) {
            this.kaki.Parler(); //on lance le dialogue avec kaki
        }
        
    }
}

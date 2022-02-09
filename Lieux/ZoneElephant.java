/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lieux;

import Main.Jeu;
import Main.Rectangle;
import Personnages.Elephant;
import Personnages.Souris;


/**
 *
 * @author Utilisateur
 */public class ZoneElephant extends Lieu{
    /**
     * r1 correspond au rectangle permettant d aller dans le lieu place
     */
    Rectangle r1 = new Rectangle(0,466,374,734);
    /**
     * r2 correspond au rectangle permettant de parler a dumbo
     */
    Rectangle r2 = new Rectangle(500,233,1050,556);
    /**
     * r3 correspond au rectangle permettant de parler a jerry
     */
    Rectangle r3 = new Rectangle(966,574,1076,694);
    
    /**
     * l'instance du personnage present dans ce lieu (elephant)
     */
    public Elephant dumbo = new Elephant(this.jeu);
    
    /**
     * l'instance du personnage present dans ce lieu (souris)
     */
    public Souris jerry = new Souris(this.jeu,dumbo);
    
    /**
     * Constructeur de la zone avec elephant
     * @param className nom du lieu
     * @param jeu instance du jeu
     */
    public ZoneElephant(String className, Jeu jeu) {
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
    public void Action(int i){
        if(i == 0){
            this.jeu.changerLieu(1); //place
        }
        if(i == 1){
            this.dumbo.Parler(); //on lance le dialogue avec dumbo
        }
        if(i==2){
            this.jerry.Parler(); //on lance le dialogue avec jerry
        }
    }
    
}


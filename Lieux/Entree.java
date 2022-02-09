/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lieux;

import Main.Jeu;
import Main.Rectangle;
import Personnages.MonsieurBaldini;

/**
 *
 * @author romai
 */
public class Entree extends Lieu{
    
    /**
     * r1 correspond au rectangle de mrbaldini
     */
    Rectangle r1 = new Rectangle(562,281,1120,600);
    /**
     * r2 correspond au rectangle de l entree du zoo
     */
    Rectangle r2 = new Rectangle(466,27,736,156);
    
    /**
     * l'instance du personnage present dans ce lieu (mr baldini)
     */
    public MonsieurBaldini MrBaldini = new MonsieurBaldini(this.jeu);
    
    /**
     * Constructeur de l entree
     * @param className nom du lieu
     * @param jeu instance du jeu
     */
    public Entree(String className, Jeu jeu) {
        super(className, jeu);
        //on ajoute les rectangles a la liste des rectangles du lieu
        listeRectangle.add(r1);
        listeRectangle.add(r2);
    }
    
    /**
     * fonction qui execute une action en fonction du rectangle sur lequel le joueur clique
     * @param i indice du rectangle
     */
    @Override
    public void Action(int i){
        if(i == 0){
            this.MrBaldini.Parler();
        }
        if(i == 1){
            if(!this.MrBaldini.zooOuvert){
                this.MrBaldini.Parler();
                return;
            }
            this.jeu.changerLieu(1);
        }
    }
    
}

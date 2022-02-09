/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lieux;

import Main.Jeu;
import Main.Rectangle;
import javafx.scene.image.Image;

/**
 *
 * @author Utilisateur
 */
public class Serre extends Lieu {
    /**
     * r1 correspond au rectangle permettant d aller dans le lieu tournant
     */
    Rectangle r1 = new Rectangle(0,618,228,797);
    /**
     * r2 correspond au rectangle permettant de ramasser la pelle
     */
    Rectangle r2 =  new Rectangle(829,519,982,700);
    
    /**
     * Constructeur de la serre
     * @param className nom du lieu
     * @param jeu instance du jeu
     */
    public Serre(String className, Jeu jeu) {
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
            this.jeu.changerLieu(6); //tournant
        }
        
        if(i == 1){
            if (this.jeu.joueur.inventaire.hasItem("Pelle")==false){ //if superflu mais permet d eviter des bugs innatendus
                
                this.jeu.joueur.inventaire.addItem("Pelle"); //ajout de l objet
                this.jeu.lieuActuel.background = new Image(this.getClass().getResourceAsStream("Backgrounds/Serre/Serre_SansPelle.png")); //on change l image du lieu
                this.listeRectangle.get(2).isEnabled = false; //le joueur ne peut plus interagir avec la pelle
                this.jeu.lieuActuel.Update(); //on actualise l image du lieu
                
            }
            
        }
    }
}
    


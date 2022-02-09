/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lieux;

import Main.Jeu;
import Main.Rectangle;
import javafx.scene.image.Image;

/**
 *
 * @author romai
 */
public class Place extends Lieu{
    /**
     * r1 correspond au rectangle permettant d aller dans le lieu zonegirafe
     */
    Rectangle r1 = new Rectangle(0,136,83,246);
    /**
     * r2 correspond au rectangle permettant d aller dans le lieu stand
     */
    Rectangle r2 = new Rectangle(994,0,1193,140);
    /**
     * r3 correspond au rectangle permettant d aller dans le lieu zoneelephant
     */
    Rectangle r3 = new Rectangle(1081,368,1191,490);
    /**
     * r4 correspond au rectangle permettant de ramasser la buche
     */
    Rectangle r4 =  new Rectangle(643,272,859,363);
    
    /**
     * Constructeur de la place
     * @param className nom du lieu
     * @param jeu instance du jeu
     */
    public Place(String className, Jeu jeu) {
        super(className, jeu);
        //on ajoute les rectangles a la liste des rectangles du lieu
        listeRectangle.add(r1);
        listeRectangle.add(r2);
        listeRectangle.add(r3);
        listeRectangle.add(r4);
        r2.isEnabled = false;
    }
    
    /**
     * fonction qui execute une action en fonction du rectangle sur lequel le joueur clique
     * @param i indice du rectangle
     */
    @Override
    public void Action(int i){
        if(i == 0){
            this.jeu.changerLieu(3); //zonegirafe
        }
        if(i == 1){
            this.jeu.changerLieu(4); //stand
        }
        if(i == 2){
            this.jeu.changerLieu(2); //zoneelephant
        }
        if(i == 3){ //le joueur ramasse le bois
            if (this.jeu.joueur.inventaire.hasItem("Bois")==false){ //ce if est superflu mais permets d eviter un bug innatendu
                this.jeu.joueur.inventaire.addItem("Bois"); //on ajoute l objet a l inventaire du joueur
                this.jeu.lieuActuel.background = new Image(this.getClass().getResourceAsStream("Backgrounds/Place/Place_sansbuche.png")); //on change l image de fond du lieu afin qu on ne voie plus la buche
                this.listeRectangle.get(4).isEnabled = false; //le joueur ne pourra plus interagir avec le rectangle de la buche
                this.jeu.lieuActuel.Update(); //on actualise l image du lieu
                r2.isEnabled = true; //le joueur peut enfin aller au lieu dont le chemin etait bloque par la buche
            }
            
        }
    }
    
}

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
public class Radeau extends Lieu{
    boolean estRepare;
    /**
     * r1 correspond au rectangle permettant d aller dans le lieu riviere
     */
    Rectangle r1 = new Rectangle(1034,446,1198,644);
    /**
     * r2 correspond au rectangle permettant d interagir avec le radeau
     */
    Rectangle r2 = new Rectangle(648,451,833,646);
    
    /**
     * Constructeur du lieu avec le radeau
     * @param className nom du lieu
     * @param jeu instance du jeu
     */
    public Radeau(String className, Jeu jeu) {
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
            this.jeu.changerLieu(5); //riviere
        }

        if(i == 1){
            if(!estRepare){ //si le radeau n est pas repare, un dialogue s affiche pour dire au joueur qu il doit trouver comment le reparer
                
                this.jeu.dialogue.ChangerTexte("Il faudrait peut-être le réparer...");
                this.jeu.persoDialogue = null;
                this.jeu.dialogue.Afficher(this.jeu.joueur);
            }
            if (this.jeu.joueur.inventaire.hasItem("Bois")==true && this.jeu.joueur.inventaire.hasItem("Corde")){ //si le joueur a les objets pour reparer le radeau
                
                //on change l image du lieu pour afficher le radeau repare
                this.jeu.main.background.setImage(new Image(this.jeu.lieuActuel.getClass().getResourceAsStream("Backgrounds/Radeau/RadeauRepare_PpEtonne.png")));
                this.jeu.lieuActuel.background = new Image(this.jeu.lieuActuel.getClass().getResourceAsStream("Backgrounds/Radeau/RadeauRepare_PpEtonne.png"));
                
                estRepare= true; //le radeau est repare
                
                //on retire les objets de l inventaire du joueur
                this.jeu.joueur.inventaire.removeItem("Bois");
                this.jeu.joueur.inventaire.removeItem("Corde");
                
                return;   
            }
            if (estRepare == true){ //si le radeau est repare le joueur pour l utiliser
                    this.jeu.changerLieu(9); //zoneotarie
                }
                    
        }
    }
    
}

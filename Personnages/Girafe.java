/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personnages;

import Main.Jeu;
import javafx.scene.image.Image;

/**
 *
 * @author Utilisateur
 */
public class Girafe extends Personnage{
    
    /**
     * booleen qui est true ou false suivant si il a ete sauve ou non
     */
    public boolean rescued = false;
    
    /**
     * constructeur
     * @param jeu instance du jeu
     */
    public Girafe(Jeu jeu) {
        super("Sophie", jeu);
    }
    
    /**
     * fonction qui fait avancer le dialogue entre ce personnage et le joueur
     */
    @Override
    public void Parler(){
        //le code du dialogue est assez explicite, au fur et a mesure de l avancee on affiche des messages et on ajoute enleve des objets ou on change les fonds du lieu
        switch(etapeDialogue){
            case(0):
                this.jeu.dialogue.ChangerTexte("Je suis bloquée..snif..");
                this.jeu.dialogue.Afficher(this);
               
                
                this.jeu.main.background.setImage(new Image(this.jeu.lieuActuel.getClass().getResourceAsStream("Backgrounds/ZoneGirafe/ZoneGirafe_étonné_avecgirafe.png")));
                
                return;
                
            case(1):
                this.jeu.dialogue.ChangerTexte(" Salut! Tu as besoin d’aide?");
                this.jeu.dialogue.Afficher(this.jeu.joueur);
                return;
                
                
            case(2):
                this.jeu.dialogue.ChangerTexte("Bonjour.. Ce gros tas de terre m’empêche de rejoindre ma famille...");
                this.jeu.dialogue.Afficher(this);
                return;
                
            case(3):
                this.jeu.dialogue.ChangerTexte("Ah mince! Qu’est-ce qui pourrait m’être utile?");
                this.jeu.dialogue.Afficher(this.jeu.joueur);
                this.jeu.main.background.setImage(new Image(this.jeu.lieuActuel.getClass().getResourceAsStream("Backgrounds/ZoneGirafe/ZoneGirafe_intrigué_avecgirafe.png")));
                return;
                
                
                
            case(4):
                if(this.jeu.joueur.inventaire.hasItem("Pelle")){   
                    this.jeu.dialogue.ChangerTexte("Oh merci tu m'as débloqué!");
                    this.jeu.dialogue.Afficher(this);
                    this.jeu.joueur.inventaire.removeItem("Pelle");
                    this.etapeDialogue = 6;
                    rescued = true;
                    this.Parler();
                }
                else{
                    this.jeu.dialogue.ChangerTexte("Snif.. Snif..");
                    this.jeu.dialogue.Afficher(this);
                    
                    this.jeu.main.background.setImage(new Image(this.jeu.lieuActuel.getClass().getResourceAsStream("Backgrounds/ZoneGirafe/ZoneGirafe_triste_avecgirafe.png")));
                }
                return;
            case(5):
                this.jeu.dialogue.Cacher();
                this.etapeDialogue = 4;
                return;
                
            case(6):
                this.jeu.dialogue.ChangerTexte("Merci cher inconnu! Voici un petit cadeau pour te remercier,A bientôt!");
                this.jeu.dialogue.Afficher(this);
                this.jeu.joueur.inventaire.addItem("Corde");
                this.jeu.main.background.setImage(new Image(this.jeu.lieuActuel.getClass().getResourceAsStream("Backgrounds/ZoneGirafe/ZoneGirafe_sauvé.png")));
                return;
            case(7):
                this.jeu.dialogue.Cacher();

                
                this.jeu.main.background.setImage(new Image(this.jeu.lieuActuel.getClass().getResourceAsStream("Backgrounds/ZoneGirafe/ZoneGirafe_sansgirafe.png")));
                this.jeu.lieuActuel.background = new Image(this.jeu.lieuActuel.getClass().getResourceAsStream("Backgrounds/ZoneGirafe/ZoneGirafe_sansgirafe.png"));
                this.jeu.lieuActuel.listeRectangle.get(2).isEnabled = false;
                this.jeu.GirafeSauve = true;
                this.jeu.main.music.PlayMusic("perso_sauve.mp3");
                
        } 
        
            
    }
    
}
    
    


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
public class Otarie extends Personnage {
    
    /**
     * constructeur
     * @param jeu instance du jeu
     */
     public Otarie(Jeu jeu) {
        super("Watson", jeu);
        
     }
     
     /**
     * fonction qui fait avancer le dialogue entre ce personnage et le joueur
     */
    @Override
    public void Parler(){
        //le code du dialogue est assez explicite, au fur et a mesure de l avancee on affiche des messages et on ajoute enleve des objets ou on change les fonds du lieu
        switch(etapeDialogue){
            case(0):
                this.jeu.dialogue.ChangerTexte("Oh ! Eh ! A l’aide");
                this.jeu.dialogue.Afficher(this);
               
                
                
                
                return;
                
            case(1):
                this.jeu.dialogue.ChangerTexte("Que se passe-t-il Watson ? Tu es coincé ?");
                this.jeu.dialogue.Afficher(this.jeu.joueur);
                return;
                
                
            case(2):
                this.jeu.dialogue.ChangerTexte("Le barrage a stoppé l’eau! Je ne peux pas emprunter le cours d’eau :/");
                this.jeu.dialogue.Afficher(this);
                return;
                
            case(3):
                this.jeu.dialogue.ChangerTexte("Hmm… Comment aider Watson ?");
                this.jeu.dialogue.Afficher(this.jeu.joueur);
                this.jeu.main.background.setImage(new Image(this.jeu.lieuActuel.getClass().getResourceAsStream("Backgrounds/ZoneOtarie/ZoneOtarie_PpQuestion.png")));
                return;
                
                
                
            case(4):
                if(this.jeu.joueur.inventaire.hasItem("Cle")){   
                    this.jeu.dialogue.ChangerTexte("Ohh! L'eau est libérée!!");
                    this.jeu.dialogue.Afficher(this);
                    this.jeu.main.background.setImage(new Image(this.jeu.lieuActuel.getClass().getResourceAsStream("Backgrounds/ZoneOtarie/ZoneOtarie_WatsonLibre.png")));
                    this.jeu.joueur.inventaire.removeItem("Cle");
                    this.etapeDialogue = 6;
                    
                    this.Parler();
                }
                else{
                    this.jeu.dialogue.ChangerTexte("Je ne peux plus avancer…");
                    this.jeu.dialogue.Afficher(this);
                    
                    this.jeu.main.background.setImage(new Image(this.jeu.lieuActuel.getClass().getResourceAsStream("Backgrounds/ZoneOtarie/ZoneOtarie_PpInquiet.png")));
                }
                return;
            case(5):
                this.jeu.dialogue.Cacher();
                this.etapeDialogue = 4;
                return;
                
            case(6):
                this.jeu.dialogue.ChangerTexte("Merci PoucePouce ! Grâce à toi je vais pouvoir aller retrouver mes amis ! A bientôt !");
                this.jeu.dialogue.Afficher(this);
                this.jeu.main.background.setImage(new Image(this.jeu.lieuActuel.getClass().getResourceAsStream("Backgrounds/ZoneOtarie/ZoneOtarie_SansWatson.png")));
                
                return;
            case(7):
                this.jeu.dialogue.Cacher();

                
                this.jeu.main.background.setImage(new Image(this.jeu.lieuActuel.getClass().getResourceAsStream("Backgrounds/ZoneOtarie/ZoneOtarie_SansWatson.png")));
                this.jeu.lieuActuel.background = new Image(this.jeu.lieuActuel.getClass().getResourceAsStream("Backgrounds/ZoneOtarie/ZoneOtarie_SansWatson.png"));
                this.jeu.lieuActuel.listeRectangle.get(2).isEnabled = false;
                
                this.jeu.otarieSauve = true;
                this.jeu.main.music.PlayMusic("perso_sauve.mp3");
                
    }
}
}

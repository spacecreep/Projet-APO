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
public class MonsieurBaldini extends Personnage{
    
    public boolean zooOuvert = false;
    
    /**
     * constructeur
     * @param jeu instance du jeu
     */
    public MonsieurBaldini(Jeu jeu){
        super("MonsieurBaldini", jeu);
    }
    
    /**
     * fonction qui fait avancer le dialogue entre ce personnage et le joueur
     */
    @Override
    public void Parler(){
        //le code du dialogue est assez explicite, au fur et a mesure de l avancee on affiche des messages et on ajoute enleve des objets ou on change les fonds du lieu
        switch(etapeDialogue){
            case(0):
                this.jeu.dialogue.ChangerTexte("Bonjour et Bienvenue au zoo d'Alès! Je suis heureux de vous accueillir"+"\n pour son inauguration. \nJe vous souhaite une excellente visite.");
                this.jeu.dialogue.Afficher(this);
                return;
                        
                        
            case(1):
                this.jeu.dialogue.ChangerTexte("Bonjour Mr Baldini!");
                this.jeu.dialogue.Afficher(this.jeu.joueur);
                
                return;
                
            case(2):
                 this.jeu.dialogue.ChangerTexte("Oh! Pouce pouce...Content de te voir.. J'ai besoin de ton aide.."+"\nCertains animaux se sont perdus et je ne peux pas m'en occuper"+"\nEst-ce que tu pourrais m'aider à les retrouver?");
                this.jeu.dialogue.Afficher(this);
                return;
                
            case(3):
                 this.jeu.dialogue.ChangerTexte("Oui bien-sûr!");
                this.jeu.dialogue.Afficher(this.jeu.joueur);
                this.jeu.main.background.setImage(new Image(this.jeu.lieuActuel.getClass().getResourceAsStream("Backgrounds/Entree/Entree_pphappy.png")));
                return;
               
            case(4):
                
                
                this.jeu.dialogue.ChangerTexte("Super!Une fois que tu les auras trouvé, tu auras sûrement besoin d'objets "+"\npour les aider: tu pourras les trouver lors de tes déplacements!"
                        +"\nVoici une liste qui récapitule tout (clique dessus pour la consulter)..\n Merci et bonne chance!");
                this.jeu.dialogue.Afficher(this);
                this.jeu.joueur.inventaire.addItem("Liste");
                return;
                
            case(5):
                this.jeu.dialogue.Cacher();
                this.zooOuvert = true;
                this.etapeDialogue += 1;
                return;
                
            case(6):
                
                this.jeu.dialogue.ChangerTexte("Aide moi à retrouver les animaux du zoo Pouce Pouce !");
                this.jeu.dialogue.Afficher(this);
                return;
            case(7):
                this.jeu.dialogue.Cacher();
                this.etapeDialogue = 6;
                return;
            
        }
    }
}





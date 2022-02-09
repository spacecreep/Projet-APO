/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personnages;

import Main.Jeu;
import javafx.scene.image.Image;

/**
 *
 * @author romai
 */
public class Elephant extends Personnage {

    /**
     * booleen qui est true ou false suivant si il a ete sauve ou non
     */
    public boolean rescued = false;

    /**
     * constructeur
     * @param jeu instance du jeu
     */
    public Elephant(Jeu jeu) {
        super("Dumbo", jeu);
    }

    /**
     * fonction qui fait avancer le dialogue entre ce personnage et le joueur
     */
    @Override
    public void Parler() {
        if (this.rescued == true && etapeDialogue < 8) {//si jamais le joueur a deja donne les cacahuetes a la souris, le dialogue saute des etapes
            etapeDialogue = 8;}
            switch (etapeDialogue) {

                //le code du dialogue est assez explicite, au fur et a mesure de l avancee on affiche des messages et on ajoute enleve des objets ou on change les fonds du lieu
                case (0):
                    this.jeu.persoDialogue = this;
                    this.jeu.dialogue.ChangerTexte(" Oh mais c'est Dumbo!! Pourquoi restes-tu caché? ");
                    this.jeu.dialogue.Afficher(this.jeu.joueur);
                    return;

                case (1):
                    this.jeu.dialogue.ChangerTexte("J'ai peur...");
                    this.jeu.dialogue.Afficher(this);
                    return;

                case (2):
                    this.jeu.dialogue.ChangerTexte("Peur de quoi?");
                    this.jeu.dialogue.Afficher(this.jeu.joueur);
                    return;

                case (3):
                    this.jeu.dialogue.ChangerTexte("Là.. juste en dessous.. AHHH!");
                    this.jeu.dialogue.Afficher(this);
                    return;

                case (4):
                    this.jeu.dialogue.ChangerTexte("Une souris! Comment vais-je faire pour l'aider?");
                    this.jeu.main.background.setImage(new Image(this.jeu.lieuActuel.getClass().getResourceAsStream("Backgrounds/ZoneElephant/ZoneElephant_PpPerplexe.png")));

                    this.jeu.dialogue.Afficher(this.jeu.joueur);

                    return;

                case (5):
                    this.jeu.dialogue.ChangerTexte("AHH!!");
                    this.jeu.dialogue.Afficher(this);

                    return;
                case (6):
                    this.jeu.dialogue.ChangerTexte("Je n'arrive pas à bouger ... Si seulement quelqu'un pouvait la faire partir...");
                    this.jeu.dialogue.Afficher(this);

                    return;

                case (7):
                    this.jeu.dialogue.Cacher();
                    this.etapeDialogue = 6;

                    return;

                case (8):

                    this.jeu.dialogue.ChangerTexte(" OUF! Merci ! tu me sauves la vie.. Qui es-tu?");
                    this.jeu.dialogue.Afficher(this);                                                                                                                                                                  

                    return;

                case (9):

                    this.jeu.dialogue.ChangerTexte("Pas de soucis, moi c'est PoucePouce et toi?");
                    this.jeu.dialogue.Afficher(this.jeu.joueur);
                    return;

                case (10):
                    this.jeu.dialogue.ChangerTexte("Enchanté Poucepouce, Moi c'est Dumbo! Je vais pouvoir"+"\n retourner voir ma maman!Merci voici un petit cadeau");
                    
                    this.jeu.dialogue.Afficher(this);
                    return;

                case (11):
                    this.jeu.dialogue.Cacher();
                    this.jeu.joueur.inventaire.addItem("Cle");
                    this.jeu.main.background.setImage(new Image(this.jeu.lieuActuel.getClass().getResourceAsStream("Backgrounds/ZoneElephant/ZoneElephant_SansPersonne.png")));
                    this.jeu.dialogue.Cacher();
                    this.jeu.lieuActuel.background = new Image(this.jeu.lieuActuel.getClass().getResourceAsStream("Backgrounds/ZoneElephant/ZoneElephant_SansPersonne.png"));
                    this.jeu.lieuActuel.listeRectangle.get(2).isEnabled = false;
                    this.jeu.lieuActuel.listeRectangle.get(3).isEnabled = false;
                    this.jeu.ElephantSauve = true;
                    this.jeu.main.music.PlayMusic("perso_sauve.mp3");
                    
            }
        }

    }

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
public class Souris extends Personnage {

    /**
     * booleen qui est true ou false suivant si il a ete sauve ou non
     */
    public boolean rescued = false;
    
    public Elephant dumbo;

    /**
     * constructeur
     * @param jeu instance du jeu
     */
    public Souris(Jeu jeu, Elephant dumbo) {
        super("Jerry", jeu);
        this.dumbo = dumbo;
    }

    /**
     * fonction qui fait avancer le dialogue entre ce personnage et le joueur
     */
    @Override
    public void Parler() {
        //le code du dialogue est assez explicite, au fur et a mesure de l avancee on affiche des messages et on ajoute enleve des objets ou on change les fonds du lieu
        switch (etapeDialogue) {

            case (0):
                this.jeu.dialogue.ChangerTexte("♪ Lalalala ♪… Lalala♪…");
                this.jeu.dialogue.Afficher(this);
                return;
            case (1):
                this.jeu.dialogue.ChangerTexte("Bonjour, est-ce que tu pourrais partir? Tu fais peur à Dumbo!");
                this.jeu.dialogue.Afficher(this.jeu.joueur);
                return;
            case (2):
                this.jeu.dialogue.ChangerTexte("Pourquoi donc? Ici c’est chez moi… Mais je peux bien m’éclipser si tu as quelque chose"+"\n en échange …");
                this.jeu.dialogue.Afficher(this);
                return;

            case (3):
                if (this.jeu.joueur.inventaire.hasItem("Cacahuètes")) {
                    this.jeu.dialogue.ChangerTexte("Miam merci !");
                    this.jeu.dialogue.Afficher(this);
                    this.jeu.main.background.setImage(new Image(this.jeu.lieuActuel.getClass().getResourceAsStream("Backgrounds/ZoneElephant/ZoneElephant_SansJerry.png")));
                    this.jeu.joueur.inventaire.removeItem("Cacahuètes");
                    dumbo.rescued = true;
                    this.etapeDialogue = 4;

                } else {
                    this.jeu.dialogue.ChangerTexte("Humm.. j’ai un petit creux..");
                    this.jeu.dialogue.Afficher(this);
                }
                return;

            case (4):
                this.jeu.dialogue.Cacher();
                this.etapeDialogue = 3;
                return;

            case (5):
                this.jeu.dialogue.Cacher();
                dumbo.Parler();

        }
    }
}

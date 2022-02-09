/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personnages;

import Main.Jeu;

/**
 *
 * @author Utilisateur
 */
public class Kaki extends Personnage {

    /**
     * constructeur
     * @param jeu instance du jeu
     */
    public Kaki(Jeu jeu) {
        super("Kaki", jeu);
    }

    /**
     * fonction qui fait avancer le dialogue entre ce personnage et le joueur
     */
    @Override
    public void Parler() {
        //le code du dialogue est assez explicite, au fur et a mesure de l avancee on affiche des messages et on ajoute enleve des objets ou on change les fonds du lieu
        switch (etapeDialogue) {
            case (0):
                this.jeu.dialogue.ChangerTexte("Coucou toi! Je suis Kaki !! Une petite faim? Et bien tu es au bon endroit," + "\nj'ai plein de choses à te proposer :p ");
                this.jeu.dialogue.Afficher(this);

                return;
            case (1):
                this.jeu.dialogue.ChangerTexte("Bonjour Kaki! Qu'est ce que tu as à disposition?");
                this.jeu.dialogue.Afficher(this.jeu.joueur);
                return;
            case (2):
                this.jeu.dialogue.ChangerTexte("Alors, du popcorn, des bonbons, de la barbe à papa, mais surtout des excellentes \ncacahuètes :p ");
                this.jeu.dialogue.Afficher(this);
                return;
            case (3):
                this.jeu.dialogue.ChangerTexte("Oh oui!! J'adore les cacahuètes!");
                this.jeu.dialogue.Afficher(this.jeu.joueur);
                return;

            case (4):
                this.jeu.dialogue.ChangerTexte("Eh bien, c'est cadeau l'amie! fais-en bon usage :p");
                this.jeu.dialogue.Afficher(this);
                this.jeu.joueur.inventaire.addItem("Cacahuètes");
                return;

            case (5):
                this.jeu.dialogue.Cacher();
                this.etapeDialogue += 1;
                return;
            case (6):
                this.jeu.dialogue.ChangerTexte("Je suis en rupture de stock désolé !");
                this.jeu.dialogue.Afficher(this);
                return;
            case (7):
                this.etapeDialogue = 6;
                this.jeu.dialogue.Cacher();
                return;

        }

    }

}

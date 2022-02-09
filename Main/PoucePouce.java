/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.ArrayList;
import Objets.Item;
import Main.Inventaire;
import Personnages.Personnage;
/**
 *
 * @author Utilisateur
 */
public class PoucePouce extends Personnage{
    /**
     * inventaire du joueur
     */
    public Inventaire inventaire;

    /**
     * constructeur
     * @param jeu instance du jeu
     */
    public PoucePouce(Jeu jeu) {
        //attribution du nom du personnage
        super("PoucePouce",jeu);
        //creation de l inventaire
        inventaire = new Inventaire(this.jeu);
    }
    
}

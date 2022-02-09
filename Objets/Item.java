/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objets;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Utilisateur
 */
public class Item {
    /**
     * nom de l objet
     */
    public String nom;
    /**
     * image de l objet
     */
    public Image image;

    /**
     * constructeur
     * @param nom nom de l objet
     */
    public Item(String nom) {
        this.nom = nom;
        this.image = new Image(this.getClass().getResourceAsStream("Images/" + nom + ".png")); //on recupere l image de l objet a partir de son nom
        
    }
    
    
}

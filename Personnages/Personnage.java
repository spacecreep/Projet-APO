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
public class Personnage {
    public String nom;
    public int etapeDialogue=0;
    public Jeu jeu;
    
    /**
     * constructeur
     * @param nom nom du personnage
     * @param jeu instance du jeu
     */
    public Personnage(String nom, Jeu jeu) {
        this.nom = nom;
        this.jeu = jeu;
        
    }
    
    /**
     * fonction qui fait avancer le dialogue entre ce personnage et le joueur
     */
    public void Parler(){
        
    }
    
    
    
    
}

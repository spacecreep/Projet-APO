/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lieux;

import Main.Jeu;
import Main.Rectangle;

/**
 *
 * @author Utilisateur
 */
public class Tournant extends Lieu {
    /**
     * r1 correspond au rectangle permettant d aller dans le lieu riviere
     */
    Rectangle r1 = new Rectangle(0,661,192,796);
    /**
     * r1 correspond au rectangle permettant d aller dans le lieu serre
     */
    Rectangle r2 = new Rectangle(1017,485,1197,677);
 
    
    /**
     * Constructeur du lieu avec un tournant
     * @param className nom du lieu
     * @param jeu instance du jeu
     */
    public Tournant(String className, Jeu jeu) {
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
            this.jeu.changerLieu(7); //serre
        }
       
       
        }
    }
    

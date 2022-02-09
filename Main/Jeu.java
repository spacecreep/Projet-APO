/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Dialogues.Dialog;
import Lieux.Entree;
import Lieux.ZoneGirafe;
import Lieux.Lieu;
import Lieux.Place;
import Lieux.Radeau;
import Lieux.Riviere;
import Lieux.Serre;
import Lieux.Stand;
import Lieux.Tournant;
import Lieux.ZoneElephant;
import Lieux.ZoneOtarie;
import Personnages.Personnage;
import java.util.ArrayList;

/**
 *
 * @author Utilisateur
 */
public class Jeu {
    /**
     * le lieu dans lequel le joueur se trouve actuellement
     */
    public Lieu lieuActuel;
    /**
     * instance du joueur
     */
    public PoucePouce joueur;
    /**
     * liste des lieux du jeu
     */
    public ArrayList<Lieu> listeLieux = new ArrayList<>();
    /**
     * instance de main (classe qui genere le jeu)
     */
    public Main main;
    /**
     * instance du dialogue
     */
    public Dialog dialogue =new Dialog(this);
    /**
     * booleen qui permet de savoir si le joueur est dans un dialogue ou non
     */
    public boolean inDialog = false;
    /**
     * personnage avec qui le joueur est en train de parler
     */
    public Personnage persoDialogue;
    
    /**
     * booleen qui permet de savoir si le joueur a sauve l otarie
     */
    public boolean otarieSauve;
    /**
     * booleen qui permet de savoir si le joueur a sauve l elephant
     */
    public boolean ElephantSauve;
    /**
     * booleen qui permet de savoir si le joueur a sauve la girafe
     */
    public boolean GirafeSauve;
    
    /**
     * constructeur
     * @param main instance de main (classe qui genere le jeu)
     */
    public Jeu(Main main){
        //on assigne la valeur de main
        this.main = main;
        //creation du joueur
        joueur = new PoucePouce(this);
        
        //on cree alors tous les lieux un a un et on le ajoute a la liste de slieux
        Lieu lieu;
        
        //entree
        lieu = new Entree("Entree",this); // Entree est en position 0 dans la liste des lieux
        lieuActuel = lieu;
        listeLieux.add(lieu);
        
        //place
        lieu = new Place("Place",this); //1
        listeLieux.add(lieu);
        
        //zoneelephant
        lieu = new ZoneElephant("ZoneElephant",this); //2
        listeLieux.add(lieu);
       
        //zonegirafe
        lieu = new ZoneGirafe("ZoneGirafe",this); //3
        listeLieux.add(lieu);
        
        //stand
        lieu = new Stand("Stand",this); //4
        listeLieux.add(lieu);
        
        //riviere
        lieu = new Riviere("Riviere",this); //5
        listeLieux.add(lieu);
        
        //tournant
        lieu = new Tournant("Tournant",this); //6
        listeLieux.add(lieu);
        
        //serre
        lieu = new Serre("Serre",this); //7
        listeLieux.add(lieu);
        
        //radeau
        lieu = new Radeau("Radeau",this); //8
        listeLieux.add(lieu);
        
        //zoneotarie
        lieu = new ZoneOtarie("ZoneOtarie",this); //9
        listeLieux.add(lieu);
    }
    
    /**
     * fonction appelle quand le joueur clique dans le jeu
     * @param x coordonee x du clic
     * @param y coordonee y du clic
     */
    public void Clic(float x, float y){
        lieuActuel.Clic(x,y); //on appelle la fonction clic du lieu actuel pour savoir si cela correspond a un element avec lequel le joueur peut interagir
        
        
    }
    
    /**
     * fonction permettant de changer le joueur de lieu
     * @param i indice dans la liste des lieux du lieu vers lequel le joueur entre
     */
    public void changerLieu(int i){        
        lieuActuel= listeLieux.get(i); //on change le lieu actuel
        main.background.setImage(lieuActuel.background); //on change l image actuelle du jeu
    }
    
        
        
    
    
    
}

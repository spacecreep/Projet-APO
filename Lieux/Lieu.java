/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lieux;

import Main.Rectangle;
import Main.Jeu;
import java.io.InputStream;
import java.util.ArrayList;
import javafx.scene.image.Image;

/**
 *
 * @author poucepouce
 */
public class Lieu {

    /**
     * Arraylist qui contient la liste des tous les points d'interet du lieu, defini par des rectangles
     */
    public ArrayList<Rectangle> listeRectangle = new ArrayList<>();

    /**
     * image de fond du lieu
     */
    public Image background;

    /**
     * nom du fichier qui contient l image du lieu
     */
    public String file;
    
    /**
     * instance du jeu
     */
    public Jeu jeu;
    
    /**
     * Constructeur du lieu
     * @param className nom du lieu
     * @param jeu instance du jeu
     */
    public Lieu(String className, Jeu jeu){
        this.file = className;
        this.jeu = jeu;
        InputStream input = this.getClass().getResourceAsStream("Backgrounds/" + this.file + "/" + this.file + ".png");
        this.background = new Image(input);
        
        this.listeRectangle.add(new Rectangle(500,700,600,800));
    }
     
    /**
     * lorsque le joueur effectue un clic dans le jeu, la fonction clic du lieu actuel est appellee
     * @param x coordonnee x du clic
     * @param y coordonnee y du clic
     */
    public void Clic(double x, double y) {
        //On check si le joueur a clique sur la liste contenue dans l inventaire
        this.jeu.joueur.inventaire.checkListeClick(x,y);
        
        //On check si le joueur est dans un dialogue
        if(this.jeu.inDialog){
            //on check si le joueur clique sur le triangle de la bulle de dialogue (pour avancer dans le dialogue)
            if(listeRectangle.get(0).Check(x, y)){
                //si le joueur ne parle plus avec personne, on cache la bulle de dialogue
                if(this.jeu.persoDialogue == null){
                    this.jeu.dialogue.Cacher();
                }
                else{ //sinon, si le joueur est en dialogue avec qqn
                    this.jeu.persoDialogue.etapeDialogue += 1; //on avance dans le dialogue
                    this.jeu.persoDialogue.Parler(); //et on affiche le dialogue
                }
            }
            return; //puisque le joueur est en dialogue, il ne faut pas qu'il puisse interagir avec les elts de la scene
        }
        for (int i=1;i<listeRectangle.size();i++){ // On check si le clic se trouve dans les zones de clic du Lieuactuel
            if(listeRectangle.get(i).Check(x,y)){
                this.Action(i-1); // On effectue les actions correspondantes
            }
        }
        
    }

    /**
     * fonction qui execute une action en fonction du rectangle sur lequel le joueur clique
     * @param i indice du rectangle
     */
    public void Action(int i) {        
    }
    
    /**
     * fonction qui permet d obtenir un rectangle de la scene a partir de son indice
     * @param i indice du rectangle
     * @return rectangle correspondant a cet indice
     */
    public Rectangle GetRect(int i){
        return this.listeRectangle.get(i);
    }
    
    /**
     * fonction qui actualise l image de fond du lieu
     */
    public void Update(){
        this.jeu.main.background.setImage(this.background);
    }
    
}

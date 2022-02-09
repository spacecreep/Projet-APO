/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Objets.Item;
import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author romai
 */
public class Inventaire {
    /**
     * image du fond de l inventaire
     */
    public ImageView background;
    /**
     * image de la liste des animaux
     */
    public ImageView listeAnimaux;
    
    //ci dessous les images des croix vertes permettant de cocher si les animaux ont ete sauves
    public ImageView check1;
    public ImageView check2;
    public ImageView check3;
    
    //dimensions de la liste des animaux
    public double LISTE_HEIGHT = 400*Config.GRAPHICS_SCALE;
    public double LISTE_WIDTH = 600*Config.GRAPHICS_SCALE;
    public double LISTE_X = 300*Config.GRAPHICS_SCALE;
    public double LISTE_Y = 200*Config.GRAPHICS_SCALE;
    
    //dimensions de croix vertes permettant de checker les animaux sauves
    public double CHECK_SIZE = 30*Config.GRAPHICS_SCALE;
    public double CHECK1_X = 455*Config.GRAPHICS_SCALE;
    public double CHECK1_Y = 435*Config.GRAPHICS_SCALE;
    public double CHECK2_X = 633*Config.GRAPHICS_SCALE;
    public double CHECK2_Y = 533*Config.GRAPHICS_SCALE;
    public double CHECK3_X = 840*Config.GRAPHICS_SCALE;
    public double CHECK3_Y = 519*Config.GRAPHICS_SCALE;
    
    //dimensions de l inventaire et des objets contenus
    public double INVENTORY_HEIGHT = 100*Config.GRAPHICS_SCALE;
    public double ITEM_OFFSET_X = 15;
    public double ITEM_OFFSET_Y = 5;
    public double ITEM_SIZE = 80 * Config.GRAPHICS_SCALE;
    public double INVENTORY_START_POS = Config.WINDOW_WIDTH/2;
    public double INVENTORY_END_POS = Config.WINDOW_WIDTH;
    
    /**
     * nombre d objets maximum que peut contenir l inventaire
     */
    public int nbItems = 5;
    /**
     * liste des objets contenus dans l inventaire
     */
    public ArrayList<Item> Items = new ArrayList<>();
    /**
     * liste des images des objets de l inventaire, permettant d en afficher / masquer
     */
    public ImageView[] Images = new ImageView[nbItems];
    
    /**
     * instance du jeu
     */
    public Jeu jeu;
    
    /**
     * booleen permettant de savoir si la liste des animaux est affichee a l ecran ou non
     */
    public boolean listeAffichee;
    
    /**
     * constructeur de l inventaire
     * @param jeu instance du jeu
     */
    public Inventaire(Jeu jeu){
        //on affecte l instance du jeu
        this.jeu = jeu;
        
        //on assigne les images
        this.background = new ImageView(new Image(this.getClass().getResourceAsStream("Graphismes/Inventaire.png")));
        this.listeAnimaux = new ImageView(new Image(this.getClass().getResourceAsStream("Graphismes/Liste.png")));
        this.check1 = new ImageView(new Image(this.getClass().getResourceAsStream("Graphismes/check.png")));
        this.check2 = new ImageView(new Image(this.getClass().getResourceAsStream("Graphismes/check.png")));
        this.check3 = new ImageView(new Image(this.getClass().getResourceAsStream("Graphismes/check.png")));
        
        //on dimensionne la liste des animaux
        this.listeAnimaux.setFitHeight(LISTE_HEIGHT);
        this.listeAnimaux.setFitWidth(LISTE_WIDTH);
        this.listeAnimaux.setLayoutX(LISTE_X);
        this.listeAnimaux.setLayoutY(LISTE_Y);
        this.check1.setFitHeight(CHECK_SIZE);
        this.check1.setFitWidth(CHECK_SIZE);
        this.check2.setFitHeight(CHECK_SIZE);
        this.check2.setFitWidth(CHECK_SIZE);
        this.check3.setFitHeight(CHECK_SIZE);
        this.check3.setFitWidth(CHECK_SIZE);
        this.check1.setLayoutX(CHECK1_X);
        this.check1.setLayoutY(CHECK1_Y);
        this.check2.setLayoutX(CHECK2_X);
        this.check2.setLayoutY(CHECK2_Y);
        this.check3.setLayoutX(CHECK3_X);
        this.check3.setLayoutY(CHECK3_Y);
        
        //on cache la liste des animaux
        this.CacherListe();
        
        //on dimensionne l inventaire
        this.background.setFitHeight(INVENTORY_HEIGHT);
        this.background.setFitWidth(INVENTORY_END_POS - INVENTORY_START_POS);
        this.background.setLayoutX(INVENTORY_START_POS);
        this.background.setLayoutY(Config.WINDOW_HEIGHT - this.INVENTORY_HEIGHT);
        //on affecte et dimensionne les images des objets, qui sont des images vides par defaut
        for(int i = 0; i<nbItems; i++){
            Images[i] = new ImageView(new Image(this.getClass().getResourceAsStream("Graphismes/ItemDefault.png")));
            Images[i].setLayoutX(INVENTORY_START_POS + this.ITEM_OFFSET_X + i * (INVENTORY_END_POS - INVENTORY_START_POS)/nbItems );
            Images[i].setLayoutY(Config.WINDOW_HEIGHT - this.INVENTORY_HEIGHT + this.ITEM_OFFSET_Y);
        }
    }
    
    /**
     * fonction qui permet d ajouter un objet a linventaire
     * @param name nom de l objet a ajouter
     */
    public void addItem(String name){
        Item i = new Item(name); //on cree l objet
        Items.add(i); //on l ajoute a l inventaire
        
        //on affiche l image de l objet a la bonne position dans l inventaire
        Images[Items.size()-1].setImage(i.image);
        Images[Items.size()-1].setFitHeight(ITEM_SIZE);
        Images[Items.size()-1].setFitWidth(ITEM_SIZE);
        
        //on joue la musique qui alerte le joueur qu il a ramasse un objet
        this.jeu.main.music.PlayMusic("Objet.mp3");
    }
    
    /**
     * fonction qui permet de retirer un objet de l inventaire
     * @param name nom de l objet a retirer
     */
    public void removeItem(String name){
        
        //on parcourt l invenaire
        for (int i=0;i<Items.size();i++){
            if (Items.get(i).nom==name){ //On cherche la position de l'objet dans l'inventaire
                Items.remove(i); // On le retire de la liste
                Images[i].setImage(new Image(this.getClass().getResourceAsStream("Graphismes/ItemDefault.png"))); // On remplace l'emplacement par l'image par défaut de l'inventaire
                for(int j = i+1; j<nbItems; j++){ // On décale vers la gauche les items positionnés après celui retiré
                    Images[j-1].setImage(Images[j].getImage()); 
                }
                Images[nbItems-1].setImage(new Image(this.getClass().getResourceAsStream("Graphismes/ItemDefault.png"))); // On remplace la dernière case par l'image par défaut de l'inventaire
                return;
            }
        }
        
    }
    
    /**
     * fonction qui permet de checker si le joueur possede un objet
     * @param name nom de l objet dont on veu verifier l appartenance
     * @return true ou false suivant si le joueur possede cet objet ou non
     */
    public boolean hasItem(String name){
        for (int i=0;i<Items.size();i++){
            if (Items.get(i).nom==name){ //On cherche la position de l'objet dans l'inventaire
                return true;
            }
        }
        return false;
    }
    
    /**
     * fonction qui permet de checker si le joueur a clique sur l objet liste dans l inventaire, afin d afficher la liste des animaux a sauver a l ecran
     * @param x coordonee x du clic
     * @param y coordonee y du clic
     */
    public void checkListeClick(double x, double y) {
        if(x<693&&x>624 && y<775&&y>713){ //si le clic se situe sur l objet liste, on affiche/cache la liste suivant si elle est deja affichee a l ecran ou non
            if(this.listeAffichee){
                this.CacherListe();
            }
            else{
                this.AfficherListe();
            }
        }
    }
    
    /**
     * fonction qui permet d afficher la liste des animaux a sauver a l ecran
     */
    public void AfficherListe(){
        //on affiche la liste vierge
        this.listeAnimaux.setVisible(true);
        
        //puis on affiche les croix vertes suivant les animaux qui ont deja ete sauves
        if(this.jeu.GirafeSauve){
            this.check1.setVisible(true);
        }
        if(this.jeu.otarieSauve){
            this.check2.setVisible(true);
        }
        if(this.jeu.ElephantSauve){
            this.check3.setVisible(true);
        }
        this.listeAffichee = true;
    }
    
    /**
     * fonction qui permet de cacher la liste des animaux a sauver a l ecran
     */
    public void CacherListe(){
        //on cache tous les elements
        this.listeAnimaux.setVisible(false);
        this.check1.setVisible(false);
        this.check2.setVisible(false);
        this.check3.setVisible(false);
        this.listeAffichee = false;
    }
}

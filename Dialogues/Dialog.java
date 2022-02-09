/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dialogues;

import Main.Config;
import Main.Jeu;
import Personnages.Personnage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

/**
 *
 * @author romai
 */
public class Dialog {
    /**
     * image de fond du dialogue
     */
    public ImageView background = new ImageView(new Image(this.getClass().getResourceAsStream("Images/Dialog.png")));

    /**
     * image de la fleche pour avancer dans le dialogue
     */
    public ImageView arrow = new ImageView(new Image(this.getClass().getResourceAsStream("Images/Next.png")));

    /**
     * image dans la boite de dialogue de la tete du personnage qui parle
     */
    public ImageView portrait = new ImageView(new Image(this.getClass().getResourceAsStream("Images/Next.png")));

    /**
     * zone de texte du dialogue
     */
    public Text textBox = new Text();

    /**
     * zone de texte du nom du personnage qui parle
     */
    public Text texteNom = new Text();

    /**
     * le jeu actuel
     */
    public Jeu jeu;
    
    //Ci dessous les variables permettant d'éditer les dimensions et positions des différents éléments du dialogue
    private int BOX_HEIGHT = (int)(225*Config.GRAPHICS_SCALE);
    private int BOX_WIDTH = (int)(600*Config.GRAPHICS_SCALE);
    private int BOX_X = (int)(0*Config.GRAPHICS_SCALE);
    private int BOX_Y = (int)(600*Config.GRAPHICS_SCALE);
    private int TEXT_X = (int)(80*Config.GRAPHICS_SCALE);
    private int TEXT_Y = (int)(700*Config.GRAPHICS_SCALE);
    private int TEXT_HEIGHT = (int)(180*Config.GRAPHICS_SCALE);
    private int TEXT_WIDTH = (int)(400*Config.GRAPHICS_SCALE);
    private int ARROW_WIDTH = (int)(50*Config.GRAPHICS_SCALE);
    private int ARROW_HEIGHT = (int)(50*Config.GRAPHICS_SCALE);
    private int ARROW_X = (int)(500*Config.GRAPHICS_SCALE);
    private int ARROW_Y = (int)(730*Config.GRAPHICS_SCALE);
    private int PORTRAIT_HEIGHT = (int)(75*Config.GRAPHICS_SCALE);
    private int PORTRAIT_WIDTH = (int)(75*Config.GRAPHICS_SCALE);
    private int PORTRAIT_X = (int)(65*Config.GRAPHICS_SCALE);
    private int PORTRAIT_Y = (int)(610*Config.GRAPHICS_SCALE);
    private int NOM_HEIGHT = (int)(100*Config.GRAPHICS_SCALE);
    private int NOM_WIDTH = (int)(60*Config.GRAPHICS_SCALE);
    private int NOM_X = (int)(150*Config.GRAPHICS_SCALE);
    private int NOM_Y = (int)(650*Config.GRAPHICS_SCALE);

    /**
     * Constructeur du dialogue
     * @param jeu instance du jeu qui a ete creee au lancement de celui ci
     */
    public Dialog(Jeu jeu) {
        this.jeu = jeu;
        
        this.background.setFitHeight(BOX_HEIGHT);
        this.background.setFitWidth(BOX_WIDTH);
        this.background.setLayoutX(BOX_X);
        this.background.setLayoutY(BOX_Y);
        
        this.arrow.setFitHeight(ARROW_HEIGHT);
        this.arrow.setFitWidth(ARROW_WIDTH);
        this.arrow.setLayoutX(ARROW_X);
        this.arrow.setLayoutY(ARROW_Y);
        
        textBox.setText("UwU");
        textBox.setLayoutX(TEXT_X);
        textBox.setLayoutY(TEXT_Y);
        this.texteNom.setStyle("-fx-font: 9 arial;");
        
        this.portrait.setLayoutX(PORTRAIT_X);
        this.portrait.setLayoutY(PORTRAIT_Y);
        this.portrait.setFitWidth(PORTRAIT_WIDTH);
        this.portrait.setFitHeight(PORTRAIT_HEIGHT);
        
        this.texteNom.setLayoutX(NOM_X);
        this.texteNom.setLayoutY(NOM_Y);
        this.texteNom.setStyle("-fx-font: 20 arial;");
        
        this.background.setVisible(false);
        this.textBox.setVisible(false);
        this.arrow.setVisible(false);
        this.texteNom.setVisible(false);
        this.portrait.setVisible(false);
    }
    
    /**
     * affiche la boite de dialogue avec le ytexte du dialogue, le nom du personnage entre en parametre ainsi que sa photo
     * @param perso personnage avec qui le dialogue se deroule
     */
    public void Afficher(Personnage perso){
        this.textBox.setVisible(true);
        this.background.setVisible(true);
        this.arrow.setVisible(true);
        this.portrait.setVisible(true);
        this.texteNom.setVisible(true);
        
        this.portrait.setImage(new Image(this.getClass().getResourceAsStream("Images/" + perso.nom + ".png")));
        this.texteNom.setText(perso.nom);
        
        if(perso.nom != "PoucePouce"){
            this.jeu.persoDialogue = perso;
        }
        this.jeu.inDialog = true;
    }
    
    /**
     * permet de changer le texte de la boite de dialogue
     * @param texte nouveau texte
     */
    public void ChangerTexte(String texte){
        this.textBox.setText(texte);
    }
    
    /**
     * fait disparaitre de l'ecran la boite de dialogue
     */
    public void Cacher(){
        this.textBox.setVisible(false);
        this.background.setVisible(false);
        this.arrow.setVisible(false);
        this.jeu.inDialog = false;
        this.portrait.setVisible(false);
        this.texteNom.setVisible(false);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package Main;

import Sounds.Music;
import Menu.Menu;
import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author romai
 */
public class Main extends Application {
    
    //Variables qui gardent en mémoire les éléments du jeu
    public Stage stage; //La fenetre
    public Jeu jeu; //Le jeu
    public Menu menu; //Le menu
    public Music music; //Le gestionnaire de musique
    
    //stocke l'image qui est affichée sur la fenêtre
    public ImageView background = new ImageView();
    
    //entier qui vaut 0 si le joueur est dans le menu, 1 si il joue, et 2 si c'est l'écran de fin du jeu
    public int state = 0;
    
    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        stage.setResizable(false);
        //On lance la musique du jeu
        this.music = new Music();
        music.PlayMusic("Intro.mp3");
        
        //si jamais l ecran du joueur est plus petit que la taille de la fenetre apr deafut, il faut redimensionner celle ci
        if(Config.screen.getHeight() < Config.WINDOW_DEFAULT_HEIGHT){
            //On calcule la nouvelle taille de la fenetre
            Config.WINDOW_HEIGHT = (int)(Config.screen.getHeight() * 0.9);
            Config.WINDOW_WIDTH = (int)(Config.WINDOW_HEIGHT * 1.5);
            
            //on calcule la facteur multiplicatif de taille pour les graphismes du jeu et pour les rectangles
            Config.GRAPHICS_SCALE = (float)Config.WINDOW_HEIGHT/(float)Config.WINDOW_DEFAULT_HEIGHT;
        }
        else{ //sinon la fenetre se lance normalement
            Config.WINDOW_HEIGHT = Config.WINDOW_DEFAULT_HEIGHT;
            Config.WINDOW_WIDTH = Config.WINDOW_DEFAULT_WIDTH;
            Config.GRAPHICS_SCALE = 1;
        }
        
        
        //On redimensionne les graphismes
        this.background.setScaleX(Config.GRAPHICS_SCALE);
        this.background.setScaleY(Config.GRAPHICS_SCALE);
        this.background.setLayoutX(Config.WINDOW_DEFAULT_WIDTH * (Config.GRAPHICS_SCALE - 1) / 2);
        this.background.setLayoutY(Config.WINDOW_DEFAULT_HEIGHT * (Config.GRAPHICS_SCALE - 1) / 2);
        
        //On crée le menu et on l'affiche
        menu = new Menu(primaryStage, this);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    /**
     * fonction qui permet de lancer le jeu
     */
    public void StartGame(){
        //creation du jeu
        jeu = new Jeu(this);
        
        //on change l image de fond de la fenetre pour afficher celle du premier lieu
        background.setImage(jeu.lieuActuel.background);
        
        //definition dun nouveau panel
        Pane root = new Pane();
        
        //on ajoute au panel les images du fond ainsi que l image de l inventaire
        root.getChildren().addAll(background, this.jeu.joueur.inventaire.background);
        
        //on parcourt les images des objets et on ajoute les images au panel
        for(int i = 0; i<this.jeu.joueur.inventaire.nbItems; i++){
            root.getChildren().add(this.jeu.joueur.inventaire.Images[i]);
        }
        
        //on ajoute les images liee a la liste des animaux sauves au panel
        root.getChildren().addAll(this.jeu.joueur.inventaire.listeAnimaux,this.jeu.joueur.inventaire.check1,this.jeu.joueur.inventaire.check2,this.jeu.joueur.inventaire.check3);
        
        //on ajout les images liees aux dialogues au panel
        root.getChildren().addAll(this.jeu.dialogue.background,this.jeu.dialogue.textBox, this.jeu.dialogue.arrow, this.jeu.dialogue.portrait, this.jeu.dialogue.texteNom);
        
        //creation d une nouvelle scene
        Scene scene = new Scene(root, Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT);
        
        //on definit la fonction executee lorsque le joueur effectue un clic sur la fenetre
        scene.setOnMouseClicked(value -> {
            this.Clic((float)value.getX(), (float)value.getY()); //on apelle la fonction Clic de la classe main
        });
        
        //on definit la fonction executee lorsque le joueur bouge la souris
        scene.setOnMouseMoved(value -> {
            this.MouseMoved(value.getX(), value.getY()); //on apelle la fonction MouseMoved de la classe main
        });
        
        //on affiche la scene
        stage.setScene(scene);
        
        //le joueur est alors en jeu (state = 1)
        state = 1;
    }

    /**
     * fonction apelle lorsque le joueur clique sur la fenetre
     * @param x coordonee x du clic
     * @param y coordonee y du clic
     */
    public void Clic(float x, float y) {
        //permet d acceder aux coordonees du clic par rapport a la taille PAR DEFAUT de la fenetre (sert pour determiner les coordonees des rectangles)
        System.out.println(x * Config.GRAPHICS_SCALE + "," + y * Config.GRAPHICS_SCALE);
        
        //on ramene les coordonees du clic a celle par rapport a la taille apr defaut de la fenetre, car les coordonees de tous les rectangles on ete definis par rapport a cette taille par defaut
        x = (float)(x / Config.GRAPHICS_SCALE);
        y = (float)(y / Config.GRAPHICS_SCALE);
        
        //si le joueur est en jeu, on appelle la fonction clic de jeu
        if(state == 1)jeu.Clic(x, y);
        
        //si il est sur l ecran de fin, on ferme la fenetre si celui ci clique sur le bout EXIT
        if(state == 2){
            if(x < 1118 && x > 802 && y < 526 && y > 434){
                this.ExitGame(); //on quitte le jeu
            }
        }
        
        //si tous les animaux sont sauves on affiche alors l ecran de fin :
        //cette partie du code a ete placee ici car puisque notre jeu ne contient pas de thread
        //il faut que l on check si tous les animaux ont ete sauves dans une fonction qui est executee des qu il se passe qq chose dans le jeu
        //donc la fonction clic
        if(this.jeu.ElephantSauve&&this.jeu.GirafeSauve&&this.jeu.otarieSauve){ //si tous les animaux sont sauves
            this.state = 2; 
            EndGame(); //on finit le jeu
        }
    }
    
    /**
     * fonction appelle des que le joueur bouge sa souris
     * @param x coordonee x de la nouvelle position de la souris
     * @param y coordonee y de la nouvelle position de la souris
     */
    public void MouseMoved(double x, double y){
        //ce booleen va permettre de savoir si le joueur a deplace sa souris sur un element cliquable du jeu (on devra alors changer l image de la souris pour afficher une souris avec une main)
        Boolean b = false;
        
        //on ramene les coordonees du clic a celle par rapport a la taille apr defaut de la fenetre, car les coordonees de tous les rectangles on ete definis par rapport a cette taille par defaut
        x = (float)(x / Config.GRAPHICS_SCALE);
        y = (float)(y / Config.GRAPHICS_SCALE);
        
        //si on est sur l ecran de fin
        if(state == 2){
            if(x < 1118 && x > 802 && y < 526 && y > 434){ // si le joueur passe sa souris sur le bouton exit
                this.stage.getScene().setCursor(Cursor.HAND); //on affiche une main
            }
            else{
                this.stage.getScene().setCursor(Cursor.DEFAULT); //sinon on laisse le curseur tel qu il est
            }
            return;
        }
        
        if(this.jeu.inDialog){ //si le joueur est dans un dialogue, alors le seul element avec lequel il peut interagir est le triangle pour avancer dans le dialolgue
            
            if(this.jeu.lieuActuel.listeRectangle.get(0).Check(x, y)){ //si le joueur a sa souris sur le triangle
                this.stage.getScene().setCursor(Cursor.HAND); //on change le curseur
            }
            else{
                this.stage.getScene().setCursor(Cursor.DEFAULT); //sinon on le laisse par defaut
            }
            return;
        }
        
        //on parcourt la liste des elements cliquables du lieu actuel
        for(int i = 1; i<this.jeu.lieuActuel.listeRectangle.size(); i++){
            if(this.jeu.lieuActuel.listeRectangle.get(i).Check(x, y)){ // et on check si al souris du joueur est desus
                b = true;
            }
        }
        
        
        if(b){ //si la souris du joueur est sur un element cliquable on change la souris en main
            this.stage.getScene().setCursor(Cursor.HAND);
        }
        else{ //sinon on la laisse par defaut
            this.stage.getScene().setCursor(Cursor.DEFAULT);
        }
    }

    /**
     * fonction qui lance l ecran de fin du jeu
     */
    private void EndGame() {
        //on change l image de fond et on cache les autres elements
        this.background.setImage(new Image(this.getClass().getResourceAsStream("Graphismes/End.png")));
        this.jeu.joueur.inventaire.background.setVisible(false);
        this.jeu.joueur.inventaire.Images[0].setVisible(false);
    }
    
    /**
     * fonction qui ferme la fenetre du jeu
     */
    private void ExitGame(){
        this.stage.close();
    }
}

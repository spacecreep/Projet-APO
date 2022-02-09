/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menu;

import Main.Config;
import Main.Main;
import Main.Rectangle;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author romai
 */
public class Menu {
    /**
     * instance du stage cree dans main
     */
    public Stage stage;
    
    /**
     * instance de main
     */
    public Main main;
    
    /**
     * Vaut 0 si le joueur est sur le menu, 1 dans les options et 2 dans les crédits
     */
    public int menuState = 0;
    
    //Les images et textes des differents elements du menu
    public Image background = new Image(this.getClass().getResourceAsStream("background.png"));
    public ImageView arrow1 = new ImageView();
    public ImageView arrow2 = new ImageView();
    public ImageView arrow3 = new ImageView();
    public ImageView credits = new ImageView();   
    public ImageView options = new ImageView();
    public ImageView checkMark = new ImageView();
    public Text volumeText = new Text();
    
    //les dimensions du curseur du menu
    public int CURSOR_WIDTH = 72;
    public int CURSOR_HEIGHT = 54;
    
    /**
     * constructeur
     * @param s stage
     * @param main
     */
    public Menu(Stage s, Main main){
        //tout le contenu de ce constructeur est parfaitement analogue a celui de main, il est donc possible de s y referer pour avoir des commentaires plus detailles
        
        this.stage = s;
        this.main = main;
        
        
        //Background
        ImageView image = new ImageView();
        image.setImage(background);
        
        //creation d un nouveau panel
        Pane root = new Pane();
        root.getChildren().add(image);
        
        //creation et dimensionnement des fleches du menu
        Image arrow = new Image(this.getClass().getResourceAsStream("arrow.png"));
        arrow1.setImage(arrow);
        arrow2.setImage(arrow);
        arrow3.setImage(arrow);
        arrow1.setLayoutX(300);
        arrow1.setLayoutY(330);
        arrow2.setLayoutX(300);
        arrow2.setLayoutY(460);
        arrow3.setLayoutX(300);
        arrow3.setLayoutY(590);
        arrow1.setFitHeight(this.CURSOR_HEIGHT);
        arrow1.setFitWidth(this.CURSOR_WIDTH);
        arrow2.setFitHeight(this.CURSOR_HEIGHT);
        arrow2.setFitWidth(this.CURSOR_WIDTH);
        arrow3.setFitHeight(this.CURSOR_HEIGHT);
        arrow3.setFitWidth(this.CURSOR_WIDTH);
        
        //on ajoute les fleches au panel
        root.getChildren().addAll(arrow1,arrow2,arrow3);
        
        //Credits
        credits.setImage(new Image(this.getClass().getResourceAsStream("credits.png")));
        credits.setLayoutX(200);
        credits.setLayoutY(150);
        root.getChildren().add(credits);
        
        
        //Options
        options.setImage(new Image(this.getClass().getResourceAsStream("options.png")));
        options.setLayoutX(200);
        options.setLayoutY(150);
        root.getChildren().add(options);
        volumeText.setText("100");
        volumeText.setScaleX(3);
        volumeText.setScaleY(3);
        volumeText.setLayoutX(633);
        volumeText.setLayoutY(515);
        checkMark.setImage(new Image(this.getClass().getResourceAsStream("check.png")));
        checkMark.setLayoutX(540);
        checkMark.setLayoutY(350);
        root.getChildren().add(checkMark);
        root.getChildren().add(volumeText);
        
        //redimensionnement
        root.setScaleX(Config.GRAPHICS_SCALE);
        root.setScaleY(Config.GRAPHICS_SCALE);
        root.setLayoutX(Config.WINDOW_DEFAULT_WIDTH * (Config.GRAPHICS_SCALE - 1) / 2);
        root.setLayoutY(Config.WINDOW_DEFAULT_HEIGHT * (Config.GRAPHICS_SCALE - 1) / 2);
        
        
        
        Scene scene = new Scene(root, Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT);
        scene.setOnMouseClicked(value -> {
            this.Clic((float)value.getX(), (float)value.getY());
        });
        scene.setOnMouseMoved(value -> {
            this.MouseMoved(value.getX(), value.getY());
        });
        
        //finalisation de la fenetre
        stage.setTitle(Config.WINDOW_TITLE);
        stage.setScene(scene);
        stage.show();
        arrow2.setVisible(false);
        arrow3.setVisible(false);
        credits.setVisible(false);
        options.setVisible(false);
        checkMark.setVisible(false);
        volumeText.setVisible(false);
        
        
    }
    
     /**
     * fonction apelle lorsque le joueur clique sur la fenetre
     * @param x coordonee x du clic
     * @param y coordonee y du clic
     */
    public void Clic(float x, float y) {
        //on ramene les coordonees du clic a celle par rapoort a la fenetre par defaut
        x = (float)(x / Config.GRAPHICS_SCALE);
        y = (float)(y / Config.GRAPHICS_SCALE);
        
        //si le joueur clique sur un element alors que il est sur l accueil du menu
        if(this.menuState == 0 && x>300 && x<800){
            if(y > 325 && y < 420){
                main.StartGame(); //on lance l ejeu
            }
            if(y > 420 && y < 530){ //ou alors on ouvre le soptions
                this.menuState = 1;
                options.setVisible(true);
                if(!this.main.music.isMuted)checkMark.setVisible(true);
                volumeText.setVisible(true);
            }
            if(y > 530 && y < 640){ //ou alors on ouvre les credits
                this.menuState = 2;
                credits.setVisible(true);
            }
        }
        if(this.menuState == 1){ //si le joueur clique sur un element alors que il est dans les options du jeu
            if(x>929 && x<991 && y>162 && y<223){ //soit il quitte les options
                this.menuState = 0;
                options.setVisible(false);
                checkMark.setVisible(false);
                volumeText.setVisible(false);
            }
            if(x>558 && x<614 && y>381 && y<435){ //soit il mute/demute la musique
                if(this.main.music.isMuted){
                    this.main.music.UnMute();
                    checkMark.setVisible(true);
                    return;
                }
                this.main.music.Mute();
                checkMark.setVisible(false);
            }
            if(x>549 && x<609 && y>483 && y<543){ //soit il baisse le volume de la musique
                this.main.music.ChangeVolume(-0.05);
                volumeText.setText(""+(int)(this.main.music.Volume()*100));
            }
            if(x>683 && x<743 && y>482 && y<545){ //soit il augmente le volume de la musique
                this.main.music.ChangeVolume(+0.05);
                volumeText.setText(""+(int)(this.main.music.Volume()*100));
            }
            
        }
        if(this.menuState == 2 && x>929 && x<991 && y>162 && y<223){ //soit il est dans les credits et il a clique sur la croix pour fermer la fenetre des credits
            this.menuState = 0;
            credits.setVisible(false);
        }
    }

    /**
     * fonction appelle des que le joueur bouge sa souris
     * @param x coordonee x de la nouvelle position de la souris
     * @param y coordonee y de la nouvelle position de la souris
     */
    public void MouseMoved(double x, double y){
        //on ramene les coordonees du clic a celle par rapoort a la fenetre par defaut
        x = (float)(x / Config.GRAPHICS_SCALE);
        y = (float)(y / Config.GRAPHICS_SCALE);
        
        //suivant l endroit ou est la souris du joueur, on affiche une fleche en fonction de l element du menu devant lequel est la souris
        if(this.menuState == 0 && x > 300 && x<800){
            if(y > 325 && y < 420){
                arrow1.setVisible(true);
                arrow2.setVisible(false);
                arrow3.setVisible(false);
            }
            if(y > 420 && y < 530){
                arrow1.setVisible(false);
                arrow2.setVisible(true);
                arrow3.setVisible(false);
            }
            if(y > 530 && y < 640){
                arrow1.setVisible(false);
                arrow2.setVisible(false);
                arrow3.setVisible(true);
            }
            return;
        }
        if(this.menuState == 1){ //si le joueur est dans les options et qu il a la souris sur un bouton (mute, demute, volume .. etc) on change la souris en main
            if(x>929 && x<991 && y>162 && y<223 || x>558 && x<614 && y>381 && y<435 || x>549 && x<609 && y>483 && y<543 || x>683 && x<743 && y>482 && y<545 ){
                this.stage.getScene().setCursor(Cursor.HAND);
                return;
            }
            
        }
        if(this.menuState == 2 && x>929 && x<991 && y>162 && y<223){//si le joueur est dans les credits et qu il a la souris sur le bouton pour fermer la fenetre des credits on change la souris en main
            this.stage.getScene().setCursor(Cursor.HAND);
            return;
        }
        this.stage.getScene().setCursor(Cursor.DEFAULT); //sinon on laisse le curseur par defaut
    }    
}

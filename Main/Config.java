/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;

/**
 *
 * @author romai
 */
public class Config {
    /**
     * variable qui permet d acceder au dimensions de l ecran du joueur
     */
    public static Rectangle2D screen = Screen.getPrimary().getBounds();
    
    /**
     * hauteur de la fenetre par defaut
     */
    public static int WINDOW_DEFAULT_HEIGHT = 800;
    /**
     * largeur de la fenetre par defaut
     */
    public static int WINDOW_DEFAULT_WIDTH = 1200;
    /**
     * hauteur de la fenetre actuelle
     */
    public static int WINDOW_HEIGHT;
    /**
     * largeur de la fenetre actuelle
     */
    public static int WINDOW_WIDTH;
    /**
     * ratio taille par defaut/taile actuelle de la fenetre, permettant de redimensionner les graphismes du jeu
     */
    public static double GRAPHICS_SCALE;
    /**
     * titre de la fenetre
     */
    public static String WINDOW_TITLE = "Pouce-Pouce v2 °3°";
    
}

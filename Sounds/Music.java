/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sounds;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author romai
 */
public class Music {
    /**
     * objet qui permet de gerer l audio
     */
    public MediaPlayer mediaPlayer;
    /**
     * booleen qui est true ou false suivant si la musique est jouee ou non
     */
    public Boolean isMusicPlaying;
    /**
     * booleen qui est true ou false suivant si la musique est mute ou non
     */
    public Boolean isMuted = false;

    /**
     * fonction qui permet de lancer la lecture d une musique
     * @param file nom du fichier a jouer
     */
    public void PlayMusic(String file) {
        String path = System.getProperty("user.dir") + "/src/Sounds/" + file; //on recupere le chemin du fichier
        File f = new File(path);
        Media m = new Media(f.toURI().toString()); //on cree un nouveau media a partir de ce fichier
        
        //et on joue ce media
        mediaPlayer = new MediaPlayer(m); 
        mediaPlayer.play();
        isMusicPlaying = true;
    }
    
    /**
     * fonction qui permet d arreter la lecture de la musique
     */
    public void StopMusic(){
        if(mediaPlayer == null)return;
        mediaPlayer.stop();
        isMusicPlaying = false;
    }
    
    /**
     * fonction qui permet de pauser la lecture de la musique
     */
    public void PauseMusic(){
        if(mediaPlayer == null)return;
        mediaPlayer.pause();
        isMusicPlaying = false;
    }
    
    /**
     * fonction qui permet de reprendre la lecture de la musique
     */
    public void ResumeMusic(){
        if(mediaPlayer == null)return;
        mediaPlayer.play();
        isMusicPlaying = true;
    }

    /**
     * fonction permet de mute la musique
     */
    public void Mute(){
        if(mediaPlayer == null)return;
        mediaPlayer.setMute(true);
        isMuted = true;
    }
 
    /**
     * fonction permet de demute la musique
     */
    public void UnMute(){
        if(mediaPlayer == null)return;
        mediaPlayer.setMute(false);
        isMuted = false;
    }
    
    /**
     * fonction qui permet de changer le volume de la musique
     * @param v nouveau volume
     */
    public void SetVolume(double v){
        if(mediaPlayer == null);
        System.out.println(Volume());
        mediaPlayer.setVolume(v);
    }
    
    /**
     * fonction qui renvoie le volume actuel de la musique
     * @return volume de la musique
     */
    public double Volume(){
        if(mediaPlayer == null)return 0;
        return mediaPlayer.volumeProperty().getValue();
    }
    
    /**
     * fonction qui permet d incrementer ou decrementer le volume de la musique
     * @param i 
     */
    public void ChangeVolume(double i){
        if(mediaPlayer == null)return;
        if(Volume() + i < 0){
            SetVolume(0);
            return;
        }
        if(Volume() + i > 1){
            SetVolume(1);
            return;
        }
        SetVolume(Volume() + i);
    }
}

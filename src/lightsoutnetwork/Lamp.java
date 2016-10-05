package lightsoutnetwork;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nicho_000
 */
public class Lamp {
    public boolean zustand;
    
    public Lamp(boolean zustand){
        this.zustand=zustand;
    }
    
    public void umschalten(){
        if (zustand==true){
            zustand=false;
        }
        else{
            zustand=true;
        }
    }
}
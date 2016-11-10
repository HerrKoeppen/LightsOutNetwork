package protocol;

import java.util.regex.Pattern;
import lightsoutnetwork.Brett;

public class LightsoutProtocol1 {

    private static final int START = 0;
    private static final int SENTNAME = 1;
    private static final int SENTPOSITION = 2;
    private static final int PLAY = 3;
    private static final int END = 4;
    
    private int state = START;
    
    private String namePlayer1;
    private Brett spielbrett;
    
    public String processInput(String theInput) {
        String theOutput = null;

        if (state == START) {
            theOutput = "Herzlich Willkommen bei unserem Spiel! Wie heisst du?";
            state = SENTNAME;
        }
        else if (state == SENTNAME) {
            namePlayer1 = theInput;
            spielbrett =new Brett(5,5);
            String output = "Hallo "+ namePlayer1 + "newLine " + this.spielbrettAusgabe() + "newLine Gib ok ein um fortzufahren.";
            theOutput = output;
            state = SENTPOSITION;
        }    
        else if (state == SENTPOSITION) {
             theOutput = "Wähle eine Zahl zwischen 1 und 5 für die Reihe sowie Spalte und trenne diese mir einem Komma!";
             state = PLAY;
        }     
   
        else if (state == PLAY) {
            String [] rs = theInput.split(Pattern.quote(","));
            spielbrett.eingabe(Integer.parseInt(rs[0]), Integer.parseInt(rs[1]));
            if(spielbrett.win == true){
                theOutput = "Du hast gewonnen";
                state = END;        
            }    
            else{
                theOutput = (this.spielbrettAusgabe()+"newLine Gib ok ein um fortzufahren.");
                state = SENTPOSITION;
            } 
        }
        else if (state==END){
            theOutput = "Bye";
            System.out.println("Bye");
            state = START;
        }
        return theOutput;
    }
    
    public String spielbrettAusgabe(){
        return spielbrett.toString();
    }
}
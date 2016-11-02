package protocol;

import network.*;
import java.net.*;
import java.io.*;
 
public class LightsoutProtocol {
    private static final int START = 0;
    private static final int SENTNAME = 1;
    private static final int SENTROW = 2;
    private static final int SENTCOLOUMN = 3;
    private static final int WAITING = 4;
    private static final int END = 5;
    private static final int PLAYING = 6 ;
 
    private static final int NUMJOKES = 5;
 
    private int state = START;
    
 
    //private String[] name = { "Heinz", "Gustav", "Jorge", "Navid", "Klausi","Natalie","Ekin" };
    //private String[] answers = { "Turnip the heat, it's cold in here!",
    //                             "I didn't know you could yodel!",
      //                           "Bless you!",
        //                         "Is there an owl in here?",
          //                       "Is there an echo in here?" };
    //private String[] row = {""};
 
    public String processInput(String theInput) {
        String theOutput = null;
 
        if (state == START) {
            theOutput = "Herzlich Willkommen bei unserem Spiel! Wähle einen der gegeben Namen :Heinz";
            state = SENTNAME;
        } else if (state == SENTNAME) {
            if (theInput.equalsIgnoreCase("Heinz")) {
               theOutput = "Spalte zwischen 0 und 4 wählen. Nur ganze Zahlen!!!";
               state = SENTROW;
            } else {
                theOutput = "Du MUSST  \"Heinz\" heißen! ";
            }
        } else if (state == SENTROW) {
            if (theInput.equalsIgnoreCase("0")) {
                theOutput = " Want another? (y/n)";
                state = SENTCOLOUMN;
            if (theInput.equalsIgnoreCase("1")) {
                theOutput =  " Want another? (y/n)";
                state = SENTCOLOUMN;
            if (theInput.equalsIgnoreCase("2")) {
                theOutput = " Want another? (y/n)";
                state = SENTCOLOUMN;
            if (theInput.equalsIgnoreCase("3")) {
                theOutput =  " Want another? (y/n)";
                state = SENTCOLOUMN;
            if (theInput.equalsIgnoreCase("4")) {
                theOutput = " Want another? (y/n)";
                state = SENTCOLOUMN;
            } else {
                theOutput = "Du musst zwischen 0-4 wählen"; 
                state = SENTROW;
            }
        } else if (state == SENTCOLOUMN) {
            if (theInput.equalsIgnoreCase("0")) {
                theOutput = " Want another? (y/n)";
                state = WAITING;
            if (theInput.equalsIgnoreCase("1")) {
                theOutput =  " Want another? (y/n)";
                state = WAITING;
            if (theInput.equalsIgnoreCase("2")) {
                theOutput = " Want another? (y/n)";
                state = WAITING;
            if (theInput.equalsIgnoreCase("3")) {
                theOutput =  " Want another? (y/n)";
                state = WAITING;
            if (theInput.equalsIgnoreCase("4")) {
                theOutput = " Want another? (y/n)";
                state = WAITING;
            } else {
                theOutput = " Du musst eine Zahl zwischen 0 und 4 wählen";
                        }
        }
            //PLayer 2 auf Playing setzen
            
            if (theInput.equalsIgnoreCase("y")) {
                theOutput = "Knock! Knock!";
                if (currentJoke == (NUMJOKES - 1))
                    currentJoke = 0;
                else
                    currentJoke++;
                state = SENTKNOCKKNOCK;
            } else {
                theOutput = "Bye.";
                state = WAITING;
            }
        }
        return theOutput;
    }
}
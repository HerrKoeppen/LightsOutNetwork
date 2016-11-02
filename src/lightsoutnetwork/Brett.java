package lightsoutnetwork;

import java.util.Random;

public class Brett {
    
    public int feldreihen;
    public int feldspalten;
    public Lamp[][] feld;
    public boolean win=false;
    public String spaltenZ="   ";
    int Runde = 1;
    int aktiver_spieler=0;
            
    public Brett(int reihen, int spalten){
        this.feldreihen=reihen;
        this.feldspalten=spalten;
        this.feld=new Lamp[reihen][spalten];
    }
    public void spielen(){
        int reihenZ=1;
        for (int sZ=1;sZ<=feldspalten;sZ++){
            spaltenZ+=sZ+"   ";
        }
        System.out.println(spaltenZ);
        for(int r=0;r<=feldreihen-1;r++){
            String text="";

            for(int s=0;s<=feldspalten-1;s++){
                Random rn=new Random();
                int n = rn.nextInt(2);
                if (n==1){
                    feld[r][s]=new Lamp(true);
                    text=text+"x"+"   " ;
                }
                else{
                    feld[r][s]=new Lamp(false);
                    text=text+"o"+"   ";
                }
            }
            System.out.println(reihenZ+"  "+text);
            reihenZ++;
        }
        System.out.println();
    } 
        
    public void spieler_wechsel(int Runde){
        Runde=Runde++;
    }
    public void spieler_am_zug(int Runde, int aktiver_Spieler){
        if(Runde%2==0){
            aktiver_Spieler=2;
        }else{
            aktiver_Spieler=1;
        }
    }
    public void eingabe(int reihe, int spalte){
        if(((reihe <= feldreihen-1 && 0 <= reihe) && 0 <= spalte)&&spalte<=feldspalten-1){
            if(spalte-1!=-1){
                feld[reihe][spalte-1].umschalten();
            }
            if(spalte+1!=feldspalten){
                feld[reihe][spalte+1].umschalten();
            }
            if(reihe-1!=-1){
                feld[reihe-1][spalte].umschalten();
            }
            if(reihe+1!=feldspalten){
                feld[reihe+1][spalte].umschalten();            
            }
            
            feld[reihe][spalte].umschalten();            
            
            System.out.println();
            boolean gewonnen=true;
            int reihenZ=1;
            System.out.println(spaltenZ);
            for (Lamp[] lamps:feld){
                String text = "";
                for (Lamp l:lamps){
                    if (l.zustand==true){
                    text=text+"x"+"     ";    
                    }
                    else{
                    text=text+"o"+"     ";    
                    }
                    if (l.zustand==true){
                        gewonnen=false;
                    }
                }
                System.out.println(reihenZ+"  "+text);
                reihenZ++;
            }
            System.out.println();
            if (gewonnen==true){
                System.out.println("Du hast gewonnen!");
                win=true;
            }
        }
        else{
                System.out.println("UngÃ¼ltige Eingabe! Reihen und Spalten mÃ¼ssen vorhandensein.");
        }
    }
}

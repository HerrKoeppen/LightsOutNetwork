package lightsoutnetwork;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
/**
 *
 * @author nicho_000
 */
public class Lama {
    public static void main(String[] args) {
        int brettreihen;
        int brettspalten;
        Scanner sc = new Scanner(System.in);
        System.out.print("Reihen des Spielfelds: ");
        brettreihen=Integer.parseInt(sc.next());
        System.out.print("Spalten des Spielfelds: ");
        brettspalten=Integer.parseInt(sc.next());
        Brett b=new Brett(brettreihen,brettspalten);
        b.spielen();
        while (b.win==false){
            System.out.print("Reihe: ");
            String eingabe = sc.next();
            System.out.print("Spalte: ");
            String eingabe2 = sc.next();
            b.eingabe(Integer.parseInt(eingabe)-1,Integer.parseInt(eingabe2)-1);
        }
    }
}
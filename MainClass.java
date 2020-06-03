import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainClass {

    public final static int dark = 2;
    public final static int light = 1;


    public static void compMove(){

    }
    public static void playerMove(Scanner input){
        String in = input.nextLine();
    }
    public static void main(String[] args){
        int boardSize = 11;
        boolean computerStarts = false;
        boolean gameFinished = false;
      
        //Reads input flags
        for(int i=0;i<args.length;i++){
         
            if(args[i].equals("-n")){

                boardSize = Integer.parseInt(args[i+1]);
            }
            if(args[i].equals("-l")){

                computerStarts = true;
            }
        }
        
        board b = new board(boardSize);
        game g = new game(computerStarts, b);
        g.start();


    }
}
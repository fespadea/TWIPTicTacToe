package com.company;

import java.util.Scanner;

/**
 * Created by fs279 on 12/19/16.
 */
public class Moves {
    public static String [] [] position = {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};
    public static Scanner input = new Scanner(System.in);
    public static boolean player = true;
    public static boolean continueGame = true;
    public static String winner = "";
    static void printBoard(){
        System.out.println("     |     |\n  " + position[2][0] +"  |  " + position[2][1] + "  |  " + position[2][2] + "\n_____|_____|_____\n   " + "  |     |\n  " + position[1][0] + "  |  " + position[1][1] + "  |  " + position[1][2] + "\n_____|_____|_____\n" + "     |     |\n  " + position[0][0] + "  |  " + position[0][1] + "  |  " + position[0][2] + "\n     |     |");
    }
    static void enterCoordinate(){
        System.out.println("Gimme a coordinate on the board. (bottom left being the origin) Template: (x,y)");
        String coor = input.next();
        setter(Integer.parseInt(coor.substring(1,2)), Integer.parseInt(coor.substring(3,4)));
        player = !player;
    }
    static void setter(int a, int b) {
        if (position[b][a].equals(" ")) {
            if (player == true) {
                position[b][a] = "X";
            } else
                position[b][a] = "O";
        }
        else{
            System.out.println("That's taken. Choose something else.");
            enterCoordinate();
        }
    }
    static void pvp(){
        repeaterForPvp();
        repeaterForPvp();
        repeaterForPvp();
        repeaterForPvp();
        repeaterForPvp();
        repeaterForPvp();
        repeaterForPvp();
        repeaterForPvp();
        repeaterForPvp();
        if(continueGame){
            System.out.print("It's a tie.");
        }
    }
    static void repeaterForPvp(){
        checkForWin();
        if(continueGame){
            printBoard();
            enterCoordinate();
        }
    }
    public static void checkForWin(){
        if((position[0][0].equals("X") && position[0][1].equals("X") && position[0][2].equals("X")) || (position[1][0].equals("X") && position[1][1].equals("X") && position[1][2].equals("X")) || (position[2][0].equals("X") && position[2][1].equals("X") && position[2][2].equals("X")) || (position[0][0].equals("X") && position[1][0].equals("X") && position[2][0].equals("X")) || (position[0][1].equals("X") && position[1][1].equals("X") && position[2][1].equals("X")) || (position[0][2].equals("X") && position[1][2].equals("X") && position[2][2].equals("X")) || (position[0][0].equals("X") && position[1][1].equals("X") && position[2][2].equals("X")) || (position[2][0].equals("X") && position[1][1].equals("X") && position[2][0].equals("X"))){
            continueGame = false;
            winner = "Player 1";
        }
        if((position[0][0].equals("O") && position[0][1].equals("O") && position[0][2].equals("O")) || (position[1][0].equals("O") && position[1][1].equals("O") && position[1][2].equals("O")) || (position[2][0].equals("O") && position[2][1].equals("O") && position[2][2].equals("O")) || (position[0][0].equals("O") && position[1][0].equals("O") && position[2][0].equals("O")) || (position[0][1].equals("O") && position[1][1].equals("O") && position[2][1].equals("O")) || (position[0][2].equals("O") && position[1][2].equals("O") && position[2][2].equals("O")) || (position[0][0].equals("O") && position[1][1].equals("O") && position[2][2].equals("O")) || (position[2][0].equals("O") && position[1][1].equals("O") && position[2][0].equals("O"))){
            continueGame = false;
            winner = "Player 2";
        }
        if(!continueGame){
            System.out.print("The winner is " + winner);
        }
    }
}

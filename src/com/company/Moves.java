package com.company;

import java.util.*;

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
    static void pvc(){
        for(int x = 0; x < 4; x++){
            if(continueGame){
                printBoard();
                enterCoordinate();
                checkForWin();
            }
            if(continueGame){
                printBoard();
                computerPick();
                checkForWin();
            }
        }
        if(continueGame){
            printBoard();
            enterCoordinate();
            checkForWin();
        }
        if(continueGame){
            System.out.print("It's a tie.");
        }
    }
    static void computerPick(){
        player = !player;
        if (position[1][1].equals(" ")) {
            position[1][1] = "O";
        }
        else{
            int o = 0;
            for(int c = 0; c < 3; c++) {
                int y = 0;
                int [] v = new int[2];
                for (int x = 0; x < 3; x++) {
                    int [] n = new int[2];
                    if(position[c][x].equals("X")){
                        n[y] = x;
                        y++;
                    }
                    if(y == 2){
                        v = n;
                    }
                }
                if(y == 2) {
                    int j = 3;
                    for (int i : v) {
                        j -= i;
                    }
                    if (position[j][c].equals(" ")) {
                        position[j][c] = "O";
                        o = 2;
                        break;
                    }
                }
            }
            int l = 0;
            if(o != 2) {
                int s = 0;
                int m [] = new int[2];
                for (int x = 0; x < 3; x++) {
                    if (position[x][x] == "X") {
                        m[s] = x;
                        s++;
                    }
                    if(s == 2) {
                        int j = 3;
                        for (int i : m) {
                            j -= i;
                        }
                        if (position[j][j].equals(" ")) {
                            position[j][j] = "O";
                            l = 2;
                            break;
                        }
                    }
                }
            }
            if(l != 2) {
                int s = 0;
                int m [] = new int[2];
                for (int x = 0; x < 3; x++) {
                    if (position[2-x][x] == "X") {
                        m[s] = x;
                        s++;
                    }
                    if(s == 2) {
                        int j = 3;
                        for (int i : m) {
                            j -= i;
                        }
                        if (position[2-j][j].equals(" ")) {
                            position[2-j][j] = "O";
                            l = 2;
                            break;
                        }
                    }
                }
            }
            for(int x = 0; x < 3; x++){
                for(int y = 0; y < 3; y++){
                    if(position[x][y].equals(" ")){
                        position[x][y] = "O";
                        x = 3;
                        break;
                    }
                }
            }
        }
    }
    static void pvp(){
        for(int x = 0; x < 9; x++){
            if(continueGame){
                printBoard();
                enterCoordinate();
                checkForWin();
            }
        }
        if(continueGame){
            System.out.print("It's a tie.");
        }
    }
    public static void checkForWin(){
        if((position[0][0].equals("X") && position[0][1].equals("X") && position[0][2].equals("X")) || (position[1][0].equals("X") && position[1][1].equals("X") && position[1][2].equals("X")) || (position[2][0].equals("X") && position[2][1].equals("X") && position[2][2].equals("X")) || (position[0][0].equals("X") && position[1][0].equals("X") && position[2][0].equals("X")) || (position[0][1].equals("X") && position[1][1].equals("X") && position[2][1].equals("X")) || (position[0][2].equals("X") && position[1][2].equals("X") && position[2][2].equals("X")) || (position[0][0].equals("X") && position[1][1].equals("X") && position[2][2].equals("X")) || (position[0][2].equals("X") && position[1][1].equals("X") && position[2][0].equals("X"))){
            continueGame = false;
            winner = "Player 1";
        }
        if((position[0][0].equals("O") && position[0][1].equals("O") && position[0][2].equals("O")) || (position[1][0].equals("O") && position[1][1].equals("O") && position[1][2].equals("O")) || (position[2][0].equals("O") && position[2][1].equals("O") && position[2][2].equals("O")) || (position[0][0].equals("O") && position[1][0].equals("O") && position[2][0].equals("O")) || (position[0][1].equals("O") && position[1][1].equals("O") && position[2][1].equals("O")) || (position[0][2].equals("O") && position[1][2].equals("O") && position[2][2].equals("O")) || (position[0][0].equals("O") && position[1][1].equals("O") && position[2][2].equals("O")) || (position[0][2].equals("O") && position[1][1].equals("O") && position[2][0].equals("O"))){
            continueGame = false;
            winner = "Player 2";
        }
        if(!continueGame){
            System.out.println("The winner is " + winner);
            printBoard();
        }
    }
}

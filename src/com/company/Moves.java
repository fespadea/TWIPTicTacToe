package com.company;

import java.util.Scanner;

/**
 * Created by fs279 on 12/19/16.
 */
public class Moves {
    public static String [] position = {" ", " ", " ", " ", " ", " ", " ", " ", " "};
    public static Scanner input = new Scanner(System.in);
    public static boolean [] [] ticTacToe = new boolean[3][3];
    public static boolean player = true;
    public static boolean [] [] playerRecord = new boolean[3][3];
    static void printBoard(){
        System.out.println("    " + position[0] +"   |    " + position[1] + "   |   " + position[1] + "\n________|________|________\n    " + position[3] + "   |    " + position[4] + "   |   " + position[5] + "\n________|________|________\n    " + position[6] + "   |    " + position[7] + "   |   " + position[8] + "\n        |        |\n");
    }
    static void enterCoordinate(){
        System.out.println("Gimme a coordinate on the board. (bottom left being the origin) Template: (x,y)");
        String coor = input.next();
        ticTacToe [Integer.parseInt(coor.substring(1,2))] [Integer.parseInt(coor.substring(3,4))] = true;
        player = !player;
        playerRecord [Integer.parseInt(coor.substring(1,2))] [Integer.parseInt(coor.substring(3,4))] = player;
    }
    static void setter(){
        for(boolean [] i: ticTacToe){
            int pi = 0;
            for(boolean j: i){
                pi++;
                if(i[pi] == true){

                }
            }
        }
    }
}

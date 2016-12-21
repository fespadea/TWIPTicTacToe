package com.company;

import java.util.Scanner;

/**
 * Created by fs279 on 12/19/16.
 */
public class Moves {
    public static String [] [] position = {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};
    public static Scanner input = new Scanner(System.in);
    public static boolean [] [] ticTacToe = new boolean[3][3];
    public static boolean player = true;
    public static boolean [] [] playerRecord = new boolean[3][3];
    static void printBoard(){
        System.out.println("    " + position[2][0] +"   |    " + position[2][1] + "   |   " + position[2][2] + "\n________|________|________\n    " + position[1][0] + "   |    " + position[1][1] + "   |   " + position[1][2] + "\n________|________|________\n    " + position[0][0] + "   |    " + position[0][1] + "   |   " + position[0][3] + "\n        |        |\n");
    }
    static void enterCoordinate(){
        System.out.println("Gimme a coordinate on the board. (bottom left being the origin) Template: (x,y)");
        String coor = input.next();
        setter(Integer.parseInt(coor.substring(1,2)), Integer.parseInt(coor.substring(3,4)));
        player = !player;
        playerRecord [Integer.parseInt(coor.substring(1,2))] [Integer.parseInt(coor.substring(3,4))] = player;
    }
    static void setter(int a, int b){
        for(boolean [] i: ticTacToe){
            int pi = 0;
            for(boolean j: i){
                pi++;
                if(i[pi] == true){
                    if(player == true){
                        position[]
                    }
                }
            }
        }
    }
}

package com.company;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        System.out.println("Player 1 is X. Player 2 is O. In person vs computer, person is player 1.");
        System.out.println("PVP=0   PVC=1   CVC=2");
        Scanner mode = new Scanner(System.in);
        int gameMode = mode.nextInt();
        if(gameMode == 0) {
            Moves.pvp();
        }
        else if(gameMode == 1){
            Moves.pvc();
        }
    }
}

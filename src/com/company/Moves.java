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
            System.out.println("It's a tie.");
            printBoard();
        }
    }
    static void cvc(){
        for(int x = 0; x < 4; x++){
            if(continueGame){
                printBoard();
                computerPick2();
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
            computerPick2();
            checkForWin();
        }
        if(continueGame){
            System.out.println("It's a tie.");
            printBoard();
        }
    }
    static void computerPick(){
        player = !player;
        if (position[1][1].equals(" ")) {
            position[1][1] = "O";
        }
        else{
            int k = 0;
            for(int c = 0; c < 3; c++) {
                if(k == 0) {
                    int y = 0;
                    int[] v = new int[2];
                    int l = 0;
                    for (int x = 0; x < 3; x++) {
                        if (position[c][x].equals("O")) {
                            v[y] = x;
                            y++;
                        }
                        if (y == 2 && l == 0) {
                            l++;
                        }
                    }
                    if (y == 2) {
                        int j = 3;
                        for (int i : v) {
                            j = j - i;
                        }
                        if (position[c][j].equals(" ")) {
                            position[c][j] = "O";
                            k = 2;
                            break;
                        }
                    }
                }
            }
            for(int c = 0; c < 3; c++) {
                if(k == 0) {
                    int y = 0;
                    int[] v = new int[2];
                    int l = 0;
                    for (int x = 0; x < 3; x++) {
                        if (position[x][c].equals("O")) {
                            v[y] = x;
                            y++;
                        }
                        if (y == 2 && l == 0) {
                            l++;
                        }
                    }
                    if (y == 2) {
                        int j = 3;
                        for (int i : v) {
                            j = j - i;
                        }
                        if (position[j][c].equals(" ")) {
                            position[j][c] = "O";
                            k = 2;
                            break;
                        }
                    }
                }
            }
            int z = 0;
            if(k != 2) {
                int s = 0;
                int m [] = new int[2];
                for (int x = 0; x < 3; x++) {
                    if (position[x][x] == "O") {
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
                            z = 2;
                            break;
                        }
                    }
                }
            }
            if(z != 2 && k != 2) {
                int s = 0;
                int m [] = new int[2];
                for (int x = 0; x < 3; x++) {
                    if (position[2-x][x] == "O") {
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
                            z = 2;
                            break;
                        }
                    }
                }
            }
            if(k == 0) {
                int o = 0;
                for (int c = 0; c < 3; c++) {
                    if (o == 0) {
                        int y = 0;
                        int[] v = new int[2];
                        int l = 0;
                        for (int x = 0; x < 3; x++) {
                            if (position[c][x].equals("X")) {
                                v[y] = x;
                                y++;
                            }
                            if (y == 2 && l == 0) {
                                l++;
                            }
                        }
                        if (y == 2) {
                            int j = 3;
                            for (int i : v) {
                                j = j - i;
                            }
                            if (position[c][j].equals(" ")) {
                                position[c][j] = "O";
                                o = 2;
                                break;
                            }
                        }
                    }
                }
                for (int c = 0; c < 3; c++) {
                    if (o == 0) {
                        int y = 0;
                        int[] v = new int[2];
                        int l = 0;
                        for (int x = 0; x < 3; x++) {
                            if (position[x][c].equals("X")) {
                                v[y] = x;
                                y++;
                            }
                            if (y == 2 && l == 0) {
                                l++;
                            }
                        }
                        if (y == 2) {
                            int j = 3;
                            for (int i : v) {
                                j = j - i;
                            }
                            if (position[j][c].equals(" ")) {
                                position[j][c] = "O";
                                o = 2;
                                break;
                            }
                        }
                    }
                }
                int l = 0;
                if (o != 2) {
                    int s = 0;
                    int m[] = new int[2];
                    for (int x = 0; x < 3; x++) {
                        if (position[x][x] == "X") {
                            m[s] = x;
                            s++;
                        }
                        if (s == 2) {
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
                int b = 0;
                if (l != 2 && o != 2) {
                    int s = 0;
                    int m[] = new int[2];
                    for (int x = 0; x < 3; x++) {
                        if (position[2 - x][x] == "X") {
                            m[s] = x;
                            s++;
                        }
                        if (s == 2) {
                            int j = 3;
                            for (int i : m) {
                                j -= i;
                            }
                            if (position[2 - j][j].equals(" ")) {
                                position[2 - j][j] = "O";
                                l = 2;
                                b = 2;
                                break;
                            }
                        }
                    }
                }
                if (l != 2 && o != 2 && b != 2 && position[1][1] != "X") {
                    for (int x = 1; x < 3; x++) {
                        for (int y = 1; y < 3; y++) {
                            if (position[x][y].equals(" ")) {
                                position[x][y] = "O";
                                x = 3;
                                break;
                            }
                        }
                    }
                }
                else if(l != 2 && o != 2 && b != 2 && position[1][1] == "X"){
                    for (int x = 0; x < 3; x += 2) {
                        for (int y = 0; y < 3; y += 2) {
                            if (position[x][y].equals(" ")) {
                                position[x][y] = "O";
                                x = 3;
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
    static void computerPick2(){
        player = !player;
        if (position[1][1].equals(" ")) {
            position[1][1] = "X";
        }
        else{
            int k = 0;
            for(int c = 0; c < 3; c++) {
                if(k == 0) {
                    int y = 0;
                    int[] v = new int[2];
                    int l = 0;
                    for (int x = 0; x < 3; x++) {
                        if (position[c][x].equals("X")) {
                            v[y] = x;
                            y++;
                        }
                        if (y == 2 && l == 0) {
                            l++;
                        }
                    }
                    if (y == 2) {
                        int j = 3;
                        for (int i : v) {
                            j = j - i;
                        }
                        if (position[c][j].equals(" ")) {
                            position[c][j] = "X";
                            k = 2;
                            break;
                        }
                    }
                }
            }
            for(int c = 0; c < 3; c++) {
                if(k == 0) {
                    int y = 0;
                    int[] v = new int[2];
                    int l = 0;
                    for (int x = 0; x < 3; x++) {
                        if (position[x][c].equals("X")) {
                            v[y] = x;
                            y++;
                        }
                        if (y == 2 && l == 0) {
                            l++;
                        }
                    }
                    if (y == 2) {
                        int j = 3;
                        for (int i : v) {
                            j = j - i;
                        }
                        if (position[j][c].equals(" ")) {
                            position[j][c] = "X";
                            k = 2;
                            break;
                        }
                    }
                }
            }
            int z = 0;
            if(k != 2) {
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
                            position[j][j] = "X";
                            z = 2;
                            break;
                        }
                    }
                }
            }
            if(z != 2 && k != 2) {
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
                            position[2-j][j] = "X";
                            z = 2;
                            break;
                        }
                    }
                }
            }
            if(k == 0) {
                int o = 0;
                for (int c = 0; c < 3; c++) {
                    if (o == 0) {
                        int y = 0;
                        int[] v = new int[2];
                        int l = 0;
                        for (int x = 0; x < 3; x++) {
                            if (position[c][x].equals("O")) {
                                v[y] = x;
                                y++;
                            }
                            if (y == 2 && l == 0) {
                                l++;
                            }
                        }
                        if (y == 2) {
                            int j = 3;
                            for (int i : v) {
                                j = j - i;
                            }
                            if (position[c][j].equals(" ")) {
                                position[c][j] = "X";
                                o = 2;
                                break;
                            }
                        }
                    }
                }
                for (int c = 0; c < 3; c++) {
                    if (o == 0) {
                        int y = 0;
                        int[] v = new int[2];
                        int l = 0;
                        for (int x = 0; x < 3; x++) {
                            if (position[x][c].equals("O")) {
                                v[y] = x;
                                y++;
                            }
                            if (y == 2 && l == 0) {
                                l++;
                            }
                        }
                        if (y == 2) {
                            int j = 3;
                            for (int i : v) {
                                j = j - i;
                            }
                            if (position[j][c].equals(" ")) {
                                position[j][c] = "X";
                                o = 2;
                                break;
                            }
                        }
                    }
                }
                int l = 0;
                if (o != 2) {
                    int s = 0;
                    int m[] = new int[2];
                    for (int x = 0; x < 3; x++) {
                        if (position[x][x] == "O") {
                            m[s] = x;
                            s++;
                        }
                        if (s == 2) {
                            int j = 3;
                            for (int i : m) {
                                j -= i;
                            }
                            if (position[j][j].equals(" ")) {
                                position[j][j] = "X";
                                l = 2;
                                break;
                            }
                        }
                    }
                }
                int b = 0;
                if (l != 2 && o != 2) {
                    int s = 0;
                    int m[] = new int[2];
                    for (int x = 0; x < 3; x++) {
                        if (position[2 - x][x] == "O") {
                            m[s] = x;
                            s++;
                        }
                        if (s == 2) {
                            int j = 3;
                            for (int i : m) {
                                j -= i;
                            }
                            if (position[2 - j][j].equals(" ")) {
                                position[2 - j][j] = "X";
                                l = 2;
                                b = 2;
                                break;
                            }
                        }
                    }
                }
                if (l != 2 && o != 2 && b != 2 && position[1][1] != "O") {
                    for (int x = 1; x < 3; x++) {
                        for (int y = 1; y < 3; y++) {
                            if (position[x][y].equals(" ")) {
                                position[x][y] = "X";
                                x = 3;
                                break;
                            }
                        }
                    }
                }
                else if(l != 2 && o != 2 && b != 2 && position[1][1] == "O"){
                    for (int x = 0; x < 3; x += 2) {
                        for (int y = 0; y < 3; y += 2) {
                            if (position[x][y].equals(" ")) {
                                position[x][y] = "X";
                                x = 3;
                                break;
                            }
                        }
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
            System.out.println("It's a tie.");
            printBoard();
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
